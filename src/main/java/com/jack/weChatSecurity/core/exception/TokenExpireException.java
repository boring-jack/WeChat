package com.jack.weChatSecurity.core.exception;

public class TokenExpireException extends Exception{

    public TokenExpireException() {
        super();
    }

    public TokenExpireException(String message) {
        super(message);
    }

    public TokenExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenExpireException(Throwable cause) {
        super(cause);
    }
}
