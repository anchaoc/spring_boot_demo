package com.ac.mongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author anchao
 * @date 2020/1/15 13:41
 */
@Slf4j
@Component
public class MongoService {

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    public List<Map> query(CriteriaDefinition c,String name){
//        try {
//            Query query = new Query(c);
//            List<Map> maps = mongoTemplate.find(query, Map.class, name);
//            log.info("MongoService maps={}",maps);
//            return maps;
//        } catch (Exception e) {
//               log.error("MongoService query error=",e);
//        }
//        return new ArrayList<>();
//    }

}
