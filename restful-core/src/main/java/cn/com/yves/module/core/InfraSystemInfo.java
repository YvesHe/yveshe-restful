/**   
 * Filename:    InfraSystemInfo.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-13
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import cn.com.yves.module.core.logger.InfraLogger;

/**
 * 系统属性设置
 * 
 * 1.获取项目的根目录homeFolder
 * 
 * 2.获取项根目录下的配置文件目录 confFolder: 有homeFolder无confFolder时,默认为homeFolder/conf
 * 
 * @author Yves He
 * 
 */
public class InfraSystemInfo {

    private static final InfraLogger logger = new InfraLogger(InfraSystemInfo.class);
    private static InfraSystemInfo instance = null;

    private String homeFolder = null;
    private String confFolder = null;

    /**
     * 最好在框架一启动时就之执行初始化
     * 
     * @return
     */
    public synchronized static InfraSystemInfo getInstance() {
        if (instance == null) {
            instance = new InfraSystemInfo();
        }
        return instance;
    }

    private InfraSystemInfo() {
        init();
    }

    /**
     * 获取初始化的 项目根目录 和conf目录
     */
    private void init() {

        // home folder
        String home = System.getProperty(InfraConstants.INFRA_HOME_FOLDER);
        if (StringUtils.isNotBlank(home)) {
            File file = new File(home);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                homeFolder = file.getAbsolutePath();
                logger.info("the infra home folder is %s", homeFolder);
            } else {
                logger.warn("the infra home holder s%" + "is not a folder.", file.getAbsolutePath());
            }
        } else {
            logger.warn("the infra home folder is not setted.");
        }

        // conf folder
        if (StringUtils.isNotBlank(homeFolder)) {
            String conf = System.getProperty(InfraConstants.INFRA_CONF);
            if (StringUtils.isNotBlank(conf)) {
                File file = new File(homeFolder + File.separator + conf);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.isDirectory()) {
                    confFolder = file.getAbsolutePath();
                    logger.info("the infra conf  folder is %s", confFolder);
                } else {
                    logger.warn("the infra conf holder s%" + "is not a folder.", file.getAbsolutePath());
                }
            }
        }
    }

    public String getHomeFolder() {
        return homeFolder;
    }

    public String getConfFolder() {
        return confFolder;
    }

}
