package com.wxs.code.core.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class CoreEntity extends BaseEntity{

    @Schema(name = "createTime",description = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createTime;

    @Schema(name = "updateTime",description = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updateTime;

    @Schema(name = "createById",description = "创建人Id")

    Long createById;

    @Schema(name = "updateById",description = "修改人Id")
    Long updateById;

    @Schema(name = "createBy",description = "创建人")
    String createBy;
    @Schema(name = "updateBy",description = "修改人")
    String updateBy;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    public Long getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Long updateById) {
        this.updateById = updateById;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
