/**
 * Filename:    ImplModuleServiceTestTest.java
 * Copyright:   Copyright (c)2016
 * Company:     Yves
 * @version:    1.0
 * Create at:   2017-9-8
 * Description:
 *
 * Author       Yves He
 */
package cn.com.yves.module;

import org.junit.Before;
import org.junit.Test;

import cn.com.yves.module.bo.UserBo;

/**
 * 默认使用的Junit3,需要Junit4
 *
 * @author Yves He
 *
 */
public class ImplModuleServiceTestTest {

    private ImplModuleService service = null;

    @Before
    public void getService() {
        service = new ImplModuleService();
    }

    @Test
    public void saveUserTest() {
        UserBo user = new UserBo();
        user.setName("heyu");
        user.setAge(23);
        user.setAddress("hunan2");

        user.setId("2658b67f-8dad-4bae-8f5d-25d071af7090");

        try {
            service.saveUser(user);
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delUserTest() {
        String id = "2658b67f-8dad-4bae-8f5d-25d071af7090";
        try {
            service.delUser(id);
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserByPrimaryKeyTest() {
        String id = "9819a09c-f657-490b-9621-d36b078d79f3";
        try {
            UserBo userByPrimaryKey = service.getUserByPrimaryKey(id);
            System.out.println(userByPrimaryKey.toString());
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }

}
