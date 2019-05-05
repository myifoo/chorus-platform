package com.platform.chorus.web.validator;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.web.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by A.T on 2019/5/1
 */
public class DataValidator {

    @Autowired
    CimService service;


    /**
     *  1. entity type 必须是已定义的 model
     *  2. entity id 必须已存在
     *  3. value's owner type 必须等于 entity type
     */
    public void validate(DataModel meta) {

    }
}
