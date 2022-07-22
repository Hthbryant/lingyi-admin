package com.lingyi.biz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 咕噜科
 * ClassName: Player
 * date: 2022-07-23 0:19
 * Description:
 * version 1.0
 */
@Data
@TableName(value = "t_player")
public class Player implements Serializable {

    @TableId(value = "id")
    private int id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private int age;
    @TableField(value = "phone")
    private String phone;

}
