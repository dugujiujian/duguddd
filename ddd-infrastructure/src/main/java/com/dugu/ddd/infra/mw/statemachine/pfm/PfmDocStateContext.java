package com.dugu.ddd.infra.mw.statemachine.pfm;

import com.dugu.ddd.infra.mw.message.NoticeEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cihun
 * @date 2023-09-17 08:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PfmDocStateContext {


    private String docId;
    /**
     * 操作者
     */
    private Long operator;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 通知事件
     */
    private NoticeEvent event;
    /**
     * 分布式锁key
     */
    private String lockKey;
}
