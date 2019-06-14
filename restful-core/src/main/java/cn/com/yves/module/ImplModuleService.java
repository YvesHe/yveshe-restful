/**   
 * Filename:    ImplModuleService.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-7
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.com.yves.module.bo.UserBo;
import cn.com.yves.module.bo.filter.UserFilter;
import cn.com.yves.module.core.logger.InfraLogger;
import cn.com.yves.module.core.utils.MetaObjectUtil;
import cn.com.yves.module.core.utils.Po2BoUtils;
import cn.com.yves.module.persist.rdb.mybatis.RDBException;
import cn.com.yves.module.persist.rdb.mybatis.RDBManager;
import cn.com.yves.module.persist.rdb.mybatis.impl.UserModelDaoImpl;
import cn.com.yves.module.persist.rdb.mybatis.model.UserModel;

public class ImplModuleService implements IModuleService {

    private final InfraLogger logger = new InfraLogger(ImplModuleService.class);

    private final UserModelDaoImpl dao = UserModelDaoImpl.getInstance();

    public String saveUser(UserBo user) throws ModuleException {
        logger.debug("invoke saveUser.");
        if (user == null) {
            throw new ModuleException("save-user error,user is null.");
        }

        String id = null;
        // 将Bo转化为Po
        UserModel model = Po2BoUtils.getBo(user, UserModel.class);

        try {
            id = dao.save(model);
            RDBManager.getRDBManager().commit();
        } catch (RDBException e) {
            RDBManager.getRDBManager().rollback();
            new ModuleException("save-user error,message:" + e.getMessage());
        }
        return id;
    }

    public void delUser(String id) throws ModuleException {
        logger.debug("invoke delUser.");
        if (StringUtils.isBlank(id)) {
            logger.debug("del-user not do nothing,the id is blandk.");
            return;
        }

        try {
            dao.del(id);
            RDBManager.getRDBManager().commit();
        } catch (RDBException e) {
            RDBManager.getRDBManager().rollback();
            throw new ModuleException("del-user error,message: " + e.getMessage());
        }

    }

    public UserBo getUserByPrimaryKey(String id) throws ModuleException {// 查询操作是不需要事务支持的.
        logger.debug("invoke getUserByPrimaryKey.");
        if (StringUtils.isBlank(id)) {
            logger.debug("get-user-by-primary-key not do nothing,the id is blandk.");
            return null;
        }

        UserBo result = null;
        try {
            try {
                UserModel model = dao.getByPrimaryKey(id);

                // 1.Bo转为Po
                result = Po2BoUtils.getBo(model, UserBo.class);

                // 2.Bo中String类型的属性由null变为空字符串.
                MetaObjectUtil.setStringAttributeEmpty(result);
            } finally {
                RDBManager.getRDBManager().closeSession();
            }
        } catch (Throwable e) {
            throw new ModuleException("get-user-by-primary-key error,message:" + e.getMessage());
        }
        return result;
    }

    public List<UserBo> listUserByFilter(UserFilter filter) throws ModuleException {
        logger.debug("invoke listUserByFilter.");
        List<UserBo> result = null;
        try {
            List<UserModel> modelList = dao.listByFilter(filter);

            // 1.Bo转为Po
            result = Po2BoUtils.getBoList(modelList, UserBo.class);

            // 2.Bo中String类型的属性由null变为空字符串.
            MetaObjectUtil.setStringAttributeEmpty(result);
        } catch (Throwable e) {
            throw new ModuleException("get-user-by-primary-key error,message:" + e.getMessage());
        }
        return result;
    }

}
