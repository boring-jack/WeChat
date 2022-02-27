package com.jack.weChatSecurity.config.exception;

public class NoDatasourceConfigException extends Exception{

    public NoDatasourceConfigException() {
        super();
    }

    public NoDatasourceConfigException(String message) {
        super(message);
    }

    public NoDatasourceConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDatasourceConfigException(Throwable cause) {
        super(cause);
    }

    protected NoDatasourceConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
