package org.quickmvc.core.dao.cache;

import com.dyuproject.protostuff.runtime.RuntimeSchema;



/**
 * Created by faith on 16/5/31.
 */

public class ProtobufSchemaFactory {

    private ProtobufSchemaFactory() {

    }

    private static ProtobufSchemaFactory instance = new ProtobufSchemaFactory();

    public static ProtobufSchemaFactory getInstance() {
        return  instance;
    }

    public static RuntimeSchema buildSchema(Class model) {
         RuntimeSchema schema =  RuntimeSchema.createFrom(model);
        return schema;
    }


}
