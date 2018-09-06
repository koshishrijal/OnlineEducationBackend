package com.asky.backend.config;

public class SecurityConstants {

    public static final String SECRET="thisIsSecretString";
    public static final long EXPIRATION_TIME=864000000;
    public static final String TOKEN_PREFIX="Bearer ";
    public static final String HEADER_STRING="Authorization";
    public static final String SIGN_UP_URL="/api/users/students/student";
    public static final String TEST_URL="/api/contents/videos";
}
