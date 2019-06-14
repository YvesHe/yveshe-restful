/**   
 * Filename:    RDBProperties.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-5
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module;

/**
 * 项目module的 属性配置
 * 
 * 
 * @author Yves He
 * 
 */
public class ModuleProperties {

    public static final String LOG_TYPE = "module.log.type";

    public static final String DB_CONFIG = "module.db.config";
    public static final String DB_USERNAME = "module.db.username";
    public static final String DB_PASSWORD = "module.db.password";
    public static final String DB_URL = "module.db.url";
    public static final String DB_DRIVER = "module.db.driver";
    public static final String DB_MAX_ACTIVE_CONNECTIONS = "module.db.poolMaximumActiveConections";
    public static final String DB_MAX_IDLE_CONNECTIONS = "module.db.poolMaximumIdleConnections";
    public static final String DB_MAX_CHECKOUT_TIME = "module.db.poolMaximumCheckoutTime";
    public static final String DB_POOL_PING_ENABLE = "module.db.poolPingEnabled";
    public static final String DB_POOL_PING_QUERY = "module.db.poolPingQuery";
    public static final String DB_POOLPING_NOT_USERD_FOR = "module.db.poolPingConnectionsNotUserdFor";
}
