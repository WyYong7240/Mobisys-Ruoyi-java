package com.ruoyi.device.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.PhysicalRoom;

/**
 * 设备管理Mapper接口
 *
 * @author ruoyi
 * @date 2026-03-10
 */
public interface PhysicalRoomMapper
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
     * 删除设备管理
     *
     * @param roomId 设备管理主键
     * @return 结果
     */
    public int deletePhysicalRoomByRoomId(Long roomId);

    /**
     * 批量删除设备管理
     *
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePhysicalRoomByRoomIds(Long[] roomIds);
}
