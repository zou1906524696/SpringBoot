package com.zzf.girl.exception;

import com.zzf.girl.enums.ResultEnum;
import lombok.Data;

@Data
public class GirlExpection extends RuntimeException {
    private Integer code;

    public GirlExpection(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
