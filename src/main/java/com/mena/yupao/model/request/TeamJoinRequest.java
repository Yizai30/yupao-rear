package com.mena.yupao.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 队伍
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = -2488024687242280811L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}