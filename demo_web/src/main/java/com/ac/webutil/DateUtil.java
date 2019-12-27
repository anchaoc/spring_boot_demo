package com.ac.webutil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author anchao
 * @date 2019/12/27 15:41
 */
@Slf4j
public class DateUtil {

    public static final String DATE_FOLDER = "yyyy/MM/dd";
    public static final String YYYYMMDDHHMMSSS = "yyyyMMddHHmmSSS";


    /**
     * 获取存储文件地址
     */
    public static String getDateFolder(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        javax.servlet.http.HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("DateUtil.getDateFolder.request={}",request);
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FOLDER));
        String realPath =request.getContextPath();
        String path = realPath+"/"+dateTime;
        log.info("DateUtil.getDateFolder.path={}",path);
        return path;
    }


}
