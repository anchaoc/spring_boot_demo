package com.ac.config.security;

import com.ac.service.security.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author anchao
 * @date 2020/1/21 10:12
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userService;


    /**
     * 用户角色配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encode = bCryptPasswordEncoder.encode(rawPassword);
                log.debug("encode encode={}",encode);
                return encode;
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                log.debug("matches encodedPassword={}",encodedPassword);
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                log.warn("matches rawPassword={}",rawPassword);
                return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);

            }
        });
//        auth
//                .inMemoryAuthentication()
//                .withUser("anchao")
//                .password(passwordEncoder().encode("anchao123"))
//                .authorities("TAX_QUERY");
    }

    /**
     * 权限路径配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().successForwardUrl("/t/list")
                .and()
                .exceptionHandling().accessDeniedPage( "/403" );
        http.logout().logoutSuccessUrl( "/" );
        //        http
//                .authorizeRequests()
//                .antMatchers("/t/add").hasAnyAuthority("TAX_ADD")
//                .antMatchers("/t/query").hasAnyAuthority("TAX_QUERY")
//                .antMatchers("/**")
//                .fullyAuthenticated()
//                .and()
//                .formLogin();

    }

}
