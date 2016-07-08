package org.quickmvc.core.dao.cache;

import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created by faith on 16/5/30.
 */
public abstract class BaseCacheDao<Model, Primary> {

    protected RuntimeSchema schema = getProtobufSchema();


    protected Log log = LogFactory.getLog(BaseCacheDao.class);
    /**
     * redis 连接池
     */
    protected final JedisPool jedisPool;

    public BaseCacheDao(String ip, int port) {
        this.jedisPool = new JedisPool(ip, port);
    }

    protected abstract Model getModelFromCache(Jedis jedis, Primary primary);

    public Model getModel(Primary primary) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                return getModelFromCache(jedis, primary);
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    protected abstract String putModelIntoCache(Jedis jedis, Model model);

    protected abstract RuntimeSchema getProtobufSchema();

    public String putModel(Model model) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                return putModelIntoCache(jedis, model);
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

}
