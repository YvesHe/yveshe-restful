/**   
 * Filename:    BoSnapshotUtil.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-13
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.utils;

import cn.com.yves.module.bo.UserBo;
import cn.com.yves.module.core.bo.Bo;

/**
 * 自定义克隆,解决系统clone方法有CloneNotSupportedException异常.
 * 
 * @author Yves He
 * 
 */
public class BoSnapshotUtil {

    public static <T> Bo snapshot(Bo bo) {
        return bo;
    }

    public static void main(String[] args) {
        snapshot(new UserBo());

    }
}
