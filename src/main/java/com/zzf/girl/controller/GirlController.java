package com.zzf.girl.controller;

import com.zzf.girl.domain.Girl;
import com.zzf.girl.domain.Result;
import com.zzf.girl.repository.GirlRepository;
import com.zzf.girl.service.GirlService;
import com.zzf.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {


    private  final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**查询所有女生列表*/
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList()");
        return girlRepository.findAll();
    }

   /* public Girl girlAdd(@RequestParam("language") String language,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setLanguage(language);
        girl.setAge(age);
        return girlRepository.save(girl);
    }*/
    /**添加一个对象*/
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setLanguage(girl.getLanguage());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value="/girls/{id}")
    public Girl findById(@PathVariable("id")Integer id){
//        return girlRepository.findById(id).get();
        return girlRepository.findOne(id);
    }

    /***更新接口*/
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                           @RequestParam("language")String language,
                           @RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setLanguage(language);
        girl.setAge(age);
        return girlRepository.save(girl);
    }


    //删除
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
//        girlRepository.deleteById(id);
        /**版本下降*/
        girlRepository.delete(id);
   }
   /**通过年龄查询女生列表*/
   @GetMapping(value = "/girls/age/{age}")
   public List<Girl> girlListByAge(@PathVariable("age")Integer age){
       return girlRepository.findByAge(age);
   }


   @PostMapping(value = "/girls/two")
    public void girlTwo(){
       girlService.insertTwo();
   }

   @GetMapping(value = "/girls/getAge/{id}")
   public void getAge(@PathVariable("id")Integer id) throws Exception{
        girlService.getAge(id);
   }
}
