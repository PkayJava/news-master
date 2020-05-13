DROP TABLE IF EXISTS `choice`;

CREATE TABLE `choice` (
	sys_id                 BIGINT(19)   NOT NULL AUTO_INCREMENT,
	sys_version            BIGINT(19)   NOT NULL DEFAULT 1,
	sys_last_modified      TIMESTAMP    NOT NULL DEFAULT NOW(),
	uuid                   VARCHAR(40)  NOT NULL,
	category_uuid          VARCHAR(40)  NOT NULL,
	name                   VARCHAR(200) NOT NULL,
	disabled               TINYINT(1)   NOT NULL,
	PRIMARY KEY (sys_id)
);

CREATE INDEX choice_001 ON choice(sys_version);
CREATE INDEX choice_002 ON choice(sys_last_modified);
CREATE UNIQUE INDEX choice_003 ON choice(uuid);
CREATE UNIQUE INDEX choice_005 ON choice(category_uuid, name);
CREATE INDEX choice_006 ON choice(disabled);

INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'DocumentType'   ), 'Driver License'                  ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'DocumentType'   ), 'National ID'                     ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'DocumentType'   ), 'Certificate'                     ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'DocumentType'   ), 'Family Book'                     ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'DocumentType'   ), 'Other'                           ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'MaritalStatus'  ), 'Single'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'MaritalStatus'  ), 'Married'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Location'       ), 'Phnom Penh'                      ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Location'       ), 'Bangkok'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Location'       ), 'New York'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'WorkingDayType' ), 'Full Day'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'WorkingDayType' ), 'Morning'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'WorkingDayType' ), 'Afternoon'                       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'WorkingDayType' ), 'No Work'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Diploma'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Professional'                    ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Bachelor'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Master'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Ph.D'                            ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Degree'         ), 'Doctor'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'EmploymentType' ), 'Contractor'                      ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'EmploymentType' ), 'Permanent'                       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'EmploymentType' ), 'Internship'                      ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Husband'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Wife'                            ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Child'                           ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Father'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Mother'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Brother'                         ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Relationship'   ), 'Sister'                          ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Solution Architect'              ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Lead Analyst'                    ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Agile Coach'                     ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Java Full Stack Developer'       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'DevOps Engineer'                 ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Lead DevOps Engineer'            ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Position'       ), 'Technical Lead Cloud'            ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Country'        ), 'Cambodia'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Country'        ), 'Japan'                           ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Country'        ), 'Malaysia'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Country'        ), 'Singapore'                       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Nationality'    ), 'Cambodian'                       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Nationality'    ), 'Japanese'                        ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Nationality'    ), 'Malaysian'                       ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Nationality'    ), 'Singaporean'                     ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Salute'         ), 'Mr.'                             ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Salute'         ), 'Mrs.'                            ,false  );
INSERT INTO choice(uuid, category_uuid, name, disabled) VALUES(UUID(), (SELECT uuid FROM category WHERE name = 'Salute'         ), 'Miss.'                           ,false  );
