DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	role_uuid              VARCHAR(40)  NOT NULL,
	user_uuid              VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX user_role_001 ON `user_role`(sys_version);
CREATE INDEX user_role_002 ON `user_role`(sys_last_modified);
CREATE UNIQUE INDEX user_role_003 ON `user_role`(uuid);
CREATE INDEX user_role_005 ON `user_role`(role_uuid);
CREATE INDEX user_role_006 ON `user_role`(user_uuid);
