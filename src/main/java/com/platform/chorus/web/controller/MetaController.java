package com.platform.chorus.web.controller;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.jooq.tables.pojos.Model;
import com.platform.chorus.web.model.ErrorBody;
import com.platform.chorus.web.model.ResponseBody;
import com.platform.chorus.web.model.SuccessBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Create by A.T on 2019/4/30
 */
@Controller
@RequestMapping(value = "/meta")
public class MetaController {
    @Autowired
    CimService cimService;

    @RequestMapping(value = "/class", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity<? extends ResponseBody> createClass(@RequestBody Model model) {

        return new ResponseEntity<>(new SuccessBody("createClass single class model success", cimService.createModel(model)), HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/classes", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
//    public ResponseEntity<? extends ResponseBody> createClass(@RequestBody List<ClassModel> models) {
//        try {
//            SuccessResponseBody response = new SuccessResponseBody();
//            response.setMessage("createClass class model success");
//            response.setResult(service.createClass(models));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getClass().getName()), HttpStatus.NOT_IMPLEMENTED);
//        }
//    }
//
//    @RequestMapping(value = "/classes", produces = "application/json", method = RequestMethod.GET)
//    public ResponseEntity<? extends ResponseBody> getAllClass() {
//        try {
//            SuccessResponseBody response = new SuccessResponseBody();
//            response.setMessage("get all class models success");
//            response.setResult(service.getAllClass());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getClass().getName()), HttpStatus.NOT_IMPLEMENTED);
//        }
//    }
//
//    @RequestMapping(value = "/classes/html", produces = "text/html", method = RequestMethod.GET)
//    public String getAllClassHtml() {
//        try {
//            return service.getClassHtml();
//        } catch (Exception e) {
//            return "ERROR";
//        }
//    }
//
//    @RequestMapping(value = "/classes/name", produces = "application/json", method = RequestMethod.GET)
//    public ResponseEntity<? extends ResponseBody> getAllClassFullName() {
//        try {
//            SuccessResponseBody response = new SuccessResponseBody();
//            response.setMessage("get all class model names success");
//            response.setResult(service.getAllClassFullName());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getClass().getName()), HttpStatus.NOT_IMPLEMENTED);
//        }
//    }
//
//    @RequestMapping(value = "/collectors/html", produces = "text/html", method = RequestMethod.GET)
//    public String getAllCollectorHtml() {
//        try {
//            return service.getClassHtml();
//        } catch (Exception e) {
//            return "ERROR";
//        }
//    }
//
//    @RequestMapping(value = "/field", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
//    public ResponseEntity<? extends ResponseBody> createField(@RequestBody FieldModel model) {
//        try {
//            SuccessResponseBody response = new SuccessResponseBody();
//            response.setMessage("createClass single field model success");
//            response.setResult(service.createField(model));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getClass().getName()), HttpStatus.NOT_IMPLEMENTED);
//        }
//    }
//
//    @RequestMapping(value = "/fields", produces = "application/json", method = RequestMethod.GET)
//    public ResponseEntity<? extends ResponseBody> getAllField() {
//        try {
//            SuccessResponseBody response = new SuccessResponseBody();
//            response.setMessage("get all field models success");
//            response.setResult(service.getAllField());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErrorResponseBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getClass().getName()), HttpStatus.NOT_IMPLEMENTED);
//        }
//    }
//
//    @RequestMapping(value = "/fields/html", produces = "text/html", method = RequestMethod.GET)
//    public String getAllFieldHtml() {
//        try {
//            return service.getFieldHtml();
//        } catch (Exception e) {
//            return "ERROR";
//        }
//    }
}
