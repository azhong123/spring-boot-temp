package com.spring.controller;

import com.spring.common.base.ResultResponse;
import com.spring.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * Created by chenxizhong on 2018/3/21.
 */
@Slf4j
@RestController
@RequestMapping
public class BaseController {

    @Autowired
    private BaseService baseService;

    /**
     * 将查询的数据返回个前端
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public ResultResponse base(){
        String result = "hello spring boot";
        return ResultResponse.createBySuccess(result);
    }

    /**
     * 将操作成功的状态返回给前端
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/success",method = RequestMethod.PUT)
    public ResultResponse base1(){
        return ResultResponse.createBySuccess();
    }

    /**
     * 用postman 直接请求 不填任何参数，看报错信息，然后将参数补全，看返回信息
     * @param customerId
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public ResultResponse baseTwo(@RequestParam String customerId,@RequestParam String orderId){
        int base = baseService.base(customerId, orderId);
        if(base > 0){
            return ResultResponse.createBySuccess();
        }
        return ResultResponse.createByError("C-011002");
    }

}
