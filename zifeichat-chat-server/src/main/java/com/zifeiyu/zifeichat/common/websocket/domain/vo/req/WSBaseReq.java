package com.zifeiyu.zifeichat.common.websocket.domain.vo.req;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/22 9:19
 * @description: websocket前端请求体
 */
@Data
public class WSBaseReq {
    /**
     * @see com.zifeiyu.zifeichat.common.websocket.domain.enums.WSReqTypeEnum
     */
    private Integer type;
    private String data;
}
