package com.bootcamp.linktracker.entity;

public class Link {

    private final Long linkId;

    private String url;

    private Boolean active;

    private Long redirects;

    private String pass;

    private static long linkCount;

    public Link(){
        this.linkId = ++Link.linkCount;
        this.active = false;
        this.pass = null;
    }

    public Link(String url) {
        this.url = url;
        this.active = true;
        this.linkId = ++Link.linkCount;
        this.redirects = 0L;
        this.pass = null;
    }

    public Link(String url, String pass) {
        this.url = url;
        this.active = true;
        this.linkId = ++Link.linkCount;
        this.redirects = 0L;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getRedirects() {
        return redirects;
    }

    public Long getLinkId() {
        return linkId;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setRedirects(Long redirects) {
        this.redirects = redirects;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
