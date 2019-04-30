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
    String getModelHtml();
    String getFieldHtml();
    String getCollectorHtml();

    List<Model> getModels();
    List<Field> getFields();
    List<Field> getFields(String owner);
    List<Collector> getCollectors();

    Integer createModel(Model model);
    Integer createField(Field field);
    Integer createCollector(Collector collector);
    Integer createEntity(Entity entity);
    Integer createValue(Value value);

    List<Integer> createModels(List<Model> models);
    List<Integer> createFields(List<Field> fields);
    List<Integer> createCollectors(List<Collector> collectors);
    List<Integer> createEntities(List<Entity> entities);
    List<Integer> createValues(List<Value> values);

    void deleteModel(String domain, String name);
    void deleteField(String owner, String name);
    void deleteCollector(String name);

    List<String> getModelFullName();

}
