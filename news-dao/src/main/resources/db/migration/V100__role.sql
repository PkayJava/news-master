DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	name                   VARCHAR(200) NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX role_001 ON `role`(sys_version);
CREATE INDEX role_002 ON `role`(sys_last_modified);
CREATE UNIQUE INDEX role_003 ON `role`(uuid);
CREATE UNIQUE INDEX role_005 ON `role`(name);

INSERT INTO role(uuid, name) VALUES(UUID(), 'SecurityTenant'          );
INSERT INTO role(uuid, name) VALUES(UUID(), 'SecurityGroup'           );
INSERT INTO role(uuid, name) VALUES(UUID(), 'SecurityUser'            );
INSERT INTO role(uuid, name) VALUES(UUID(), 'SecurityRole'            );
INSERT INTO role(uuid, name) VALUES(UUID(), 'GeneralOffice'           );
INSERT INTO role(uuid, name) VALUES(UUID(), 'GeneralDepartment'       );
INSERT INTO role(uuid, name) VALUES(UUID(), 'GeneralDropdown'         );
INSERT INTO role(uuid, name) VALUES(UUID(), 'GeneralGroup'            );
INSERT INTO role(uuid, name) VALUES(UUID(), 'PolicyLeave'             );
INSERT INTO role(uuid, name) VALUES(UUID(), 'PolicyHoliday'           );
INSERT INTO role(uuid, name) VALUES(UUID(), 'PolicyShift'             );
INSERT INTO role(uuid, name) VALUES(UUID(), 'PolicyBenefit'           );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Super'                   );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Exit'                    );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Employee'                );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Profile'                 );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Tenant'                  );
INSERT INTO role(uuid, name) VALUES(UUID(), 'RecoverPassword'         );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Calendar'                );
INSERT INTO role(uuid, name) VALUES(UUID(), 'Leave'                   );
