/**   
 * Filename:    UUIDUtil.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-7
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String UUIDGen() {
        return UUID.randomUUID().toString();
    }
}
