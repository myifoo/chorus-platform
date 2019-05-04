package com.platform.chorus.cimanager;

import com.platform.chorus.cimanager.exception.DataAccessException;
import com.platform.chorus.cimanager.exception.GraphAccessException;
import com.platform.chorus.cimanager.graph.CollectorGraph;
import com.platform.chorus.cimanager.graph.EntityGraph;
import com.platform.chorus.cimanager.graph.FieldGraph;
import com.platform.chorus.cimanager.graph.ModelGraph;
import com.platform.chorus.jooq.tables.daos.*;
import com.platform.chorus.jooq.tables.pojos.*;
import com.platform.chorus.neo4j.GraphService;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.platform.chorus.jooq.Tables.*;

/**
 * Create by A.T on 2019/4/30
 */
@Component
public class CimServiceImpl implements CimService {
    static private final Logger logger = LoggerFactory.getLogger(CimServiceImpl.class);

    private ModelGraph modelGraph;
    private FieldGraph fieldGraph;
    private CollectorGraph collectorGraph;
    private EntityGraph entityGraph;
    private ModelDao modelDao;
    private FieldDao fieldDao;
    private CollectorDao collectorDao;
    private EntityDao entityDao;
    private ValueDao valueDao;
    private DSLContext dsl;
    private GraphService graphService;

    public CimServiceImpl(
            ModelGraph modelGraph,
            FieldGraph fieldGraph,
            CollectorGraph collectorGraph,
            EntityGraph entityGraph,
            ModelDao modelDao,
            FieldDao fieldDao,
            CollectorDao collectorDao,
            EntityDao entityDao,
            ValueDao valueDao,
            DSLContext dsl,
            GraphService graphService
    ) {
        this.modelGraph = modelGraph;
        this.fieldGraph = fieldGraph;
        this.collectorGraph = collectorGraph;
        this.entityGraph = entityGraph;
        this.modelDao = modelDao;
        this.fieldDao = fieldDao;
        this.collectorDao = collectorDao;
        this.entityDao = entityDao;
        this.valueDao = valueDao;
        this.dsl = dsl;
        this.graphService = graphService;
    }

    @Override
    public void clear() {
        dsl.delete(MODEL).where(MODEL.ID.gt(0)).execute();
        dsl.delete(COLLECTOR).where(COLLECTOR.ID.gt(0)).execute();
        dsl.delete(FIELD).where(FIELD.ID.gt(0)).execute();
        dsl.delete(ENTITY).where(ENTITY.ID.gt(0)).execute();
        dsl.delete(VALUE).where(VALUE.ID.gt(0)).execute();
        graphService.clear();
    }

    @Override
    public String getModelHtml() {
        return dsl.select().from(MODEL).fetch().formatHTML();
    }

    @Override
    public String getFieldHtml() {
        return dsl.select().from(FIELD).fetch().formatHTML();
    }

    @Override
    public String getCollectorHtml() {
        return dsl.select().from(COLLECTOR).fetch().formatHTML();
    }

    @Override
    public List<Model> getModels() {
        return modelDao.findAll();
    }

    @Override
    public List<String> getExtends(String type) {
        List<String> types = null;
        try {
            types = modelGraph.getExtendType(type);
        } catch (Exception e) {
            throwGraphAccessException("fetch related type failed", e);
        }

        return types;
    }

    @Override
    public List<Field> getFields() {
        return fieldDao.findAll();
    }

    @Override
    public List<Field> getFields(String owner) {

        List<String> types = null;
        try {
            types = modelGraph.getRelatedType(owner);
        } catch (Exception e) {
            throwGraphAccessException("fetch related type failed", e);
        }

        return fieldDao.fetchByOwner(types.toArray(new String[0]));
    }

    @Override
    public List<Collector> getCollectors() {
        return collectorDao.findAll();
    }


    @Override
    public Integer getEntityIdByValues(List<Value> values) {
        List<Integer> list = new ArrayList<>();

        for (Value value : values) {
            List<Integer> ids = dsl.select().from(VALUE)
                    .where(VALUE.NAME.eq(value.getName()))
                    .and(VALUE.TYPE.eq(value.getType()))
                    .and(VALUE.VALUE_.eq(value.getValue()))
                    .fetch(VALUE.OWNER);

            if (Objects.isNull(ids) || ids.isEmpty()) {
                return null;
            }

            if (list.isEmpty()) {
                list.addAll(ids);
            } else {
                list.retainAll(ids);
                if (list.isEmpty()) {
                    return null;
                }
            }
        }

        return list.stream().distinct().collect(Collectors.toList()).get(0);
    }

    @Override
    public Integer createModel(Model model) {
        logger.info("create model : {}", model.toString());

        try {
            modelDao.insert(model);
        } catch (Exception e) {
            throwDataAccessException("create model failed ", e);
        }

        try {
            modelGraph.create(model);
        } catch (Exception e) {
            throwGraphAccessException("create model graph node failed", e);
        }

        return model.getId();
    }

    @Override
    public Integer createField(Field field) {
        logger.info("create field : {}", field.toString());

        try {
            fieldDao.insert(field);
        } catch (Exception e) {
            throwDataAccessException("create field failed ", e);
        }

        try {
            fieldGraph.create(field);
        } catch (Exception e) {
            throwGraphAccessException("create field graph node failed", e);
        }

        return field.getId();
    }

    @Override
    public Integer createCollector(Collector collector) {
        logger.info("create collector : {}", collector.toString());

        try {
            collectorDao.insert(collector);
        } catch (Exception e) {
            throwDataAccessException("create collector failed ", e);
        }

        try {
            collectorGraph.create(collector);
        } catch (Exception e) {
            throwGraphAccessException("create collector graph node failed", e);
        }

        return collector.getId();
    }

