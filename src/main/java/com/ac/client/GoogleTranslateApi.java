package com.ac.client;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author anchao
 * @date 2019/12/18 17:56
 */
@Slf4j
@Component
public class GoogleTranslateApi {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "https://translate.googleapis.com/translate_a/single?client=gtx&sl={fromCulture}&tl={toCulture}&dt=t&q={text}";



    public void getranslate(){
        ResponseEntity<JsonObject> result = restTemplate.postForEntity(URL, "", JsonObject.class);
        log.info("GoogleTranslateApi,getranslate,result={}",result);
    }
}
