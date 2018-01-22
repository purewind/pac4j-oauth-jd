package io.purewind.pac4j.jd;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.oauth.OAuth20Service;

public class JdApi extends DefaultApi20 {

    private static final String AUTHORIZE_URL = "https://oauth.jd.com/oauth/authorize";

    @Override
    protected String getAuthorizationBaseUrl() {
        return AUTHORIZE_URL;
    }

    private static class InstanceHolder {
        private static final JdApi INSTANCE = new JdApi();
    }

    public static JdApi instance() {
        return JdApi.InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://oauth.jd.com/oauth/token";
    }

    @Override
    public OAuth20Service createService(OAuthConfig config) {
        return new JdOAuth20Service(this, config);
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return JdTokenExtractor.instance();
    }
}