    @Override
    public Integer createEntity(Entity entity) {
        logger.info("create entity : {}", entity.toString());

        try {
            entityDao.insert(entity);
        } catch (Exception e) {
            throwDataAccessException("create entity failed ", e);
        }

        try {
            entityGraph.create(entity);
        } catch (Exception e) {
            throwGraphAccessException("create entity graph node failed", e);
        }

        return entity.getId();
    }

    @Override
    public Integer createValue(Value value) {
        logger.debug("create value : {}", value.toString());

        try {
            valueDao.insert(value);
        } catch (Exception e) {
            throwDataAccessException("create value failed ", e);
        }
        return value.getId();
    }

    @Override
    public Integer createEntity(Entity entity, List<Value> values) {
        Integer id = getEntityIdByValues(values);

        if (Objects.nonNull(id)) {
            return id;
        }

        entityDao.insert(entity);
        values.forEach(v-> v.setOwner(entity.getId()));
        valueDao.insert(values);
        return entity.getId();
    }

    @Override
    public List<Integer> createModels(List<Model> models) {
        if (Objects.isNull(models) || models.isEmpty()) {
            logger.error("models is null");
            return null;
        }

        try {
            modelDao.insert(models);
        } catch (Exception e) {
            throwDataAccessException("create models failed ", e);
        }

        try {
            models.forEach(model-> modelGraph.create(model));
        } catch (Exception e) {
            throwGraphAccessException("create models graph node failed", e);
        }

        return models.stream().map(Model::getId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> createFields(List<Field> fields) {
        if (Objects.isNull(fields) || fields.isEmpty()) {
            logger.error("fields is null");
            return null;
        }

        try {
            fieldDao.insert(fields);
        } catch (Exception e) {
            throwDataAccessException("create fields failed ", e);
        }

        try {
            fields.forEach(field->fieldGraph.create(field));
        } catch (Exception e) {
            throwGraphAccessException("create fields graph node failed", e);
        }

        return fields.stream().map(Field::getId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> createCollectors(List<Collector> collectors) {
        if (Objects.isNull(collectors) || collectors.isEmpty()) {
            logger.error("collectors is null");
            return null;
        }

        try {
            collectorDao.insert(collectors);
        } catch (Exception e) {
            throwDataAccessException("create collectors failed ", e);
        }

        try {
            collectors.forEach(collector->collectorGraph.create(collector));
        } catch (Exception e) {
            throwGraphAccessException("create collectors graph node failed", e);
        }

        return collectors.stream().map(Collector::getId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> createEntities(List<Entity> entities) {
        try {
            entityDao.insert(entities);
        } catch (Exception e) {
            throwDataAccessException("create entities failed ", e);
        }

        try {
            entities.forEach(entity -> entityGraph.create(entity));
        } catch (Exception e) {
            throwGraphAccessException("create entity graph node failed", e);
        }

        return entities.stream().map(Entity::getId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> createValues(List<Value> values) {
        try {
            valueDao.insert(values);
        } catch (Exception e) {
            throwDataAccessException("create values failed ", e);
        }

        return values.stream().map(Value::getId).collect(Collectors.toList());
    }

    @Override
    public void deleteModel(String domain, String name) {
        logger.info("delete model : domain = {}, name = {}", domain, name);
        try {
            dsl.delete(MODEL)
                    .where(MODEL.NAME.eq(name))
                    .and(MODEL.DOMAIN.eq(domain))
                    .execute();
        } catch (Exception e) {
            throwDataAccessException("delete model failed", e);
        }

        try {
            Model model = new Model();
            model.setDomain(domain);
            model.setName(name);
            modelGraph.delete(model);
        } catch (Exception e) {
            throwGraphAccessException("delete model graph node failed", e);
        }
    }

    @Override
    public void deleteField(String owner, String name) {
        logger.info("delete field : owner = {}, name = {}", owner, name);
        try {
            dsl.delete(FIELD)
                    .where(FIELD.NAME.eq(name))
                    .and(FIELD.OWNER.eq(owner))
                    .execute();
        } catch (Exception e) {
            throwDataAccessException("delete field failed", e);
        }

        try {
            Field field = new Field();
            field.setOwner(owner);
            field.setName(name);
            fieldGraph.delete(field);
        } catch (Exception e) {
            throwGraphAccessException("delete field graph node failed", e);
        }
    }

    @Override
    public void deleteCollector(String name) {
        logger.info("delete collector : name = {}", name);
        try {
            dsl.delete(COLLECTOR)
                    .where(COLLECTOR.NAME.eq(name))
                    .execute();
        } catch (Exception e) {
            throwDataAccessException("delete collector failed", e);
        }

        try {
            Collector collector = new Collector();
            collector.setName(name);
            collectorGraph.delete(collector);
        } catch (Exception e) {
            throwGraphAccessException("delete field graph node failed", e);
        }
    }

    @Override
    public List<String> getModelFullName() {
        try {
            return dsl.resultQuery("select concat(domain,'.',name) from public.model") // hard coding
                    .fetch()
                    .getValues(0, String.class);
        } catch (Exception e) {
            throwDataAccessException("get model full name failed", e);
            return null;
        }
    }

    private void throwDataAccessException(String message, Exception e) {
        logger.error(String.format("%s: [ %s ] caused by %s", message, e.getClass().getSimpleName(), e.getMessage()));
        throw new DataAccessException(message);
    }

    private void throwGraphAccessException(String message, Exception e) {
        logger.error(String.format("%s: [ %s ] caused by %s", message, e.getClass().getSimpleName(), e.getMessage()));
        throw new GraphAccessException(message);
    }
}
