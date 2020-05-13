DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	name                   VARCHAR(200) NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX category_001 ON category(sys_version);
CREATE INDEX category_002 ON category(sys_last_modified);
CREATE UNIQUE INDEX category_003 ON category(uuid);
CREATE UNIQUE INDEX category_005 ON category(name);

INSERT INTO category(uuid, name) VALUES(UUID(), 'DocumentType'    );
INSERT INTO category(uuid, name) VALUES(UUID(), 'MaritalStatus'   );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Location'        );
INSERT INTO category(uuid, name) VALUES(UUID(), 'WorkingDayType'  );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Degree'          );
INSERT INTO category(uuid, name) VALUES(UUID(), 'EmploymentType'  );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Relationship'    );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Position'        );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Country'         );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Nationality'     );
INSERT INTO category(uuid, name) VALUES(UUID(), 'Salute'          );
