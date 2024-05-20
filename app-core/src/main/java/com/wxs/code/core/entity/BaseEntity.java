package com.wxs.code.core.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

public class BaseEntity implements Serializable {

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
