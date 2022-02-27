package com.jack.weChatSecurity.datasource.exception;

public class NotFindDatasourceException extends Exception{

    public NotFindDatasourceException() {
        super();
    }

    public NotFindDatasourceException(String message) {
        super(message);
    }

    public NotFindDatasourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFindDatasourceException(Throwable cause) {
        super(cause);
    }

    protected NotFindDatasourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
