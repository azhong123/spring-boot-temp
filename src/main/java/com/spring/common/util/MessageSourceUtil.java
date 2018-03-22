package com.spring.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import java.util.Locale;

/**
 * 消息资源根据类
 * Created by chenxizhong on 2018/3/13.
 */
public final class MessageSourceUtil {
    private static MessageSource messageSource;

    static {
        init((MessageSource) SpringContextHolder.getBean(MessageSource.class));
    }




    public static void init(MessageSource messageSource) {
        MessageSourceUtil.messageSource = messageSource;
    }



    /**
     * @param code ：对应messages配置的key.
     * @return
     */
    public static String getMessage(String code){
        try {
            return getMessage(code,null);
        }catch (NoSuchMessageException e) {
            return null;
        }
    }

    /**
     *
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @return
     */
    public static String getMessage(String code,Object[] args){
        try {
            return getMessage(code, args,"");
        }catch (NoSuchMessageException e) {
            return null;
        }
    }


    /**
     *
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @param defaultMessage : 没有设置key的时候的默认值.
     * @return
     */
    public static String getMessage(String code,Object[] args,String defaultMessage){
        try {
            //这里使用比较方便的方法，不依赖request.
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(code, args, defaultMessage, locale);
        }catch (NoSuchMessageException e) {
            return null;
        }
    }


    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        Assert.notNull(messageSource, "MessageSourceUtil not init ...");
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }


    public static String getMessage(String code, Object[] args, Locale locale) {
        Assert.notNull(messageSource, "MessageSourceUtil not init ...");
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }


    public static String getMessage(MessageSourceResolvable resolvable, Locale locale){
        Assert.notNull(messageSource, "MessageSourceUtil not init ...");
        try {
            return messageSource.getMessage(resolvable, locale);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }
}
