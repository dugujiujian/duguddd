package com.dugu.ddd.infra.mw.database.mapper.dugu;

import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import com.dugu.ddd.infra.mw.database.DataSourceConfiguration;
import com.dugu.ddd.infra.mw.database.DbContextHolder;
import com.dugu.ddd.infra.mw.database.DuguDataSourceConfig;
import com.dugu.ddd.infra.mw.database.DugutDataSourceConfig;
import com.dugu.ddd.infra.mw.database.MybatisPlusConfig;
import com.dugu.ddd.infra.mw.database.aop.DatabaseTransactionAspect;
import com.dugu.ddd.infra.mw.database.enums.DatabaseCommonEnum;
import com.dugu.ddd.infra.mw.database.mapper.dugut.TestSysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Before
    public void init(){
        DbContextHolder.setDefaultDs(DatabaseCommonEnum.DsType.DS_DUGUT.getValue());
    }

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


    @Configuration
    @Import(value = {DataSourceConfiguration.class,MybatisPlusConfig.class,
            DuguDataSourceConfig.class, DugutDataSourceConfig.class, DatabaseTransactionAspect.class})
    static class Config {

    }
}