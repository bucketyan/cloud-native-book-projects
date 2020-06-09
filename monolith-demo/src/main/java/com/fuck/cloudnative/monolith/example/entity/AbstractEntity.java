package com.fuck.cloudnative.monolith.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
* DESCRIPTION:
* 基础抽象实体类
* @author zouyan
* @create 2020/5/13-下午2:01
* created by fuck~
**/
@Data //提供类的get、set、equals、hashCode、canEqual、toString方法
@MappedSuperclass //基类的属性会被继承
@EntityListeners(AuditingEntityListener.class) //指定Entity或者superclass上的回调监听类 JPA Entity Listener，当Entity发生持久化和更新操作时用于捕获监听信息
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate //通过AuditingEntityListener根据对应注释自动注入值
    @Column(name = "create_time", nullable = false)
    @JsonIgnore
    private Instant createTime = Instant.now();

    @LastModifiedDate //通过AuditingEntityListener根据对应注释自动注入值
    @Column(name = "update_time")
    @JsonIgnore
    private Instant updateTime = Instant.now();
}