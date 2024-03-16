package com.wxs.code.entity.biz;

import com.wxs.code.core.entity.CoreEntity;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "学生实体类")
public class Student extends CoreEntity {
    @Schema(description = "序号啊", name = "id",required = true)
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Schema(name = "name", description = "名称")
    String name;
    Integer age;
    String email;
}
