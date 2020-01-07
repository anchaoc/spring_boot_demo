package com.ac.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author anchao
 * @date 2020/1/7 15:07
 */
@XmlRootElement
public class ListUserDTO {

    private List<User> users;

    public ListUserDTO(List<User> users) {
        this.users = users;
    }

    public ListUserDTO() {
        this.users = users;
    }

    @XmlElement
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
