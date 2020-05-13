DROP TABLE IF EXISTS `group_role`;

CREATE TABLE `group_role` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	role_uuid              VARCHAR(40)  NOT NULL,
	group_uuid             VARCHAR(40)  NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX group_role_001 ON `group_role`(sys_version);
CREATE INDEX group_role_002 ON `group_role`(sys_last_modified);
CREATE UNIQUE INDEX group_role_003 ON `group_role`(uuid);
CREATE INDEX group_role_005 ON `group_role`(role_uuid);
CREATE INDEX group_role_006 ON `group_role`(group_uuid);

INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'SecurityTenant'       ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'GeneralDropdown'      ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Super'                ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Exit'                 ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Tenant'               ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Calendar'             ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Profile'              ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'IT Master Admin'), (SELECT uuid FROM role WHERE name = 'Leave'                ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'SecurityGroup'        ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'SecurityUser'         ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'SecurityRole'         ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'PolicyLeave'          ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'PolicyHoliday'        ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'PolicyShift'          ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'PolicyBenefit'        ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'GeneralOffice'        ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'GeneralDepartment'    ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'GeneralDropdown'      ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'GeneralGroup'         ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'Exit'                 ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'Employee'             ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'Profile'              ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'RecoverPassword'      ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'Calendar'             ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'HR Master Admin'), (SELECT uuid FROM role WHERE name = 'Leave'                ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'Employee'       ), (SELECT uuid FROM role WHERE name = 'Leave'                ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'Employee'       ), (SELECT uuid FROM role WHERE name = 'Calendar'             ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'Employee'       ), (SELECT uuid FROM role WHERE name = 'Profile'              ));
INSERT INTO group_role(uuid, group_uuid, role_uuid) VALUES(UUID(), (SELECT uuid FROM `group` WHERE name = 'Employee'       ), (SELECT uuid FROM role WHERE name = 'RecoverPassword'      ));
