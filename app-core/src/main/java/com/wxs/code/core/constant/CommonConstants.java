package com.wxs.code.core.constant;

public class CommonConstants {

    public static final String YES = "Y";
    public static final String NO = "N";

    public static final class HTTP_STATUS{
        public static final int OK = 200;
        public static final int CREATED = 201;
        public static final int NO_CONTENT = 204;
        public static final int BAD_REQUEST = 400;
        public static final int UNAUTHORIZED = 401;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int SERVER_ERROR = 500;
    }

    public static final class FRONT_FIELD{
        /**
         * 保存签名的头部字段
         */
        public static final String AUTHORIZATION = "X-Auth-Token";
    }
}
