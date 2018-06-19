# Keycloak Webauthn Authenticator

## Instructions

#### You need
* A running Keycloak 4 server
* Maven
* Java 8
* Yubikey device
* An appropriately configured Spring Boot application such as [this one](https://github.com/difi/dc18-webAuth)

#### Build and deploy the project
1. Clone the Git repo `git clone git@github.com:viktorfa/keycloak-webauthn-authenticator.git` or `git clone https://github.com/viktorfa/keycloak-webauthn-authenticator.git` if you don't have ssh credentials.
2. Enter the folder with `cd keycloak-webauthn-authenticator`
3. Make sure Keycloak is running. Verify this by entering [https://localhost:8443](https://localhost:8443).
4. Build and deploy with Maven `mvn clean install wildfly:deploy`.


#### Configure Keycloak
1. Create a realm called `Webauthn`
2. Create a client called `webauthn`
3. Make `http://localhost:8081/*` a valid redirect URI for this client.
4. Enter the Authentication page and make a copy of the browser flow. Add U2F as a required execution to this flow. 
5. Enter the Bindings tab and change Browser Flow to the new flow (Copy of browser).
6. Enter the Required Actions tab and click Register to register U2F.
7. Check Default Action for Register U2F
8. Enter the Users page and add a user called `a`.
9. Enter the Credentials tab and make the password `p`, uncheck Temporary, and click Reset Password.
10. Enter the Roles page and add a role called `user`.
11. Go back the to Users page, click View all users, click the only user there, enter the Role Mappings tab, click user in Available roles, and click Add selected.


#### Configure the Spring Boot application
1. Make sure the `application.proprties` file has the following contents:
```
#Keycloak Configuration
keycloak.auth-server-url=https://localhost:8443/auth
keycloak.realm=Webauthn
keycloak.resource=webauthn
keycloak.public-client=true
keycloak.principal-attribute=preferred_username
server.port=8081
```

#### Try it all out
1. Start the Spring Boot application with `mvn spring-boot:run`.
2. Enter `http://localost:8081` and click customers or some page you need to sign in to see.
3. Sign in with user `a` and password `p` and follow the U2F instructions.
4. Welcome to the future.
