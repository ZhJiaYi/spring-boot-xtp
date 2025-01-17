package com.xtp.project.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@ApiModel(value = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private String username;

    @ApiModelProperty(value = "")
    private String password;

    @Column(name = "nick_name")
    @ApiModelProperty(value = "")
    private String nickName;

    @ApiModelProperty(value = "")
    private Integer sex;

    @Column(name = "register_date")
    @ApiModelProperty(value = "")
    private Date registerDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return register_date
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}