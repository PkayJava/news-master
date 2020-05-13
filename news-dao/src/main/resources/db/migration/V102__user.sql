DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	login                  VARCHAR(200) NOT NULL,
	password               VARCHAR(200) NOT NULL,
	password_status        ENUM('Expired','Valid') NOT NULL,
	status                 ENUM('Enabled','Disabled','Locked') NOT NULL,
	retry_count            INT(10)      NOT NULL,
	email_address          VARCHAR(200) NOT NULL,
	last_seen              DATETIME     NOT NULL,
	group_uuid             VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX user_001 ON `user`(sys_version);
CREATE INDEX user_002 ON `user`(sys_last_modified);
CREATE UNIQUE INDEX user_003 ON `user`(uuid);
CREATE INDEX user_005 ON `user`(login);
CREATE INDEX user_006 ON `user`(password);
CREATE INDEX user_007 ON `user`(status);
CREATE INDEX user_008 ON `user`(retry_count);
CREATE INDEX user_009 ON `user`(email_address);
CREATE INDEX user_010 ON `user`(last_seen);
CREATE INDEX user_011 ON `user`(password_status);
CREATE INDEX user_012 ON `user`(group_uuid);

INSERT INTO `user`(uuid, login, password, password_status, status, retry_count, email_address, last_seen, group_uuid) VALUES(UUID(), 'hr.master.admin', '8NOiejpyzij3fOMgzdaW+Hm3UIO6MSYcRIR26f07C2ePlzuUy99twW+hLcG9bQ+H', 'Valid', 'Enabled', 0, 'demo_manager_01@i365work.com', now(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'));
INSERT INTO `user`(uuid, login, password, password_status, status, retry_count, email_address, last_seen, group_uuid) VALUES(UUID(), 'it.master.admin', '8NOiejpyzij3fOMgzdaW+Hm3UIO6MSYcRIR26f07C2ePlzuUy99twW+hLcG9bQ+H', 'Valid', 'Enabled', 0, 'demo_manager_02@i365work.com', now(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'));
