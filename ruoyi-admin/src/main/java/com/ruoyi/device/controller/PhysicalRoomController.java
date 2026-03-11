package com.ruoyi.web.controller.device;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.domain.entity.PhysicalRoom;
import com.ruoyi.device.service.IPhysicalRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 设备管理Controller
 *
 * @author ruoyi
 * @date 2026-03-10
 */
@RestController
@RequestMapping("/device/room")
public class PhysicalRoomController extends BaseController
{
    @Autowired
    private IPhysicalRoomService physicalRoomService;

    /**
     * 查询设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:room:list')")
    @GetMapping("/list")
    public AjaxResult list(PhysicalRoom physicalRoom)
    {
        List<PhysicalRoom> list = physicalRoomService.selectPhysicalRoomList(physicalRoom);
        return success(list);
    }

    /**
     * 导出设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:room:export')")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PhysicalRoom physicalRoom)
    {
        List<PhysicalRoom> list = physicalRoomService.selectPhysicalRoomList(physicalRoom);
        ExcelUtil<PhysicalRoom> util = new ExcelUtil<PhysicalRoom>(PhysicalRoom.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:room:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId)
    {
        return success(physicalRoomService.selectPhysicalRoomByRoomId(roomId));
    }

    /**
     * 新增设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:room:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PhysicalRoom physicalRoom)
    {
        return toAjax(physicalRoomService.insertPhysicalRoom(physicalRoom));
    }

    /**
     * 修改设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:room:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PhysicalRoom physicalRoom)
    {
        return toAjax(physicalRoomService.updatePhysicalRoom(physicalRoom));
    }

    /**
     * 删除设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:room:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(physicalRoomService.deletePhysicalRoomByRoomIds(roomIds));
    }
}
