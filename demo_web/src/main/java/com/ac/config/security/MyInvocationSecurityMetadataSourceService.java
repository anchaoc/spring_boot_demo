package com.ac.config.security;

import com.ac.dao.PermissionMapper;
import com.ac.dao.RoleMapper;
import com.ac.dao.RolePermissionMapper;
import com.ac.model.Permission;
import com.ac.model.Role;
import com.ac.model.RolePermission;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author anchao
 * @date 2020/1/21 18:35
 */
@Slf4j
@Component
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 返回请求的资源需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        log.warn("MyInvocationSecurityMetadataSourceService getAttributes o={}", o);
        if (null == map) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
            String url = it.next();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }

        return null;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    private void loadResourceDefine() {

        map = new HashMap<>(16);
        //角色权限表信息
        List<RolePermission> rolePermissons = rolePermissionMapper.selectList(Wrappers.query());
        if (CollectionUtils.isEmpty(rolePermissons)) {
            throw new AuthenticationServiceException("角色权限信息异常!");
        }

        //资源对应角色 储存请求与权限的对应关系。
        rolePermissons.forEach(rp -> {
            Permission permission = permissionMapper.selectById(rp.getPermissionId());
            Role role = roleMapper.selectById(rp.getRoleId());
            String url = permission.getUrl();
            String roleName = role.getName();
            ConfigAttribute securityConfig = new SecurityConfig(roleName);
            if (map.containsKey(url)) {
                map.get(url).add(securityConfig);
            } else {
                List<ConfigAttribute> list = new ArrayList<>();
                list.add(securityConfig);
                map.put(url, list);
            }

        });
    }

}
