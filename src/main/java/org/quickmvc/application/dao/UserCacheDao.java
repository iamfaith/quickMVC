package org.quickmvc.application.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.quickmvc.application.model.User;
import org.quickmvc.core.dao.cache.BaseCacheDao;
import org.quickmvc.core.dao.cache.ProtobufSchemaFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by faith on 16/5/31.
 */
public class UserCacheDao extends BaseCacheDao<User, Integer> {
    /**
     * redis 的端口和ip
     *
     * @param ip
     * @param port
     */
    public UserCacheDao(String ip, int port) {
        super(ip, port);
    }

    protected User getModelFromCache(Jedis jedis, Integer userId) {
        String key = "user:" + userId;
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes != null) {
            User user = (User) super.schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, user, super.schema);
            return user;
        }

        return null;
    }


    protected String putModelIntoCache(Jedis jedis, User user) {
        String key = "user:" + user.getId();
        byte[] bytes = ProtostuffIOUtil.toByteArray(user, super.schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

//        超时缓存
        int timeout = 60 * 60; // one hour
        String result = jedis.setex(key.getBytes(), timeout, bytes);
        return result;

    }

    protected RuntimeSchema getProtobufSchema() {
        RuntimeSchema schema = ProtobufSchemaFactory.getInstance().buildSchema(User.class);
        return schema;
    }
}
