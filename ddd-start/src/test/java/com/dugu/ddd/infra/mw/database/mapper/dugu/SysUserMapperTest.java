package com.dugu.ddd.infra.mw.database.mapper.dugu;

import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import com.dugu.ddd.infra.mw.database.DuguDataSourceConfig;
import com.dugu.ddd.infra.mw.database.DugutDataSourceConfig;
import com.dugu.ddd.infra.mw.database.MybatisPlusConfig;
import com.dugu.ddd.infra.mw.database.mapper.dugut.TestSysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author cihun
 * @date 2023-09-08 11:07
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SysUserMapperTest.Config.class)
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TestSysUserMapper testSysUserMapper;


    @Test
    public void testDuguSelectById() {
        SysUserDO user = sysUserMapper.selectById(1L);
        if (user != null) {
            System.out.println(user);
        }
    }

    @Test
    public void testDugutSelectById() {
        TestSysUserDO user = testSysUserMapper.selectById(1L);
        if (user != null) {
            System.out.println(user);
        }
    }

    @Test
    public void transactionTest() {
        Date date = new Date();
//        TestSysUserDO testSysUserDO = new TestSysUserDO();
//        testSysUserDO.setName("刺魂");
//        int result = testSysUserMapper.insert(testSysUserDO);
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


    @Configuration
    @Import(value = {MybatisPlusConfig.class, DugutDataSourceConfig.class, DuguDataSourceConfig.class})
    static class Config {

    }
}