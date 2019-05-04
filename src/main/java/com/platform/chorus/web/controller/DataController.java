package com.platform.chorus.web.controller;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.jooq.tables.pojos.Entity;
import com.platform.chorus.web.model.ResponseBody;
import com.platform.chorus.web.model.SuccessBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by A.T on 2019/4/30
 */
@RequestMapping(value = "/data")
public class EntityController {
    @Autowired
    private CimService cimService;

    @RequestMapping(value = "/entity", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> createModel(@RequestBody Entity entity) {
        return new ResponseEntity<>(new SuccessBody("create single entity success", cimService.createEntity(entity)), HttpStatus.OK);
    }
}
