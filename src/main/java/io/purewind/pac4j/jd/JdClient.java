package io.purewind.pac4j.jd;

import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.client.OAuth20Client;

public class JdClient extends OAuth20Client<JdProfile> {


    private String scope;

    @Override
    protected void clientInit(WebContext context) {
        configuration.setApi(JdApi.instance());
        configuration.setProfileDefinition(new JdAttributesDefinition());
        configuration.setScope(this.scope);
        setConfiguration(configuration);
        super.clientInit(context);
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
