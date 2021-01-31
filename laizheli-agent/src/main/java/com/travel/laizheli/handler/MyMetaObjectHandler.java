package com.travel.laizheli.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName: MyMetaObjectHandler
 * @Description: 元对象处理器,为了解决数据库字段自动填充问题
 * @Author: Wangcb
 * @Date: 2021/1/25 22:43
 * @Version: 1.0
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // setFieldValByName方法中参数分别为实体类的属性名、要填充的值，元数据对象
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
