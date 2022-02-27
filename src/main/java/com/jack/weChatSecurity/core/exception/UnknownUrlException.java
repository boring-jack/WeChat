package com.jack.weChatSecurity.core.exception;

public class UnknownUrlException extends Exception{

    public UnknownUrlException() {
        super();
    }

    public UnknownUrlException(String message) {
        super(message);
    }

    public UnknownUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownUrlException(Throwable cause) {
        super(cause);
    }

    protected UnknownUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
