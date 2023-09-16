package com.dugu.ddd.infra.mw.database.plugin;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cihun
 * @date 2023-09-15 20:50
 */
@Component
public class MpMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date=new Date();
        this.setFieldValByName("gmtCreate", date, metaObject);
        this.setFieldValByName("gmtModified", date, metaObject);
    }


    /**
     * 更新操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Date date=new Date();
        this.setFieldValByName("gmtModified", date, metaObject);
    }
}
