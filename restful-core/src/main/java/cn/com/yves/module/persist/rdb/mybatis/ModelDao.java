/**   
 * Filename:    ModelDao.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.mybatis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 数据库表操作的抽象类(数据库中,不做事务处理,关闭连接放到Service中,以及一些资源安全操作上锁,也放在Service中比较好,不然很影响性能.)
 * 
 * @author Yves He
 * 
 * @param <M>
 *            数据库表中对应的model类
 * @param <K>
 *            数据库表中对应的主键类
 */
public abstract class ModelDao<M, K> {

    /**
     * 保存对象到数据库中
     * 
     * 
     * Id为null, 或Id在数据库中无对应值, 则表现为新增(注意有联合主键的表)
     * 
     * @param model
     * @return
     * @throws RDBException
     */
    public abstract K save(M model) throws RDBException;

    /**
     * 保存多个对象到数据库中
     * 
     * @param models
     * @throws RDBException
     */
    public void saveAll(Collection<M> models) throws RDBException {
        if (models != null) {
            for (M m : models) {
                this.save(m);
            }
        }
    }

    /**
     * 删除主键对应的数据
     * 
     * @param key
     * @throws RDBException
     */
    public abstract void del(K key) throws RDBException;

    /**
     * 删除多个keys对应的数据
     * 
     * @param keys
     * @throws RDBException
     */
    public void delAll(Collection<K> keys) throws RDBException {
        if (keys != null) {
            for (K key : keys) {
                this.del(key);
            }
        }
    }

    /**
     * 根据主键获取对象
     * 
     * @param key
     * @return
     * @throws RDBException
     */
    public abstract M getByPrimaryKey(K key) throws RDBException;

    /**
     * 根据多个主键获取多个数据对象
     * 
     * @param keys
     * @return
     * @throws RDBException
     */
    public List<M> getByPrimaryKeys(Collection<K> keys) throws RDBException {
        List<M> result = new ArrayList<M>();
        if (keys != null) {
            for (K k : keys) {
                M model = this.getByPrimaryKey(k);
                if (model != null) {
                    result.add(model);
                }
            }
        }
        return result;
    }

    /**
     * 获取所有对象数据
     * 
     * @return
     * @throws RDBException
     */
    public abstract List<M> getAll() throws RDBException;

}
