package com.angkorteam.news.web.factory;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class WebSession extends AuthenticatedWebSession {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSession.class);

    private String superUserUuid;

    private Roles roles;

    private String hostName;

    private String tenantUuid;

    private String userUuid;

    public WebSession(Request request) {
        super(request);
        HttpServletRequest req = (HttpServletRequest) request.getContainerRequest();
        this.hostName = req.getServerName();
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return true;
    }


    @Override
    public Roles getRoles() {
        return this.roles;
    }

    public String getTenantUuid() {
        return this.tenantUuid;
    }

    public String getUserUuid() {
        return this.userUuid;
    }

    public String getSuperUserUuid() {
        return this.superUserUuid;
    }


}
