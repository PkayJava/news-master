DROP TABLE IF EXISTS `object_attribute`;

CREATE TABLE `object_attribute` (
	sys_id                     BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version                BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified          TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                       VARCHAR(40)  NOT NULL,
	page_uuid                  VARCHAR(40)  NOT NULL,
	object_uuid                VARCHAR(40)  NOT NULL,
	attr_name                  VARCHAR(200) NOT NULL,
	attr_value                 VARCHAR(768) NULL,
	attr_type                  VARCHAR(6)   NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX object_attribute_001 ON `object_attribute`(sys_version);
CREATE INDEX object_attribute_002 ON `object_attribute`(sys_last_modified);
CREATE UNIQUE INDEX object_attribute_003 ON `object_attribute`(uuid);
CREATE INDEX object_attribute_005 ON `object_attribute`(page_uuid);
CREATE INDEX object_attribute_006 ON `object_attribute`(object_uuid);
CREATE INDEX object_attribute_007 ON `object_attribute`(attr_type);
