package io.purewind.pac4j.jd;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConfig;
import com.github.scribejava.core.oauth.OAuth20Service;

public class JdOAuth20Service extends OAuth20Service {

    public JdOAuth20Service(DefaultApi20 api, OAuthConfig config) {
        super(api, config);
    }

    @Override
    public void signRequest(OAuth2AccessToken accessToken, AbstractRequest request) {
        super.signRequest(accessToken, request);
        request.addHeader("Accept-Charset", "utf-8");
    }

}
