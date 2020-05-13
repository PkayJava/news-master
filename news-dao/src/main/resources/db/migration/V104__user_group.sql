DROP TABLE IF EXISTS `user_group`;

CREATE TABLE `user_group` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	user_uuid              VARCHAR(40)  NOT NULL,
	group_uuid             VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX user_group_001 ON `user_group`(sys_version);
CREATE INDEX user_group_002 ON `user_group`(sys_last_modified);
CREATE UNIQUE INDEX user_group_003 ON `user_group`(uuid);
CREATE INDEX user_group_005 ON `user_group`(user_uuid);
CREATE INDEX user_group_006 ON `user_group`(group_uuid);
