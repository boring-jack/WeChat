package com.jack.weChatSecurity.core.token;

import com.jack.weChatSecurity.core.CurrentUser;

import java.util.UUID;

public class DefaultTokenGenerator implements TokenGenerator {

    @Override
    public String createToken(CurrentUser user) {
        return UUID.randomUUID().toString();
    }

}
