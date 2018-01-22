package io.purewind.pac4j.jd;

import org.pac4j.oauth.profile.OAuth20Profile;

public class JdProfile extends OAuth20Profile {

    public String getUid() {
        return (String) this.getAttribute(JdAttributesDefinition.UID);
    }

    public String getUsetNick() {
        return (String) this.getAttribute(JdAttributesDefinition.USER_NICK);
    }

}
