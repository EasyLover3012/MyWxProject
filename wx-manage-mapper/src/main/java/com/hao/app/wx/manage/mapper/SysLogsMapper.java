package com.hao.app.wx.manage.mapper;

import java.util.List;

import com.hao.app.wx.manage.commons.entity.param.SysLogsQueryParam;
import com.hao.app.wx.manage.pojo.SysLogs;



/**
 * 对应表：sys_logs
 * 
 * @author haoguowei
 *
 */
public interface SysLogsMapper {

	/**
	 * 插入记录
	 * @param sysLogs
	 * @return
	 */
    int insert(SysLogs sysLogs);

    /**
     * 分页查询日志记录
     * @param queryParam
     * @return
     */
    List<SysLogs> queryLogsPageList(SysLogsQueryParam queryParam);
    
    /**
     * 查询日志记录count
     * @param queryParam
     * @return
     */
    int queryLogsCount(SysLogsQueryParam queryParam);
}