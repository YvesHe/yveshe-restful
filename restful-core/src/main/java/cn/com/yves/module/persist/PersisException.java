/**   
 * Filename:    PersisException.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-8
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.persist;

import cn.com.yves.module.core.exception.InfraException;

public class PersisException extends InfraException {

    private static final long serialVersionUID = 5704882318105449257L;

    public PersisException(String message) {
        super(message);
    }

}
