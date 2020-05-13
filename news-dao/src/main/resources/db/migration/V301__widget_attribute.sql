DROP TABLE IF EXISTS `widget_attribute`;

CREATE TABLE `widget_attribute` (
	sys_id                     BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version                BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified          TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                       VARCHAR(40)  NOT NULL,
	page_uuid                  VARCHAR(40)  NOT NULL,
	widget_uuid                VARCHAR(40)  NOT NULL,
	attr_name                  VARCHAR(200) NOT NULL,
	attr_value                 VARCHAR(768) NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX widget_attribute_001 ON `widget_attribute`(sys_version);
CREATE INDEX widget_attribute_002 ON `widget_attribute`(sys_last_modified);
CREATE UNIQUE INDEX widget_attribute_003 ON `widget_attribute`(uuid);
CREATE INDEX widget_attribute_005 ON `widget_attribute`(page_uuid);
CREATE INDEX widget_attribute_006 ON `widget_attribute`(widget_uuid);
