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
public class AbstractEntityService implements EntityService {
    protected Entity entity;
    protected List<Value> values;
    private EntityDao entityDao;
    private ValueDao valueDao;

    public AbstractEntityService(Entity entity, List<Value> values, EntityDao entityDao, ValueDao valueDao) {
        this.entity = entity;
        this.values = values;
        this.entityDao = entityDao;
        this.valueDao = valueDao;
    }

    @Override
    public void create() {
        entityDao.insert(entity);
        values.forEach(v->v.setOwner(entity.getId()));
        valueDao.insert(values);
    }

    @Override
    public void delete() {
    }
}
