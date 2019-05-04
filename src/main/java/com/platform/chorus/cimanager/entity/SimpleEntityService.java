package com.platform.chorus.cimanager.entity;

import com.platform.chorus.jooq.tables.daos.EntityDao;
import com.platform.chorus.jooq.tables.daos.ValueDao;
import com.platform.chorus.jooq.tables.pojos.Entity;
import com.platform.chorus.jooq.tables.pojos.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Create by A.T on 2019/5/1
 */
public class SimpleEntityService extends AbstractEntityService {
    final static private Logger logger = LoggerFactory.getLogger(SimpleEntityService.class);

    public SimpleEntityService(Entity entity, List<Value> values, EntityDao entityDao, ValueDao valueDao) {
        super(entity, values, entityDao, valueDao);
    }
}
