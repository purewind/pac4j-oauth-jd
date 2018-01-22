package io.purewind.pac4j.jd;

import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;

public class JdTokenExtractor extends OAuth2AccessTokenJsonExtractor {

    private static final String USER_NICK_REGEX = "\"user_nick\"\\s*:\\s*\"(\\S*?)\"";
    private static final String UID_REGEX = "\"uid\"\\s*:\\s*\"(\\S*?)\"";
    private static final String CODE_REGEX = "\"code\"\\s*:\\s*\"(\\S*?)\"";
    private static final String TOKEN_TYPE_REGEX = "\"token_type\"\\s*:\\s*\"(\\S*?)\"";
    private static final String TIME_REGEX = "\"time\"\\s*:\\s*\"(\\S*?)\"";

    protected JdTokenExtractor() {
    }

    private static class InstanceHolder {
        private static final JdTokenExtractor INSTANCE = new JdTokenExtractor();
    }

    public static JdTokenExtractor instance() {
        return JdTokenExtractor.InstanceHolder.INSTANCE;
    }

    @Override
    protected OAuth2AccessToken createToken(String accessToken, String tokenType, Integer expiresIn,
                                            String refreshToken, String scope, String response) {
        JdToken jdToken = new JdToken(accessToken, tokenType, expiresIn, refreshToken, scope, response);
        jdToken.setNickName(extractParameter(response, USER_NICK_REGEX, false));
        jdToken.setUid(extractParameter(response, UID_REGEX, false));
        jdToken.setCode(extractParameter(response, CODE_REGEX, false));
        jdToken.setTokenType(extractParameter(response, TOKEN_TYPE_REGEX, false));
        jdToken.setTime(Long.parseLong(extractParameter(response, TIME_REGEX, true)));
        return jdToken;
    }
}
