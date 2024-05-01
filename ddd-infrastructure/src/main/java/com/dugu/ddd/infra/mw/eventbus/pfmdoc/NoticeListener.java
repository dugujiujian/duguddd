package com.dugu.ddd.infra.mw.eventbus.pfmdoc;

import com.dugu.ddd.infra.mw.message.NoticeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author cihun
 * @date 2023-09-22 16:56
 */
@Slf4j
@Component
public class NoticeListener {

    @Async
    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void noticeEventAction(NoticeEvent event) {
        log.info("event bus");
    }
}
