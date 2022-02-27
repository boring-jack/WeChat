package com.jack.weChatSecurity.core.token;

import com.jack.weChatSecurity.core.CurrentUser;

public interface TokenGenerator {

    String createToken(CurrentUser user);
}
