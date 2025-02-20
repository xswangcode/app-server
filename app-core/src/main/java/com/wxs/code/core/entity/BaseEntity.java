/*
 *  @description: BaseEntity.java
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/4/3 下午1:57
 *  @date: 2024-6-25 11:13
 *
 */

package com.wxs.code.core.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

public class BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    public boolean ifEmpty() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object object = field.get(this);
                if (object instanceof CharSequence) {
                    if (!org.springframework.util.ObjectUtils.isEmpty(object)) {
                        return false;
                    }
                } else {
                    if (null != object) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            // pass
            return false;
        }
        return true;
    }

}
