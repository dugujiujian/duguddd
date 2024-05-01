package com.dugu.ddd.infra.app.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dugu.ddd.domain.dao.dugu.user.SysUserDO;
import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.database.DataSourceConfiguration;
import com.dugu.ddd.infra.mw.database.DuguDataSourceConfig;
import com.dugu.ddd.infra.mw.database.DugutDataSourceConfig;
import com.dugu.ddd.infra.mw.database.MybatisPlusConfig;
import com.dugu.ddd.infra.mw.database.aop.MultiDataSourceTransactionAspect;
import com.dugu.ddd.infra.mw.database.plugin.MpMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cihun
 * @date 2023-09-14 21:27
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceImplTest.Config.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;



    @Test
    public void sysUserPageQuery() {
        SysUserDO sysUserDO=new SysUserDO();
        //sysUserDO.setName("刺");
        IPage<SysUserDO> user=userService.findSysUser(sysUserDO,1,1);
        System.out.println("总页数： "+user.getPages());
        System.out.println("总记录数： "+user.getTotal());
        user.getRecords().forEach(System.out::println);
    }


    @Test
    public void transactionTest() {
        userService.saveUser();
    }

    @Configuration
    @Import(value = {MultiDataSourceTransactionAspect.class,MybatisPlusConfig.class, DataSourceConfiguration.class,
            DuguDataSourceConfig.class,
            DugutDataSourceConfig.class, MpMetaObjectHandler.class})
   public static class Config {
        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }

}