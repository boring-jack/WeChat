package com.jack.weChatSecurity.monitor;

import com.jack.weChatSecurity.core.Security;
import com.jack.weChatSecurity.core.SecurityContext;

/**
 * 监听SessionMap
 */
public interface Monitor extends Runnable {

    void registerSecurityContext(SecurityContext securityContext);

}
