package com.wyj.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhihui
 * @since 2022-07-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId("USER_ID")
    private String userId;

    @ApiModelProperty("隶属组织ID")
    @TableField("ORG_ID")
    private String orgId;

    @ApiModelProperty("用户账号")
    @TableField("`ACCOUNT`")
    private String account;

    @ApiModelProperty("用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty("密码")
    @TableField("`PASSWORD`")
    private String password;

    @ApiModelProperty("头像")
    @TableField("AVATAR")
    private String avatar;

    @ApiModelProperty("所属角色ID")
    @TableField("ROLE_ID")
    private String roleId;

    @ApiModelProperty("邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty("电话")
    @TableField("TEL_NUM")
    private String telNum;

    @ApiModelProperty("上级ID")
    @TableField("LEADER_ID")
    private String leaderId;

    @ApiModelProperty("注册时间")
    @TableField("REGISTER_TIME")
    private LocalDateTime registerTime;

    @ApiModelProperty("最后在线时间")
    @TableField("LAST_ONLINE")
    private LocalDateTime lastOnline;

    @ApiModelProperty("注销标识")
    @TableField("DELETED")
    private Integer deleted;

    @ApiModelProperty("锁定标识")
    @TableField("`LOCKED`")
    private Integer locked;

    @ApiModelProperty("生效时间")
    @TableField("EFFECT_TIME")
    private LocalDateTime effectTime;

    @ApiModelProperty("失效时间")
    @TableField("FAILURE_TIME")
    private LocalDateTime failureTime;


}
