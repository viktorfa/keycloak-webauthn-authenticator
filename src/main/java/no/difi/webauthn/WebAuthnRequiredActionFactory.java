package no.difi.webauthn;

import org.keycloak.Config;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

/**
 * @author <a href="mailto:veggitland@hotmail.com">Vegard Itland</a>
 */
public class WebAuthnRequiredActionFactory implements RequiredActionFactory {

    private static final WebAuthnRequiredAction SINGLETON = new WebAuthnRequiredAction();

    @Override
    public RequiredActionProvider create(KeycloakSession session) {
        return SINGLETON;
    }


    @Override
    public String getId() {
        return WebAuthnRequiredAction.PROVIDER_ID;
    }

    @Override
    public String getDisplayText() {
        return "WebAuthn";
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {

    }

    @Override
    public void close() {

    }

}
