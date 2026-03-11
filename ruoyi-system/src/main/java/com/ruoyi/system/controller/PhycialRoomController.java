package com.ruoyi.system.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.system.domain.PhysicalRoom;
import com.ruoyi.system.service.PhycialRoomService;

/**
 * 机房信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/room")
public class PhycialRoomController extends BaseController
{
    @Autowired
    private PhycialRoomService roomService;

    /**
     * 获取机房列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:list')")
    @GetMapping("/list")
    public AjaxResult list(PhysicalRoom room)
    {
        List<PhysicalRoom> list = roomService.selectRoomList(room);
        return success(list);
    }

    /**
     * 获取机房下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(PhysicalRoom room)
    {
        List<PhysicalRoom> rooms = roomService.selectRoomList(room);
        return success(roomService.buildRoomTreeSelect(rooms));
    }

    /**
     * 根据机房编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable Long roomId)
    {
        return success(roomService.selectRoomById(roomId));
    }

    /**
     * 新增机房
     */
    @PreAuthorize("@ss.hasPermi('system:room:add')")
    @PostMapping
    public AjaxResult add(@RequestBody PhysicalRoom room)
    {
        room.setCreateBy(getUsername());
        return toAjax(roomService.insertRoom(room));
    }

    /**
     * 修改机房
     */
    @PreAuthorize("@ss.hasPermi('system:room:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody PhysicalRoom room)
    {
        room.setUpdateBy(getUsername());
        return toAjax(roomService.updateRoom(room));
    }

    /**
     * 删除机房
     */
    @PreAuthorize("@ss.hasPermi('system:room:remove')")
    @DeleteMapping("/{roomId}")
    public AjaxResult remove(@PathVariable Long roomId)
    {
        return toAjax(roomService.deleteRoomById(roomId));
    }
}