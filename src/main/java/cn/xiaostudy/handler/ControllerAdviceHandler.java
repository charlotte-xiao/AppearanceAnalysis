package cn.xiaostudy.handler;

import cn.xiaostudy.exception.MirrorException;
import cn.xiaostudy.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static cn.xiaostudy.enums.StatusCodeEnum.SYSTEM_ERROR;

/**
 * 统一异常处理
 * @author charlotte xiao
 * @date 2021/10/2
 * @description
 */
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理服务异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = MirrorException.class)
    public Result<?> errorHandler(MirrorException e) {
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getDesc());
    }


    /**
     * 处理系统异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getDesc());
    }
}
