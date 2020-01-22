package com.ac.service.security;

import com.ac.dao.*;
import com.ac.model.Permission;
import com.ac.model.Role;
import com.ac.model.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anchao
 * @date 2020/1/21 17:56
 */
@Slf4j
@Component("userService")
public class MyUserDetailsService extends ServiceImpl<UserMapper, User> implements UserDetailsService {


    @Resource
    private UserRoleMapper ur;
    @Resource
    private RoleMapper r;
    @Resource
    private RolePermissionMapper rp;
    @Resource
    private PermissionMapper p;
    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，
     * 因为资源是不变的，而用户的角色是会变的
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> userQuery = Wrappers.lambdaQuery();
        userQuery.eq(User::getUsername, username);
        User u = baseMapper.selectOne(userQuery);
        if (null == u) {
            throw new UsernameNotFoundException(username);
        }
        u.getSetRoleList(ur,r);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : u.getRoleList()) {
            role.getSetPermissionList(rp,p);
            for (Permission permission : role.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }
        log.info("loadUserByUsername ----->name={},password={}",u.getUsername(),u.getPassword());
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
    }


}
