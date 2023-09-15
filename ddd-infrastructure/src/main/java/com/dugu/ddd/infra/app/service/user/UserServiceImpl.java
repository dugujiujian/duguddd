package com.dugu.ddd.infra.app.service.user;

import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.database.mapper.dugu.SysUserMapper;
import com.dugu.ddd.infra.mw.database.mapper.dugut.TestSysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author cihun
 * @date 2023-09-14 21:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private TestSysUserMapper testSysUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactionTest() {
        Date date = new Date();
        TestSysUserDO testSysUserDO = new TestSysUserDO();
        testSysUserDO.setName("刺魂");
        int result = testSysUserMapper.insert(testSysUserDO);
        SysUserDO sysUserDO = new SysUserDO();
//        sysUserDO.setName("刺魂");
        sysUserDO.setMobile("13758116709");
        sysUserDO.setPassword("123456");
        sysUserDO.setGmtCreate(date);
        sysUserDO.setGmtModified(date);
        sysUserDO.setCreateBy(11L);
        sysUserDO.setCreateBy(11L);
        int r = sysUserMapper.insert(sysUserDO);
    }
}
