DROP TABLE IF EXISTS `widget`;

CREATE TABLE `widget` (
	sys_id                     BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version                BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified          TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                       VARCHAR(40)  NOT NULL,
	type                       VARCHAR(200) NOT NULL,
	page_uuid                  VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX widget_001 ON `widget`(sys_version);
CREATE INDEX widget_002 ON `widget`(sys_last_modified);
CREATE UNIQUE INDEX widget_003 ON `widget`(uuid);
CREATE INDEX widget_005 ON `widget`(type);
CREATE INDEX widget_006 ON `widget`(page_uuid);
