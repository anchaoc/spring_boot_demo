package com.ac.model;

import com.ac.dao.RoleMapper;
import com.ac.dao.UserRoleMapper;
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
@TableName("user")
public class User implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编号
     */
    private String usercode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 删除标识
     */
    private Integer del;

    /**
     * 用户角色
     */
    @TableField(exist = false)
    private List<Role> roleList;





    /**
     * 设置用户对应角色集合
     */
    public User getSetRoleList(UserRoleMapper userRoleMapper,RoleMapper roleMapper){

        LambdaQueryWrapper<UserRole> userQuery = Wrappers.lambdaQuery();
        userQuery.eq(UserRole::getUserId,this.getId());

        List<UserRole> userRoles = userRoleMapper.selectList(userQuery);

        if(CollectionUtils.isEmpty(userRoles)){
            this.setRoleList(new ArrayList<>());
            return this;
        }

        Set<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());

        LambdaQueryWrapper<Role> roleQuery = Wrappers.lambdaQuery();
        roleQuery.in(Role::getId,roleIds);

        List<Role> roles = roleMapper.selectList(roleQuery);

        this.setRoleList(roles);

        return this;
    }






    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
