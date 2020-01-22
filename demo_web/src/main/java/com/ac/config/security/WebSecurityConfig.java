package com.ac.config.security;

import com.ac.service.security.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author anchao
 * @date 2020/1/21 10:12
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name ="userService")
    private MyUserDetailsService userService;


    /**
     * 用户角色配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //加密 验证密码
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encode = bCryptPasswordEncoder.encode(rawPassword);
                log.info("encode encode-------------->{}",encode);
                return encode;
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                log.warn("matches encodedPassword-------------->{}",encodedPassword);
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                log.warn("matches rawPassword-------------->{}",rawPassword);
                System.err.println(bCryptPasswordEncoder.matches(rawPassword, encodedPassword));
                return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);

            }
        });
    }

    /**
     * 权限路径配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //放行
                .antMatchers("/","/index").permitAll()
                //其他认证
                .anyRequest().authenticated()
                .and()
                .formLogin().successForwardUrl("/index")
                .failureUrl("/login-error").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index");

    }

    //    public static void main(String[] args) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123");
//        log.info("encode encode-------------->{}",encode);
//    }
}
