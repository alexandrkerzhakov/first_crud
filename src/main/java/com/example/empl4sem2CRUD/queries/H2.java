package com.example.empl4sem2CRUD.queries;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "h2")
public class H2 {
    private String selectUser;
    private String insertUser;
    private String updateUser;
    private String deleteUser;
    private String selectUserFindById;

    public String getSelectUser() {
        return selectUser;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public String getSelectUserFindById() {
        return selectUserFindById;
    }

    public void setSelectUser(String selectUser) {
        this.selectUser = selectUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public void setSelectUserFindById(String selectUserFindById) {
        this.selectUserFindById = selectUserFindById;
    }
}
