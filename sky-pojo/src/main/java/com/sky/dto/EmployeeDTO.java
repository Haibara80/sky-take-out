package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

//同样的Employee类单独做一个DTO精确封装（只封装前端需要使用的字段），避免把密码等敏感信息传递到前端
@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}
