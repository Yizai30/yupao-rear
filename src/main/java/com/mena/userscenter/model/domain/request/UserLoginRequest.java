package com.mena.userscenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author Mena
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -4651988309391840615L;

    private String userAccount;

    private String userPassword;
}
