/**   
 * Filename:    MetaObject.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2017-9-7
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.module.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import cn.com.yves.module.core.exception.InfraException;

/**
 * 元对象 ,用来修改对象的属性
 * 
 * @author Yves He
 * 
 */
public class MetaObjectUtil {

    private static final String EMPTY_STR = "";

    /**
     * 将对象中String类型的属性由null值变为空字符串"" <br>
     * 注意:此方法暂时不支持泛型,不处理static和final类型的属性.只修改本类中声明的属性变量.
     * 
     * @param obj
     * @throws InfraException
     * 
     */
    public static void setStringAttributeEmpty(Object obj) throws InfraUtilException {
        try {
            if (obj != null) {
                Class<? extends Object> clazz = obj.getClass();
                while (clazz != Object.class) {
                    Field[] declaredFields = clazz.getDeclaredFields();
                    if (declaredFields != null) {
                        for (Field field : declaredFields) {
                            int modifiers = field.getModifiers();
                            if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                                continue;
                            }
                            boolean access = field.isAccessible();
                            field.setAccessible(true);
                            try {
                                if (field.getType() == String.class && field.get(obj) == null) {
                                    field.set(obj, EMPTY_STR);
                                }
                            } finally {
                                field.setAccessible(access);
                            }
                        }
                    }
                    clazz = clazz.getSuperclass();
                }
            }
        } catch (Exception e) {
            throw new InfraUtilException("set-string-attribute-empty error,message:" + e.getMessage());
        }
    }
}
