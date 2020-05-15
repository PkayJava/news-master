DROP TABLE IF EXISTS `page`;

CREATE TABLE `page` (
	sys_id                     BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version                BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified          TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                       VARCHAR(40)  NOT NULL,
	title                      VARCHAR(768) NOT NULL, -- 768
	object_uuid                VARCHAR(40)  NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX page_001 ON `page`(sys_version);
CREATE INDEX page_002 ON `page`(sys_last_modified);
CREATE UNIQUE INDEX page_003 ON `page`(uuid);
CREATE INDEX page_005 ON `page`(title);
CREATE INDEX page_006 ON `page`(object_uuid);
