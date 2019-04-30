package com.platform.chorus.cimanager.graph;

/**
 * Create by A.T on 2019/4/30
 */
public interface Graph<E>  {
    String EXTEND = "extend";       // class model extend class model
    String REFERENCE = "reference"; // class model reference class model
    String INSTANCE = "instance";   // class model instance item entity
    String OWN = "own";             // class model contain field model
    String CONTAIN = "contain";     // item entity contain item entity
    String RETURN = "return";       // collector return data type
    String REQUIRE = "require";     // collector require data type
    String COLLECT = "collect";     // collector require data type

    default String buildCommonId(String path) {
        return String.join(":", path.split("\\."));
    }

    default String buildClassNodeId(String classPath) {
        return String.format("%s:%s", "class", buildCommonId(classPath));
    }

    void create(E node);
    void delete(E node);
}
