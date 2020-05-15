package com.angkorteam.news.generator;

import com.angkorteam.news.dao.tables.ObjectAttributeTable;
import com.angkorteam.news.dao.tables.ObjectTable;
import com.angkorteam.news.dao.tables.PageTable;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Icons;
import com.angkorteam.news.flutter.common.MainAxisAlignment;
import com.angkorteam.news.flutter.widget.*;
import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;

public class Program {

    public static final String PAGE_UUID = "uuid_001";

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

        context.deleteFrom(ObjectAttributeTable.INSTANCE).execute();
        context.deleteFrom(ObjectTable.INSTANCE).execute();
        context.deleteFrom(PageTable.INSTANCE).execute();

        Page page = new Page("uuid_001");
        page.setTitle("Google Pixel 5 release date, price, news and leaks");
        page.setWidget(
                new Scaffold(
                        Scaffold.appBar(
                                new AppBar(
                                        AppBar.title(
                                                new Text("News")
                                        )
                                )
                        ),
                        Scaffold.body(
                                new Center(
                                        Center.child(
                                                new Column(
                                                        Column.mainAxisAlignment(MainAxisAlignment.center),
                                                        Column.children(
                                                                new Text("You have pushed the button this many times:"),
                                                                new Text("$_counter")
                                                        )
                                                )
                                        )
                                )
                        ),
                        Scaffold.floatingActionButton(
                                new FloatingActionButton(
                                        FloatingActionButton.onPressed("test"),
                                        FloatingActionButton.tooltip("Increment"),
                                        FloatingActionButton.child(
                                                new Icon(Icons.add)
                                        )
                                )
                        )
                )
        );
        page.store(context);
    }

}