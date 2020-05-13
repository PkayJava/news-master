package com.angkorteam.news.web.generator;

import com.angkorteam.news.dao.tables.PageTable;
import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.WidgetTable;
import com.angkorteam.news.dao.tables.records.PageRecord;
import com.angkorteam.news.dao.tables.records.WidgetRecord;
import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;

import java.util.UUID;

public class Program {

    public static final String PAGE_UUID = "'uuid_001'";

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setUrl("jdbc:mysql://192.168.1.6:3306/news");

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

        DSLContext context = DSL.using(dataSource, SQLDialect.MYSQL, settings);

        context.deleteFrom(WidgetAttributeTable.INSTANCE).execute();
        context.deleteFrom(WidgetTable.INSTANCE).execute();
        context.deleteFrom(PageTable.INSTANCE).execute();

        String uuid = createCenterWidget(context);

        PageRecord pageRecord = context.newRecord(PageTable.INSTANCE);
        pageRecord.setUuid("uuid_001");
        pageRecord.setWidgetUuid(uuid);
        pageRecord.setTitle("Google Pixel 5 release date, price, news and leaks");
        pageRecord.store();

//
//        INSERT INTO widget(uuid, type, page_uuid) values('uuid_001', 'Scaffold', 'uuid_001');
//        INSERT INTO widget(uuid, type, page_uuid) values('uuid_002', 'AppBar'  , 'uuid_001');
//        INSERT INTO widget(uuid, type, page_uuid) values('uuid_003', 'Column'  , 'uuid_001');
//        INSERT INTO widget(uuid, type, page_uuid) values('uuid_004', 'Text'    , 'uuid_001');
//        INSERT INTO widget(uuid, type, page_uuid) values('uuid_005', 'Text'    , 'uuid_001');
//
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_001', 'appBar'            , 'uuid_002');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_001', 'body'              , 'uuid_003');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisSize'      , 'max');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisSize'      , 'max');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisAlignment' , 'start');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'crossAxisAlignment', 'center');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'textDirection'     , null);
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'verticalDirection' , 'down');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'textBaseline'      , null);
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'children'          , 'uuid_004,uuid_005');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_004', 'text'              , 'abc');
//        INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_005', 'text'              , 'abc');
    }

    protected static String createCenterWidget(DSLContext context) {
        String uuid = UUID.randomUUID().toString();
        WidgetRecord widgetRecord = context.newRecord(WidgetTable.INSTANCE);
        widgetRecord.setType("Center");
        widgetRecord.setPageUuid(PAGE_UUID);
        widgetRecord.setUuid(uuid);
        widgetRecord.store();
        return uuid;
    }

}
