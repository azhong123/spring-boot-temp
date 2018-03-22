package com.spring.service;

import com.spring.common.Exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * service
 * Created by chenxizhong on 2018/3/22.
 */
@Service
public class BaseService {

    public int base(String customerId,String orderId){
        int rows = 1;
        if(customerId.equals("1")){
            throw new ServiceException("C-011000");
        }
        if(orderId.equals("10")){
            throw new ServiceException("C-011001");
        }
        return rows;
    }

}
