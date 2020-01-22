package com.ac.service.security;

import com.ac.dao.RoleMapper;
import com.ac.dao.UserMapper;
import com.ac.dao.UserRoleMapper;
import com.ac.model.Role;
import com.ac.model.User;
import com.ac.model.UserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/1/21 17:56
 */
@Component
public class MyUserDetailsService extends ServiceImpl<UserMapper,User> implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper ;

    @Resource
    private RoleMapper roleMapper;

    /**
     * 以名称获取用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //取用户信息
        LambdaQueryWrapper<User> userQuery = Wrappers.lambdaQuery();
        userQuery.eq(User::getUsername, userName);
        User user = userMapper.selectOne(userQuery);

        if (null == user) {
            throw new UsernameNotFoundException("用户: " + userName + " 不存在！");
        }

        //取用户对应角色信息
        LambdaQueryWrapper<UserRole> userRoleQuery = Wrappers.lambdaQuery();
        userRoleQuery.eq(UserRole::getUserId, user.getId());
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleQuery);

        if (CollectionUtils.isEmpty(userRoles)) {
            throw new AuthenticationServiceException("用户: "+userName+" 角色信息不存在!");
        }

        Set<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());

        //取角色集合
        LambdaQueryWrapper<Role> roleQuery = Wrappers.lambdaQuery();
        roleQuery.in(Role::getId,roleIds);
        List<Role> roles = roleMapper.selectList(roleQuery);

        if (CollectionUtils.isEmpty(roles)) {
            throw new AuthenticationServiceException("用户: "+userName+" 角色信息不存在!");
        }

        //存放角色信息
        user.setAuthorities(roles);

        //返回用户信息
        return user;
    }
}
