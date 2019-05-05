package com.platform.chorus.cimanager;

import com.platform.chorus.jooq.tables.pojos.*;

import java.util.List;

/**
 *
 *      CI Manager:
 *
 *          - Meta Model/Relationship's CURD
 *          -
 *
 * Create by A.T on 2019/4/30
 */
public interface CimService {
    /**
     *  delete all information in database, include model, field, collector, entity, value
     */
    void clear();

    /**
     *  get model table records in html format
     */
    String getModelHtml();

    /**
     *  get field table records in html format
     */
    String getFieldHtml();

    /**
     *  get collector table records in html format
     */
    String getCollectorHtml();

    /**
     *  get all models
     *
     *  @return List
     */
    List<Model> getModels();

    /**
     *  get full name list of base models by model type.
     *
     *  Model 只支持单继承，该方法返回类的所有基类的名称
     *
     * @param type model domain + model name
     * @return List of model full name
     */
    List<String> getExtends(String type);

    /**
     *  get all fields
     *
     * @return List
     */
    List<Field> getFields();

    /**
     *  get fields by owner
     *
     * @param owner model domain + model name
     * @return List
     */
    List<Field> getFields(String owner);

    /**
     *  get all collectors
     *
     * @return List
     */
    List<Collector> getCollectors();

    /**
     *  当且仅当两个 Entity 的所有 Value 值相同时，认为两个 Entity 相同。
     *
     *  该方法根据给定的 Value 集合，获取已存在的 Entity 的 id，当没有未找到对应 Entity 时，返回 null
     *
     * @param values list of Value
     * @return null if not found
     *
     */
    Integer getEntityIdByValues(List<Value> values);

    /**
     * create model
     *
     * @return model id
     */
    Integer createModel(Model model);

    /**
     *  create field
     *
     * @return field id
     */
    Integer createField(Field field);

    /**
     *  create collector
     *
     * @return collector id
     */
    Integer createCollector(Collector collector);

    /**
     *  create entity
     *
     * @return entity id
     */
    Integer createEntity(Entity entity);

    /**
     *  create value
     *
     * @return value id
     */
    Integer createValue(Value value);

    /**
     *  create entity with entity instance and its values
     *
     * @return entity id
     */
    Integer createEntity(Entity entity, List<Value> values);

    /**
     *  create multiple models
     */
    List<Integer> createModels(List<Model> models);

    /**
     *  create multiple fields
     */
    List<Integer> createFields(List<Field> fields);

    /**
     *  create multiple collectors
     */
    List<Integer> createCollectors(List<Collector> collectors);

    /**
     *  create multiple entities
     */
    List<Integer> createEntities(List<Entity> entities);

    /**
     *  create multiple values
     */
    List<Integer> createValues(List<Value> values);

    /**
     *  delete model by domain and name
     */
    void deleteModel(String domain, String name);

    /**
     *  delete field by owner and name
     */
    void deleteField(String owner, String name);

    /**
     *  delete model by name
     */
    void deleteCollector(String name);

    /**
     *  get model full name list
     */
    List<String> getModelFullName();

}
