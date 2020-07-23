package com.fabienjouanneau.sharemycar.website.core.security;

public class SecurityConstants {
    public static final String SECRET = "Sh@r3MyCar!2020";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String GET_ALL_ADVERTS_URL = "/adverts";
}