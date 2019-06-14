/**   
 * Filename:    ModuleException.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-7
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module;

import cn.com.yves.module.core.exception.InfraException;

public class ModuleException extends InfraException {

    private static final long serialVersionUID = 4856082383009591108L;

    public ModuleException(String message) {
        super(message);
    }

    public ModuleException(int type, String message) {
        super(type, message);
    }
}
