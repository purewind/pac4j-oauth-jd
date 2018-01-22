package io.purewind.pac4j.jd;

import com.github.scribejava.core.model.OAuth2AccessToken;

public class JdToken extends OAuth2AccessToken {

    private String code;
    private String nickName;
    private long time;
    private String tokenType;
    private String uid;

    public JdToken(String accessToken) {
        super(accessToken);
    }

    public JdToken(String accessToken, String rawResponse) {
        super(accessToken, rawResponse);
    }

    public JdToken(String accessToken, String tokenType, Integer expiresIn, String refreshToken, String scope, String rawResponse) {
        super(accessToken, tokenType, expiresIn, refreshToken, scope, rawResponse);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
