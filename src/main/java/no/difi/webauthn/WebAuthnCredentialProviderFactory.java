package no.difi.webauthn;

import org.keycloak.credential.CredentialProvider;
import org.keycloak.credential.CredentialProviderFactory;
import org.keycloak.models.KeycloakSession;

/**
 * @author <a href="mailto:veggitland@hotmail.com">Vegard Itland</a>
 */
public class WebAuthnCredentialProviderFactory implements CredentialProviderFactory<WebAuthnCredentialProvider> {
    @Override
    public String getId() {
        return "webauthn";
    }

    @Override
    public CredentialProvider create(KeycloakSession session) {
        return new WebAuthnCredentialProvider(session);
    }
}

