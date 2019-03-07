package com.zzf.girl.service;

import com.zzf.girl.domain.Girl;
import com.zzf.girl.enums.ResultEnum;
import com.zzf.girl.exception.GirlExpection;
import com.zzf.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girl_1 = new Girl();
        girl_1.setLanguage("java");
        girl_1.setAge(20);
        girlRepository.save(girl_1);
        Girl girl_2 = new Girl();
        girl_2.setLanguage("java");
        girl_2.setAge(60);
        girlRepository.save(girl_2);
    }
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<25){
            //返回：你可能在上下学
            throw new GirlExpection(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>25 && age<45) {
            //返回，你可能在上初中
            throw new GirlExpection(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**查询一个对象*/
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
