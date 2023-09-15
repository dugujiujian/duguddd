package com.dugu.ddd.infra.app.service.user;

import com.dugu.ddd.domain.service.user.UserService;
import com.dugu.ddd.infra.mw.database.DataSourceConfiguration;
import com.dugu.ddd.infra.mw.database.DugutDataSourceConfig;
import com.dugu.ddd.infra.mw.database.MybatisPlusConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    public void transactionTest() {
        userService.transactionTest();
    }

    @Configuration
    @Import(value = {MybatisPlusConfig.class, DataSourceConfiguration.class,
            com.dugu.ddd.infra.mw.database.mysql.DuguDataSourceConfig.class,
            DugutDataSourceConfig.class})
    static class Config {
        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }

}