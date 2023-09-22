package com.dugu.ddd.infra.mw.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cihun
 * @date 2023-09-22 16:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeEvent {
    private String message;
}
