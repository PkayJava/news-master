INSERT INTO page(uuid, widget_uuid, title) values('uuid_001', 'uuid_001', 'Google Pixel 5 release date, price, news and leaks');

INSERT INTO widget(uuid, type, page_uuid) values('uuid_001', 'Scaffold', 'uuid_001');
INSERT INTO widget(uuid, type, page_uuid) values('uuid_002', 'AppBar'  , 'uuid_001');
INSERT INTO widget(uuid, type, page_uuid) values('uuid_003', 'Column'  , 'uuid_001');
INSERT INTO widget(uuid, type, page_uuid) values('uuid_004', 'Text'    , 'uuid_001');
INSERT INTO widget(uuid, type, page_uuid) values('uuid_005', 'Text'    , 'uuid_001');

INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_001', 'appBar'            , 'uuid_002');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_001', 'body'              , 'uuid_003');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisSize'      , 'max');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisSize'      , 'max');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'mainAxisAlignment' , 'start');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'crossAxisAlignment', 'center');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'textDirection'     , null);
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'verticalDirection' , 'down');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'textBaseline'      , null);
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_003', 'children'          , 'uuid_004,uuid_005');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_004', 'text'              , 'abc');
INSERT INTO widget_attribute(uuid, page_uuid, widget_uuid, attr_name, attr_value) values(UUID(), 'uuid_001', 'uuid_005', 'text'              , 'abc');
