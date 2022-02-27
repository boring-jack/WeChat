package com.jack.weChatSecurity.core.urlmatcher;

import com.jack.weChatSecurity.core.exception.UnknownUrlException;

import java.util.List;

public interface UrlMatcher {

    void init(List<String> includePath, List<String> excludePath);

    boolean urlMatcher(String url)throws UnknownUrlException;

}
