/**   
 * Filename:    InfraResource.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-13
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import cn.com.yves.module.core.logger.InfraLogger;

/**
 * 本地资源管理
 * 
 * @author Yves He
 * 
 */
public class InfraResource {
    private static final InfraLogger logger = new InfraLogger(InfraSystemInfo.class);

    private static ResourceBundle bundle = null;

    /* 加载本地资源 ,设计时,应该在框架服务一启动就执行该操作. */
    public static final void load() {
        Locale local = new Locale("Zh", "CN");
        // 如何理解i18n 没有后缀.properties
        bundle = ResourceBundle.getBundle("i18n", local);

        logger.info("load the i18n resource.");
    }

    /**
     * 从本地的资源中根据Key获取值.
     * 
     * <br>
     * 前提是先load资源.
     * 
     * @param key
     * @param args
     * @return
     */
    public static final String get(String key, Object... args) {
        try {
            if (args == null || args.length == 0) {
                return bundle.getString(key);
            } else {
                return MessageFormat.format(bundle.getString(key), args);
            }
        } catch (Throwable e) {
            return "<empty resource>";
        }
    }
}
