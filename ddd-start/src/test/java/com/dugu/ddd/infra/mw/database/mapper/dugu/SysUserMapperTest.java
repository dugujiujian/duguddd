package com.dugu.ddd.infra.mw.database.mapper.dugu;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.dao.dugut.user.TestSysUserDO;
import com.dugu.ddd.infra.mw.database.DataSourceConfiguration;
import com.dugu.ddd.infra.mw.database.DugutDataSourceConfig;
import com.dugu.ddd.infra.mw.database.MybatisPlusConfig;
import com.dugu.ddd.infra.mw.database.mapper.dugut.TestSysUserMapper;
import com.dugu.ddd.infra.mw.database.plugin.MpMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    public void sysUserInsertTest() {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setName("独孤");
        sysUserDO.setMobile("13758116709");
        sysUserDO.setPassword("123456");
        sysUserDO.setCreateBy(11L);
        sysUserDO.setUpdateBy(11L);
        int r = sysUserMapper.insert(sysUserDO);
        Assert.assertTrue(1 == r);
    }


    @Test
    public void sysUserUpdateTest() {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setId(1702670787921666049L);
        sysUserDO.setName("刺魂2");
        int r = sysUserMapper.updateById(sysUserDO);
    }

    @Test
    public void sysUserUpdateWrapperTest() {
        UpdateWrapper<SysUserDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("name", "刺魂");
        updateWrapper.eq("id", 1702670787921666049L);
        sysUserMapper.update(null, updateWrapper);
    }

    @Test
    public void batchSysUserUpdateWrapperByIdTest() {
        // 不会更新gmt_modified
//        UpdateWrapper<SysUserDO> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.set("password", "654321");
//        updateWrapper.in("id", Lists.newArrayList(1702670787921666049L, 1702673506765914113L));
//        sysUserMapper.update(null, updateWrapper);

        // 方法2 - 会更新gmt_modified
        UpdateWrapper<SysUserDO> updateWrapper2 = new UpdateWrapper<>();
        updateWrapper2.in("id", Lists.newArrayList(1702670787921666049L, 1702673506765914113L));
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setPassword("777777");
        sysUserMapper.update(sysUserDO, updateWrapper2);
    }

    @Test
    public void batchTestSysUserInsertTest() {
        List<TestSysUserDO> userList = Lists.newArrayList();

        TestSysUserDO testSysUserDO = new TestSysUserDO();
        userList.add(testSysUserDO);
        testSysUserDO.setName("刺魂");
        testSysUserDO.setSex("F");

        TestSysUserDO testSysUserDO2 = new TestSysUserDO();
        userList.add(testSysUserDO2);
        testSysUserDO2.setName("独孤");
        testSysUserDO2.setSex("T");

        testSysUserMapper.saveOrUpdateBatch(userList);
    }


    @Test
    public void testSysUserInsertTest() {
        TestSysUserDO sysUserDO = new TestSysUserDO();
        sysUserDO.setName("刺魂");
        int r = testSysUserMapper.insert(sysUserDO);
    }


    @Configuration
    @Import(value = {MpMetaObjectHandler.class, MybatisPlusConfig.class, DataSourceConfiguration.class,
            com.dugu.ddd.infra.mw.database.mysql.DuguDataSourceConfig.class,
            DugutDataSourceConfig.class})
    static class Config {

    }
}