package com.mena.userscenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author Mena
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -4651988309391840615L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
