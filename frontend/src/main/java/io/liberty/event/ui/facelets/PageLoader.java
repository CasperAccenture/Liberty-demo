package io.liberty.event.ui.facelets;

import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;

@Named("pageLoader")
@SessionScoped
public class PageLoader implements Serializable {

    private static final long serialVersionUID = 1L;

    private String content = "content/mainPage.xhtml";
    private String headerContent = "header/header.xhtml";
    private String navBar = "navBar/leftNav.xhtml";
    private String currentPage = "Events";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNavBar() {
        return navBar;
    }

    public void setNavBar(String navBar) {
        this.navBar = navBar;
    }

    public String getHeaderContent() {
        return this.headerContent;
    }

    public void setHeaderContent(String headerContent) {
        this.headerContent = headerContent;
    }

    public String getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

}