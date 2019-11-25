package com.ac;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

/**
 * @author anchao
 * @date 2019/11/3 20:26
 */
@Data
@EqualsAndHashCode(exclude={"userBeans"})
public class UserBean {
    private Long id;
    private String name;
    private boolean flag;
    private List<UserBean> userBeans;



    public UserBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserBean userBean = (UserBean) o;
//        return flag == userBean.flag &&
//                Objects.equals(id, userBean.id) &&
//                Objects.equals(name, userBean.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, flag);
//    }
}
