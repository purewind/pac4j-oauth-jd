package io.purewind.pac4j.jd;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.config.OAuth20Configuration;
import org.pac4j.oauth.profile.JsonHelper;
import org.pac4j.oauth.profile.definition.OAuth20ProfileDefinition;

/**
 * Created by king on 2018/1/22.
 */
public class JdAttributesDefinition extends OAuth20ProfileDefinition<JdProfile> {

    public static final String UID = "uid";             //数据库业务id
    public static final String USER_NICK = "user_nick";                  //openid。

    public JdAttributesDefinition() {
        primary(UID, Converters.STRING);
        primary(USER_NICK, Converters.STRING);
    }

    @Override
    public String getProfileUrl(OAuth2AccessToken accessToken, OAuth20Configuration configuration) {
        return null;
    }

    @Override
    public JdProfile extractUserProfile(String body) throws HttpAction {
        JdProfile profile = new JdProfile();
        final JsonNode json = JsonHelper.getFirstNode(body);
        if (null != json) {
            profile.setId(JsonHelper.getElement(json, UID));
            for (final String attribute : this.getPrimaryAttributes()) {
                Object obj = JsonHelper.getElement(json, attribute);
                if (obj != null)
                    profile.addAttribute(attribute, obj.toString());
            }
        }
        return profile;
    }
}
