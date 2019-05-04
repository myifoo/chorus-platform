package com.platform.chorus.web;

import com.platform.chorus.cimanager.exception.DaoException;
import com.platform.chorus.web.exception.BadRequestException;
import com.platform.chorus.web.model.ErrorBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by A.T on 2019/4/29
 */
@ControllerAdvice
public class ChorusControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DaoException.class)
    @ResponseBody
    ResponseEntity<?> handleDaoException(HttpServletRequest request, Throwable e) {
        return new ResponseEntity<>(new ErrorBody(e.getMessage(), e.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    ResponseEntity<?> handleBadRequestException(HttpServletRequest request, Throwable e) {
        return new ResponseEntity<>(new ErrorBody(e.getMessage(), e.getClass().getSimpleName(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

}
