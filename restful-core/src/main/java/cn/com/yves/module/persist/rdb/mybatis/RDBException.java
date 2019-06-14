/**   
 * Filename:    DaoException.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-4
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist.rdb.mybatis;

import cn.com.yves.module.persist.PersisException;

/**
 * 根据业务 --定义相关异常
 * 
 * @author Yves He
 * 
 */
public class RDBException extends PersisException {

    private static final long serialVersionUID = 4418821846435672920L;

    public RDBException(String message) {
        super(message);
    }

}
