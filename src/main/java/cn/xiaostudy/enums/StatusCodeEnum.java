package cn.xiaostudy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作状态码
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAIL(400, "操作失败"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(500, "系统异常");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;

}

