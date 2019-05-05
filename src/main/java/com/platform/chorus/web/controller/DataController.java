package com.platform.chorus.web.controller;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.jooq.tables.pojos.Entity;
import com.platform.chorus.jooq.tables.pojos.Value;
import com.platform.chorus.web.model.DataModel;
import com.platform.chorus.web.model.SuccessBody;
import com.platform.chorus.web.validator.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Create by A.T on 2019/4/30
 */
@Controller
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private CimService cimService;

    @Autowired
    private DataValidator validator;

    @RequestMapping(value = "/entity", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> createEntity(@RequestBody DataModel data) {
        validator.validate(data);

        try {
            create(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new SuccessBody("create single entity success", null), HttpStatus.OK);
    }


    /**
     *  这里使用递归方式去创建 entity：
     *
     *  1. entity 中只保存其直接引用的 entity 的 id，保证模型结构尽量简单；
     *  2. 当 DataModel 中的 refs 不为空时，先创建其对应的 entity，并获得对应的 id；
     *  3. 如果 refs 对应的 entity 已存在，则获取其对应的 id；
     */
    private Integer create(DataModel model) {
        Entity root = new Entity();
        root.setName(model.getName());
        root.setAssociate(model.getAssociate());
        root.setType(model.getType());
        root.setCreator(model.getCreator());
        root.setDescription(model.getDescription());
        root.setTags(model.getTags());
        root.setGrade(model.getGrade());

        List<Value> owns = new LinkedList<>();
        model.getValues().forEach(v-> owns.add(map(v)));

        List<Integer> ids = Arrays.asList(root.getAssociate());
        if (Objects.nonNull(model.getRefs()) && !model.getRefs().isEmpty()) {
            ids.addAll(model.getRefs().stream().map(this::create).collect(Collectors.toList()));
        }

        root.setAssociate(ids.toArray(new Integer[0]));
        return cimService.createEntity(root, owns);
    }

    /**
     *  DataModel 对象中的 values 是 string 数组，分别对应 ["model type", "field name", "value type", "value",]
     *
     * @param source ["model type", "field name", "value type", "value",]
     * @return Value instance
     */
    private Value map(String [] source) {
        Value value = new Value();
        value.setName(source[0]+"."+ source[1]); // todo 是否这样的设计更合理呢？是否有其必要
        value.setType(source[2]);
        value.setValue(source[3]);
        return value;
    }

}
