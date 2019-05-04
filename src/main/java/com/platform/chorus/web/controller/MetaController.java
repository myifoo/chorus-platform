package com.platform.chorus.web.controller;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.jooq.tables.pojos.Collector;
import com.platform.chorus.jooq.tables.pojos.Field;
import com.platform.chorus.jooq.tables.pojos.Model;
import com.platform.chorus.web.model.ErrorBody;
import com.platform.chorus.web.model.MetaModel;
import com.platform.chorus.web.model.ResponseBody;
import com.platform.chorus.web.model.SuccessBody;
import com.platform.chorus.web.validator.MetaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create by A.T on 2019/4/30
 */
@Controller
@RequestMapping(value = "/meta")
public class MetaController {
    @Autowired
    private CimService cimService;

    @Autowired
    private MetaValidator validator;

    @RequestMapping(value = "/import", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> importMeta(@RequestBody MetaModel meta) {
        validator.validate(meta);
        cimService.createModels(meta.getModels());
        cimService.createCollectors(meta.getCollectors());
        cimService.createFields(meta.getFields());

        return new ResponseEntity<>(new SuccessBody("import meta success", null), HttpStatus.OK);
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public ResponseEntity<? extends ResponseBody> clear() {
        cimService.clear();
        return new ResponseEntity<>(new SuccessBody("clear meta success", null), HttpStatus.OK);
    }

    @RequestMapping(value = "/model/extends", produces = "application/json")
    public ResponseEntity<? extends ResponseBody> getExtends(@RequestParam(name = "type") String type) {
        return new ResponseEntity<>(new SuccessBody("get model's extends success", cimService.getExtends(type)), HttpStatus.OK);
    }

    @RequestMapping(value = "/model/fields", produces = "application/json")
    public ResponseEntity<? extends ResponseBody> getFields(@RequestParam(name = "owner") String owner) {
        return new ResponseEntity<>(new SuccessBody("get model's fields success", cimService.getFields(owner)), HttpStatus.OK);
    }

    @RequestMapping(value = "/model", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> createModel(@RequestBody Model model) {
        return new ResponseEntity<>(new SuccessBody("create single model success", cimService.createModel(model)), HttpStatus.OK);
    }

    @RequestMapping(value = "/collector", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> createCollector(@RequestBody Collector collector) {
        return new ResponseEntity<>(new SuccessBody("create single model success", cimService.createCollector(collector)), HttpStatus.OK);
    }

    @RequestMapping(value = "/field", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> createField(@RequestBody Field field) {
        return new ResponseEntity<>(new SuccessBody("create single field success", cimService.createField(field)), HttpStatus.OK);
    }

    @RequestMapping(value = "/model/html", produces = "text/html", method = RequestMethod.GET)
    public ResponseEntity<String> getModelHtml() {
        return new ResponseEntity<>(cimService.getModelHtml(), HttpStatus.OK);
    }

    @RequestMapping(value = "/field/html", produces = "text/html", method = RequestMethod.GET)
    public  ResponseEntity<String> getFieldHtml() {
        return new ResponseEntity<>(cimService.getFieldHtml(), HttpStatus.OK);
    }

    @RequestMapping(value = "/collector/html", produces = "text/html", method = RequestMethod.GET)
    public  ResponseEntity<String> getCollectorHtml() {
        return new ResponseEntity<>(cimService.getCollectorHtml(), HttpStatus.OK);
    }

    @RequestMapping(value = "/model/name", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<? extends ResponseBody> getModelName() {
        return new ResponseEntity<>(new SuccessBody("get model names", cimService.getModelFullName()), HttpStatus.OK);
    }
}
