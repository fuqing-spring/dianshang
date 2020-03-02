package com.fq.constant;

public class ClientExceptionConstant extends Throwable {
    public static final String IMAGE_INVALID_ERRCODE = "0001";
    public static final String IMAGE_INVALID_ERRMSG = "image is not jpg or png";
    public static final String TOKEN_NOT_EXIST_ERRCODE = "0002";
    public static final String TOKEN_NOT_EXIST_ERRMSG = "token not exist";
    public static final String TOKEN_INVALID_ERRCODE = "0003";
    public static final String TOKEN_INVALID_ERRMSG = "token invalid";

    public static final String NOT_SUPPORT_STATIC_RESOURCE_ERRCODE = "0011";
    public static final String NOT_SUPPORT_STATIC_RESOURCE_ERRMSG = "not html,htm,css.js,jpg,jpeg,png,gif,ico,map";

    public static final String ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE = "0101";
    public static final String ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG = "administrator username not exist";
    public static final String ADNINISTRATOR_PASSWORD_INVALID_ERRCODE = "0102";
    public static final String ADNINISTRATOR_PASSWORD_INVALID_ERRMSG = "administrator password invalid";
}
