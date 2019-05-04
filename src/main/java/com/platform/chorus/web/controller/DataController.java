package com.platform.chorus.web.controller;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.jooq.tables.pojos.Entity;
import com.platform.chorus.jooq.tables.pojos.Value;
import com.platform.chorus.web.model.DataModel;
import com.platform.chorus.web.model.SuccessBody;
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

    @RequestMapping(value = "/simple/entity", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> createSimpleEntity(@RequestBody DataModel data) {
        Entity root = new Entity();
        root.setName(data.getName());
        root.setAssociate(data.getAssociate());
        root.setType(data.getType());
        root.setCreator(data.getCreator());
        root.setDescription(data.getDescription());
        root.setTags(data.getTags());
        root.setGrade(data.getGrade());

        List<Value> owns = new LinkedList<>();
        data.getValues().forEach(v-> owns.add(map(v)));

        if (Objects.nonNull(data.getRefs()) && !data.getRefs().isEmpty()) {

        }

        cimService.createEntity(root, owns);
        return new ResponseEntity<>(new SuccessBody("create single entity success", root.getId()), HttpStatus.OK);
    }

    @RequestMapping(value = "/entity", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<?> createEntity(@RequestBody DataModel data) {
        try {
            create(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new SuccessBody("create single entity success", null), HttpStatus.OK);
    }

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

    private Value map(String [] source) {
        Value value = new Value();
        value.setName(source[0]+"."+ source[1]);
        value.setType(source[2]);
        value.setValue(source[3]);
        return value;
    }

}
