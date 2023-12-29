package com.zifeiyu.zifeichat.common.websocket.domain.vo.resp;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/27 15:09
 * @description: websocket响应体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WSBaseResp<T> {
    /**
     * @see com.zifeiyu.zifeichat.common.websocket.domain.enums.WSRespTypeEnum
     */
    private Integer type;
    private T data;
}
