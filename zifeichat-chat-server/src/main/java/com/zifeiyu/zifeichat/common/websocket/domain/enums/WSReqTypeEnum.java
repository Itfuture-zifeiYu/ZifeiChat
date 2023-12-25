package com.zifeiyu.zifeichat.common.websocket.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: wxh
 * @version:
 * @date: 2023/12/22 11:55
 * @description: ws前端请求类型枚举
 */
@AllArgsConstructor
@Getter
public enum WSReqTypeEnum {
    LOGIN(1,"请求登录二维码"),
    HEARTBEAT(2,"心跳包"),
    AUTHORIZE(3,"登录认证"),
    ;
    
    private final Integer type;
    private final String desc;
    
    private static Map<Integer,WSReqTypeEnum> cache;
    
    static {
        //将枚举类型的值转化为流，并将流中的元素转换为键值对，存储到Map中
        cache = Arrays.stream(WSReqTypeEnum.values()).collect(Collectors.toMap(WSReqTypeEnum::getType, Function.identity()));
    }
    
    
    public static WSReqTypeEnum of(Integer type){
        return cache.get(type);
    }
}
