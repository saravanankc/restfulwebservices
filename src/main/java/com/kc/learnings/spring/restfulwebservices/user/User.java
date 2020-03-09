package com.kc.learnings.spring.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details about the user!")
public class User {

    private int id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @ApiModelProperty(name = "Name of user", example = "Swagger Admin user", notes = "Name should have at least 2 characters")
    private String name;

    @Past(message = "Birth date cannot be greater than or equal to current date")
    @ApiModelProperty(name = "Name of user", example = "Swagger Admin user", notes = "Birth date cannot be greater than or equal to current date")
    private Date birthDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


}
