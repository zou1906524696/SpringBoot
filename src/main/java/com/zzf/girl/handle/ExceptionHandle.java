package com.zzf.girl.handle;


import com.zzf.girl.domain.Result;
import com.zzf.girl.exception.GirlExpection;
import com.zzf.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result hangle(Exception e){
        if(e instanceof GirlExpection){
            GirlExpection girlExpection = (GirlExpection) e;
            return ResultUtil.error(girlExpection.getCode(),girlExpection.getMessage());
        }else{
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
