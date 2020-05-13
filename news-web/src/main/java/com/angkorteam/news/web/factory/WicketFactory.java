package com.angkorteam.news.web.factory;

import com.angkorteam.news.web.HomePage;
import com.angkorteam.webui.frmk.common.AuthenticatedWicketFactory;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WicketFilter;

public class WicketFactory extends AuthenticatedWicketFactory {

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void destroy(WicketFilter filter) {
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return WebSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return HomePage.class;
    }

}
