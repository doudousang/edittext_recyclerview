package com.li.gohome.baen;

public class CommonModel {
    private String icon;
    private String title;
    private String statusBarColor;
    private String url;
    private boolean hideAppBar;

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHideAppBar() {
        return hideAppBar;
    }

    public void setHideAppBar(boolean hideAppBar) {
        this.hideAppBar = hideAppBar;
    }
}
