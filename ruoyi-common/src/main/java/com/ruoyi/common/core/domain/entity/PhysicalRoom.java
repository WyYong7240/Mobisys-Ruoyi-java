package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备管理对象 physical_room
 *
 * @author ruoyi
 * @date 2026-03-10
 */
public class PhysicalRoom extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 物理机ID */
    private Long roomId;

    /** 物理机名称 */
    @Excel(name = "物理机名称")
    private String roomName;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 机房状态（0正常 1停用） */
    @Excel(name = "机房状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;


    public void setRoomId(Long roomId)
    {
        this.roomId = roomId;
    }

    public Long getRoomId()
    {
        return roomId;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("roomId", getRoomId())
                .append("parentId", getParentId())
                .append("ancestors", getAncestors())
                .append("roomName", getRoomName())
                .append("orderNum", getOrderNum())
                .append("leader", getLeader())
                .append("phone", getPhone())
                .append("email", getEmail())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }


}
