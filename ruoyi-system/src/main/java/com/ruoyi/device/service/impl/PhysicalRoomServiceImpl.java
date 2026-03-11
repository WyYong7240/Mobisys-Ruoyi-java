package com.ruoyi.device.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.PhysicalRoomMapper;
import com.ruoyi.common.core.domain.entity.PhysicalRoom;
import com.ruoyi.device.service.IPhysicalRoomService;

/**
 * 设备管理Service业务层处理
 *
 * @author ruoyi
 * @date 2026-03-10
 */
@Service
public class PhysicalRoomServiceImpl implements IPhysicalRoomService
{
    @Autowired
    private PhysicalRoomMapper physicalRoomMapper;

    /**
     * 查询设备管理
     *
     * @param roomId 设备管理主键
     * @return 设备管理
     */
    @Override
    public PhysicalRoom selectPhysicalRoomByRoomId(Long roomId)
    {
        return physicalRoomMapper.selectPhysicalRoomByRoomId(roomId);
    }

    /**
     * 查询设备管理列表
     *
     * @param physicalRoom 设备管理
     * @return 设备管理
     */
    @Override
    public List<PhysicalRoom> selectPhysicalRoomList(PhysicalRoom physicalRoom)
    {
        return physicalRoomMapper.selectPhysicalRoomList(physicalRoom);
    }

    /**
     * 新增设备管理
     *
     * @param physicalRoom 设备管理
     * @return 结果
     */
    @Override
    public int insertPhysicalRoom(PhysicalRoom physicalRoom)
    {
        physicalRoom.setCreateTime(DateUtils.getNowDate());
        return physicalRoomMapper.insertPhysicalRoom(physicalRoom);
    }

    /**
     * 修改设备管理
     *
     * @param physicalRoom 设备管理
     * @return 结果
     */
    @Override
    public int updatePhysicalRoom(PhysicalRoom physicalRoom)
    {
        physicalRoom.setUpdateTime(DateUtils.getNowDate());
        return physicalRoomMapper.updatePhysicalRoom(physicalRoom);
    }

    /**
     * 批量删除设备管理
     *
     * @param roomIds 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deletePhysicalRoomByRoomIds(Long[] roomIds)
    {
        return physicalRoomMapper.deletePhysicalRoomByRoomIds(roomIds);
    }

    /**
     * 删除设备管理信息
     *
     * @param roomId 设备管理主键
     * @return 结果
     */
    @Override
    public int deletePhysicalRoomByRoomId(Long roomId)
    {
        return physicalRoomMapper.deletePhysicalRoomByRoomId(roomId);
    }

    @Override
    public List<TreeSelect> selectroomTreeList(PhysicalRoom physicalRoom) {
        List<PhysicalRoom> rooms = SpringUtils.getAopProxy(this).selectPhysicalRoomList(physicalRoom);
        List<TreeSelect> treeSelects = buildRoomTreeSelect(rooms);
        return treeSelects;
    }

    private List<TreeSelect> buildRoomTreeSelect(List<PhysicalRoom> rooms) {
        List<PhysicalRoom> roomTrees = buildRoomTree(rooms);

        return roomTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    private List<PhysicalRoom> buildRoomTree(List<PhysicalRoom> rooms) {
        List<PhysicalRoom> returnList = new ArrayList<PhysicalRoom>();
        List<Long> tempList = rooms.stream().map(PhysicalRoom::getRoomId).collect(Collectors.toList());
        for (PhysicalRoom room : rooms)
        {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(room.getParentId()))
            {
                recursionFn(rooms, room);
                returnList.add(room);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = rooms;
        }
        return returnList;

    }

    /**
     * 递归列表
     */
    private void recursionFn(List<PhysicalRoom> list, PhysicalRoom t)
    {
        // 得到子节点列表
        List<PhysicalRoom> childList = getChildList(list, t);
        t.setChildren(childList);
        for (PhysicalRoom tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<PhysicalRoom> getChildList(List<PhysicalRoom> list, PhysicalRoom t)
    {
        List<PhysicalRoom> tlist = new ArrayList<PhysicalRoom>();
        Iterator<PhysicalRoom> it = list.iterator();
        while (it.hasNext())
        {
            PhysicalRoom n = (PhysicalRoom) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getRoomId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<PhysicalRoom> list, PhysicalRoom t)
    {
        return getChildList(list, t).size() > 0;
    }
}
