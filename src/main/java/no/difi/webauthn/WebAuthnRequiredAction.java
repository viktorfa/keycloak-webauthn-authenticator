package no.difi.webauthn;

import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.UserCredentialModel;

import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:veggitland@hotmail.com">Vegard Itland</a>
 */
public class WebAuthnRequiredAction implements RequiredActionProvider {
    public static final String PROVIDER_ID = "webauthn_config";

    @Override
    public void evaluateTriggers(RequiredActionContext context) {

    }

    @Override
    public void requiredActionChallenge(RequiredActionContext context) {
        Response challenge = context.form().createForm("webauthn.ftl");
        context.challenge(challenge);

    }

    @Override
    public void processAction(RequiredActionContext context) {
        String answer = (context.getHttpRequest().getDecodedFormParameters().getFirst("secret_answer"));
        UserCredentialModel input = new UserCredentialModel();
        input.setType(WebAuthnCredentialProvider.WEBAUTHN);
        input.setValue(answer);
        context.getSession().userCredentialManager().updateCredential(context.getRealm(), context.getUser(), input);
        context.success();
    }

    @Override
    public void close() {

    }
}
