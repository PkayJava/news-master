DROP TABLE IF EXISTS `object`;

CREATE TABLE `object` (
	sys_id                     BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version                BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified          TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                       VARCHAR(40)  NOT NULL,
	type                       VARCHAR(200) NOT NULL,
	page_uuid                  VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX object_001 ON `object`(sys_version);
CREATE INDEX object_002 ON `object`(sys_last_modified);
CREATE UNIQUE INDEX object_003 ON `object`(uuid);
CREATE INDEX object_005 ON `object`(type);
CREATE INDEX object_006 ON `object`(page_uuid);
