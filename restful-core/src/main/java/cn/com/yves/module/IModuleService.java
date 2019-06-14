/**   
 * Filename:    ModuleService.java   
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

import cn.com.yves.module.bo.UserBo;
import cn.com.yves.module.bo.filter.UserFilter;

/**
 * 对外提供的方法
 * 
 * @author Yves He
 * 
 */
public interface IModuleService {

    // 不仅仅是CRUD,应该还有其他的业务
    String saveUser(UserBo bo) throws ModuleException;

    void delUser(String id) throws ModuleException;

    UserBo getUserByPrimaryKey(String id) throws ModuleException;

    List<UserBo> listUserByFilter(UserFilter fileter) throws ModuleException;

}
