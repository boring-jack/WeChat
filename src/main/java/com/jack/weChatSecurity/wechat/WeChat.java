package com.jack.weChatSecurity.wechat;

import com.jack.weChatSecurity.wechat.bean.SessionKey$OpenId;

public interface WeChat {

    SessionKey$OpenId getSessionKey$OpenId(String code);
}
