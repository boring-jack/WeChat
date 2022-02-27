package com.jack.weChatSecurity.core.urlmatcher;

import com.jack.weChatSecurity.core.exception.UnknownUrlException;

import java.util.List;

public class DefaultUrlMatcher implements UrlMatcher{

    private List<String> includePath;
    private List<String> excludePath;

    @Override
    public void init(List<String> includePath,List<String> excludePath) {
        this.includePath=includePath;
        this.excludePath=excludePath;
    }

    @Override
    public boolean urlMatcher(String url) throws UnknownUrlException {
        if(excludePath.contains(url)){
            return false;
        }else if(includePath.contains(url)){
            return true;
        }else throw new UnknownUrlException("未知url");
    }
}
