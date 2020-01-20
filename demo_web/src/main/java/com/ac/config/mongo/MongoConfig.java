//package com.ac.config.mongo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mapping.context.MappingContext;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//
//import java.util.HashMap;
//import java.util.HashSet;
//
///**未使用
// * @author anchao
// * @date 2020/1/15 14:43
// */
//@Configuration
//public class MongoConfig {
//
//
//
//    @Bean
//    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory){
//        MongoMappingContext mongoMappingContext = new MongoMappingContext();
//        HashSet<Class<?>> clazz = new HashSet<>();
//        clazz.add(HashMap.class);
//        mongoMappingContext.setInitialEntitySet(clazz);
//        mongoMappingContext.afterPropertiesSet();
//        return  new MongoTemplate(mongoDbFactory,mappingMongoConverter(mongoDbFactory,mongoMappingContext));
//    }
//
//    public MappingMongoConverter mappingMongoConverter(MongoDbFactory mongoDbFactory, MappingContext mappingContext){
//        DefaultDbRefResolver defaultDbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
//        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(defaultDbRefResolver, mappingContext);
//        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper());
//        return mappingMongoConverter;
//    }
//}

