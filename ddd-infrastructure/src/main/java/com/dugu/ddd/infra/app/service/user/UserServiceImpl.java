package com.dugu.ddd.infra.app.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.database.aop.MultiDataSourceTransactional;
import com.dugu.ddd.infra.mw.database.mapper.dugu.SysUserMapper;
import com.dugu.ddd.infra.mw.database.mapper.dugut.TestSysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @MultiDataSourceTransactional
    public void saveUser() {
        TestSysUserDO testSysUserDO = new TestSysUserDO();
        testSysUserDO.setName("刺魂33");
        int result = testSysUserMapper.insert(testSysUserDO);
        SysUserDO sysUserDO = new SysUserDO();
//        sysUserDO.setName("刺魂");
        sysUserDO.setMobile("13758116709");
        sysUserDO.setPassword("123456");
        sysUserDO.setCreateBy(11L);
        sysUserDO.setUpdateBy(11L);
        int r = sysUserMapper.insert(sysUserDO);
    }

    @Override
    public IPage<SysUserDO> findSysUser(SysUserDO sysUserDO, int pageNo, int pageSize) {
        Page<SysUserDO> userPage = new Page<>(pageNo , pageSize);
        QueryWrapper<SysUserDO> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotEmpty(sysUserDO.getName())){
            queryWrapper.like("name",sysUserDO.getName());
        }
        return  sysUserMapper.selectPage(userPage , queryWrapper);
    }
}
