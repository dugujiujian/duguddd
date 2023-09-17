package com.dugu.ddd.domain.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
/**
 * @author cihun
 * @date 2023-09-08 11:17
 */
public interface UserService {
    /**
     * 事务测试
     */
    void transactionTest();

    /**
     * 分页查询
     *
     * @param sysUserDO {@link SysUserDO}
     * @param pageNo    页码
     * @param pageSize  分页
     * @return {@link SysUserDO}
     */
    IPage<SysUserDO> findSysUser(SysUserDO sysUserDO, int pageNo, int pageSize);
}
