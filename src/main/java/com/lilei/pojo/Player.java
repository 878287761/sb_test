package com.lilei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable {
    /**
    * 玩家id
    */
    private Integer id;

    /**
    * 玩家昵称
    */
    private String name;

    /**
    * 玩家资产
    */
    private Long been;

    /**
    * 经验 经验满等级加1
    */
    private Integer exp;

    /**
    * 等级 最大99级
    */
    private Integer level;

    /**
    * 关联用户id
    */
    private Integer userId;
}