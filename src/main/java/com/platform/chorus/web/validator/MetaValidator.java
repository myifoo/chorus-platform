package com.platform.chorus.web.validator;

import com.platform.chorus.cimanager.CimService;
import com.platform.chorus.web.exception.BadRequestException;
import com.platform.chorus.web.model.MetaModel;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Create by A.T on 2019/4/30
 */
@Service
public class MetaValidator {
    @Autowired
    CimService service;

    public void validate(MetaModel meta) {
        Set<String> modelNameSet = new HashSet<>(Arrays.asList("boolean", "string", "integer", "long", "float", "double"));
        Set<String> duplicateModel = new HashSet<>();
        Set<String> notFoundModelSet = new HashSet<>();
        Set<String> collectors = new HashSet<>();
        Set<String> duplicateCollector = new HashSet<>();

        List<String> names = service.getModelFullName();
        modelNameSet.addAll(names);

        if (Objects.nonNull(meta.getModels())) {
            meta.getModels().forEach(c-> {
                String fullName = c.getDomain() + "." + c.getName();
                if (modelNameSet.contains(fullName)) {
                    duplicateModel.add(fullName);
                } else {
                    modelNameSet.add(fullName);
                }
            });

            if (!duplicateModel.isEmpty()) {
                throw new BadRequestException("import duplicate class is not allowed : " + String.join(", ", duplicateModel));
            }
        }

        if (Objects.nonNull(meta.getCollectors())) {
            meta.getCollectors().forEach(c->{
                if (Strings.isEmpty(c.getName())) {
                    throw new BadRequestException("collector name should not be empty");
                }

                if (collectors.contains(c.getName())) {
                    duplicateCollector.add(c.getName());
                } else {
                    collectors.add(c.getName());
                }

                if (!modelNameSet.contains(c.getResult())) {
                    notFoundModelSet.add(c.getResult());
                }

                for (String type : c.getInjects()) {
                    if (!modelNameSet.contains(type)) {
                        notFoundModelSet.add(type);
                    }
                }
            });

            if (!duplicateCollector.isEmpty()) {
                throw new BadRequestException(" import duplicate collector is not allowed : " + String.join(", ", duplicateCollector));
            }

        }

        if (Objects.nonNull(meta.getFields())) {
            meta.getFields().forEach(f->{
                if (Strings.isEmpty(f.getOwner())) {
                    throw new BadRequestException("field's owner should not be empty");
                }

                if (!modelNameSet.contains(f.getOwner())) {
                    notFoundModelSet.add(f.getOwner());
                }

                if (!modelNameSet.contains(f.getType())) {
                    notFoundModelSet.add(f.getType());
                }
            });

            if (!notFoundModelSet.isEmpty()) {
                throw new BadRequestException(" class not found error : " + String.join(", ", notFoundModelSet));
            }
        }
    }
}
