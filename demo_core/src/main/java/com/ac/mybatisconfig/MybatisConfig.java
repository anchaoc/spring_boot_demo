package com.ac.mybatisconfig;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

/**
 * @author anchao
 * @date 2020/1/20 18:30
 */
@MapperScan(basePackages = {"com.ac.dao"})
@Configuration
public class MybatisConfig extends MybatisPlusAutoConfiguration {

    /**
     * 忽略初始化时扫描com.ac包警告
     */
    public MybatisConfig(MybatisPlusProperties properties
            , ObjectProvider<Interceptor[]> interceptorsProvider
            , ResourceLoader resourceLoader
            , ObjectProvider<DatabaseIdProvider> databaseIdProvider
            , ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider
            , ApplicationContext applicationContext) {

        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider, applicationContext);

    }
}
