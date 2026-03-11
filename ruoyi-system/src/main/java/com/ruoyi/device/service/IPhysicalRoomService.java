package com.ruoyi.device.service;

import java.util.List;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.PhysicalRoom;

/**
 * 设备管理Service接口
 *
 * @author ruoyi
 * @date 2026-03-10
 */
public interface IPhysicalRoomService
{
    /**
     * 查询设备管理
     *
     * @param roomId 设备管理主键
     * @return 设备管理
     */
    public PhysicalRoom selectPhysicalRoomByRoomId(Long roomId);

    /**
     * 查询设备管理列表
     *
     * @param physicalRoom 设备管理
     * @return 设备管理集合
     */
    public List<PhysicalRoom> selectPhysicalRoomList(PhysicalRoom physicalRoom);

    /**
     * 新增设备管理
     *
     * @param physicalRoom 设备管理
     * @return 结果
     */
    public int insertPhysicalRoom(PhysicalRoom physicalRoom);

    /**
     * 修改设备管理
     *
     * @param physicalRoom 设备管理
     * @return 结果
     */
    public int updatePhysicalRoom(PhysicalRoom physicalRoom);

    /**
     * 批量删除设备管理
     *
     * @param roomIds 需要删除的设备管理主键集合
     * @return 结果
     */
    public int deletePhysicalRoomByRoomIds(Long[] roomIds);

    /**
     * 删除设备管理信息
     *
     * @param roomId 设备管理主键
     * @return 结果
     */
    public int deletePhysicalRoomByRoomId(Long roomId);

    public List<TreeSelect> selectroomTreeList(PhysicalRoom physicalRoom);
}
