package cn.xiaostudy.exception;

import lombok.Data;

import static cn.xiaostudy.enums.StatusCodeEnum.FAIL;
/**
 * 自定义异常
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@Data
public class MirrorException extends RuntimeException{

    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public MirrorException(String message) {
        this.message = message;
    }

}
