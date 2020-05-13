package com.angkorteam.news.web;

import com.angkorteam.news.dao.tables.daos.PageDAO;
import com.angkorteam.news.dao.tables.daos.WidgetAttributeDAO;
import com.angkorteam.news.dao.tables.daos.WidgetDAO;
import com.angkorteam.news.web.boot.AppProperties;
import com.angkorteam.news.web.factory.JavaMailSenderFactoryBean;
import com.angkorteam.news.web.factory.WicketFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootApplication.class, args);
    }

    public static ApplicationContext getApplicationContext() {
        return WicketFactory.getApplicationContext();
    }

    @Bean
    public Gson createGson(AppProperties properties) {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.setDateFormat(properties.getGsonDateFormat());
        return builder.create();
    }

    @Bean(destroyMethod = "close")
    public DataSource createDataSource(AppProperties properties, TextEncryptor textEncryptor) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getJdbcDriverClassName());
        dataSource.setUrl(properties.getJdbcUrl());
        dataSource.setUsername(properties.getJdbcUsername());
        try {
            dataSource.setPassword(textEncryptor.decrypt(properties.getJdbcPassword()));
        } catch (Throwable e) {
            dataSource.setPassword(properties.getJdbcPassword());
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean("passwordEncryptor")
    public PasswordEncryptor createPasswordEncryptor() {
        return new StrongPasswordEncryptor();
    }

    @Bean("textEncryptor")
    public TextEncryptor createTextEncryptor(AppProperties properties) {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(properties.getSecret());
        return textEncryptor;
    }

    @Bean
    public JavaMailSenderFactoryBean createJavaMailSender(AppProperties properties) {
        JavaMailSenderFactoryBean factory = new JavaMailSenderFactoryBean();
        factory.setPassword(properties.getMailSenderPassword());
        factory.setUsername(properties.getMailSenderUsername());
        factory.setSsl(properties.isMailSenderSsl());
        factory.setProtocol(properties.getMailSenderProtocol());
        factory.setHost(properties.getMailSenderHost());
        factory.setPort(properties.getMailSenderPort());
        factory.setDebug(properties.isDebug());
        return factory;
    }

    @Bean(destroyMethod = "close")
    public DSLContext createContext(DataSource dataSource) {
        Settings settings = new Settings();

        settings.withUpdateRecordVersion(true);
        settings.withUpdateRecordTimestamp(true);
        settings.withExecuteWithOptimisticLocking(true);
        settings.withExecuteWithOptimisticLockingExcludeUnversioned(false);

        settings.withUpdatablePrimaryKeys(false);
        settings.setStatementType(StatementType.PREPARED_STATEMENT);
        settings.withReturnAllOnUpdatableRecord(true);
        settings.withReturnRecordToPojo(true);
        settings.withRenderSchema(false);
        settings.withRenderFormatted(true);
        settings.withRenderCatalog(false);
        settings.withAttachRecords(true);

        return DSL.using(dataSource, SQLDialect.MYSQL, settings);
    }

    @Bean
    public ScheduledExecutorService createScheduledExecutorService() {
        return Executors.newScheduledThreadPool(2);
    }

    @Bean
    public PageDAO createPageDAO(DSLContext context) {
        return new PageDAO(context.configuration());
    }

    @Bean
    public WidgetDAO createWidgetDAO(DSLContext context) {
        return new WidgetDAO(context.configuration());
    }

    @Bean
    public WidgetAttributeDAO createWidgetAttributeDAO(DSLContext context) {
        return new WidgetAttributeDAO(context.configuration());
    }

}
