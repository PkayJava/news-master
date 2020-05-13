DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	name                   VARCHAR(200) NOT NULL,
	disabled               TINYINT(1)   NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX group_001 ON `group`(sys_version);
CREATE INDEX group_002 ON `group`(sys_last_modified);
CREATE UNIQUE INDEX group_003 ON `group`(uuid);
CREATE INDEX group_005 ON `group`(name);
CREATE INDEX group_006 ON `group`(disabled);

INSERT INTO `group`(uuid, name, disabled) VALUES(UUID(), 'HR Master Admin', false);
INSERT INTO `group`(uuid, name, disabled) VALUES(UUID(), 'IT Master Admin', false);
INSERT INTO `group`(uuid, name, disabled) VALUES(UUID(), 'Employee'       , false);
