package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//prefix = "sky.jwt": 这句话相当于告诉 Spring：“请去配置文件里找到以 sky.jwt 开头的那一部分配置块。”
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {

    /**
     * 管理端员工生成jwt令牌相关配置
     * 当 Spring 尝试将 YAML 配置项封装赋值给Java对象字段时，它会遵循以下规则：
     * 1.忽略大小写。
     * 2.忽略短横线 - 和下划线 _ ，将属性名称转换为驼峰命名法。
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    /**
     * 用户端微信用户生成jwt令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}
