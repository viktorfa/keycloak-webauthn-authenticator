<#import "template.ftl" as layout>
<@layout.registrationLayout; section>
    <#if section = "title">
        ${msg("loginTitle",realm.name)}
    <#elseif section = "header">
        ${msg("loginTitleHtml",realm.name)}
    <#elseif section = "form">
        <form id="kc-totp-login-form" action="${url.loginAction}" method="post">
            <label for="totp">Press Yubikey security key to continue</label>
            <input id="totp" name="secret_answer" type="text"/>
            <input name="login" id="kc-login" type="submit" value="${msg("doLogIn")}"/>
            <input name="cancel" id="kc-cancel" type="submit" value="${msg("doCancel")}"/>
        </form>
    </#if>
</@layout.registrationLayout>
