package com.ac.model;

import com.ac.dao.PermissionMapper;
import com.ac.dao.RolePermissionMapper;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@ToString
@TableName("role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色拥有的权限
     */
    @TableField(exist = false)
    private List<Permission> permissionList;







    /**
     * 设置角色对应权限集合
     */
    public Role getSetPermissionList(RolePermissionMapper rolePermissionMapper,PermissionMapper permissionMapper) {

        LambdaQueryWrapper<RolePermission> rolePermissionQuery = Wrappers.lambdaQuery();
        rolePermissionQuery.eq(RolePermission::getRoleId,this.getId());

        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(rolePermissionQuery);

        if(CollectionUtils.isEmpty(rolePermissions)){
            this.setPermissionList(new ArrayList<>());
            return this;
        }

        Set<Long> permissionIds = rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toSet());

        LambdaQueryWrapper<Permission> permissionQuery = Wrappers.lambdaQuery();
        permissionQuery.in(Permission::getId,permissionIds);

        List<Permission> permissions = permissionMapper.selectList(permissionQuery);

        this.setPermissionList(permissions);

        return this;
    }



    public Role() {
    }

    public Role(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}
