package com.lena.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Data
@TableName("sys_users")
public class Users implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String dept;

    private String email;

    private String headimage;

    private String gangweimingcheng;

    private Integer status;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

    private Date birthday;

    private Integer sex;

}
