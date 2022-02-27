package com.jack.weChatSecurity.core.exception;

public class UnknownTokenException extends Exception{

    public UnknownTokenException() {
        super();
    }

    public UnknownTokenException(String message) {
        super(message);
    }

    public UnknownTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownTokenException(Throwable cause) {
        super(cause);
    }
}
