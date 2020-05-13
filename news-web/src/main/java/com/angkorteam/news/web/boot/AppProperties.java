package com.angkorteam.news.web.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = true)
public class AppProperties {

    private int retryLimit;

    private String mailSenderHost;
    private int mailSenderPort;
    private String mailSenderProtocol;
    private boolean mailSenderSsl;
    private String mailSenderUsername;
    private String mailSenderPassword;
    private String mailSenderFrom;
    private String mailSenderName;

    private String jdbcDriverClassName;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    private String gsonDateFormat;

    private String secret;

    private int validityPeriod;

    private boolean debug;

    private String timezoneId;

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getMailSenderHost() {
        return mailSenderHost;
    }

    public void setMailSenderHost(String mailSenderHost) {
        this.mailSenderHost = mailSenderHost;
    }

    public int getMailSenderPort() {
        return mailSenderPort;
    }

    public void setMailSenderPort(int mailSenderPort) {
        this.mailSenderPort = mailSenderPort;
    }

    public String getMailSenderProtocol() {
        return mailSenderProtocol;
    }

    public void setMailSenderProtocol(String mailSenderProtocol) {
        this.mailSenderProtocol = mailSenderProtocol;
    }

    public boolean isMailSenderSsl() {
        return mailSenderSsl;
    }

    public void setMailSenderSsl(boolean mailSenderSsl) {
        this.mailSenderSsl = mailSenderSsl;
    }

    public String getMailSenderUsername() {
        return mailSenderUsername;
    }

    public void setMailSenderUsername(String mailSenderUsername) {
        this.mailSenderUsername = mailSenderUsername;
    }

    public String getMailSenderPassword() {
        return mailSenderPassword;
    }

    public void setMailSenderPassword(String mailSenderPassword) {
        this.mailSenderPassword = mailSenderPassword;
    }

    public String getMailSenderFrom() {
        return mailSenderFrom;
    }

    public void setMailSenderFrom(String mailSenderFrom) {
        this.mailSenderFrom = mailSenderFrom;
    }

    public String getMailSenderName() {
        return mailSenderName;
    }

    public void setMailSenderName(String mailSenderName) {
        this.mailSenderName = mailSenderName;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(int validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGsonDateFormat() {
        return gsonDateFormat;
    }

    public void setGsonDateFormat(String gsonDateFormat) {
        this.gsonDateFormat = gsonDateFormat;
    }

    public String getJdbcDriverClassName() {
        return jdbcDriverClassName;
    }

    public void setJdbcDriverClassName(String jdbcDriverClassName) {
        this.jdbcDriverClassName = jdbcDriverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public int getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(int retryLimit) {
        this.retryLimit = retryLimit;
    }

}
