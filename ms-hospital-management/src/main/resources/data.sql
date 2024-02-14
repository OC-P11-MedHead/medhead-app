CREATE TABLE hospitals(
   organisationId   INTEGER  NOT NULL PRIMARY KEY 
  ,organisationCode VARCHAR(5) NOT NULL
  ,organisationName VARCHAR(90) NOT NULL
  ,address1         VARCHAR(57)
  ,address2         VARCHAR(41)
  ,address3         VARCHAR(24)
  ,city             VARCHAR(26)
  ,county           VARCHAR(22)
  ,postCode         VARCHAR(8) NOT NULL
  ,latitude         VARCHAR(18)
  ,longitude        VARCHAR(22)
  ,phone            VARCHAR(29)
  ,email            VARCHAR(53)
  ,website          VARCHAR(106)
  ,fax              VARCHAR(13)
  ,emergencyBedrooms  INTEGER
);

CREATE TABLE speciality(
   uuid  VARCHAR(255) NOT NULL PRIMARY KEY
  ,libelle VARCHAR(255) NOT NULL
);

CREATE TABLE hospitals_speciality(
   organisationId INTEGER
  ,uuid VARCHAR(255)
  ,PRIMARY KEY (organisationId, uuid)
  ,FOREIGN KEY (organisationId) REFERENCES hospitals(organisationId)
  ,FOREIGN KEY (uuid) REFERENCES speciality(uuid)
);

INSERT INTO speciality(uuid, libelle) VALUES ('4545jhvrezr', 'Cardiologie');
INSERT INTO speciality(uuid, libelle) VALUES ('4545rez4jir', 'Anesthésie');
INSERT INTO speciality(uuid, libelle) VALUES ('4555rez4jir', 'Soins intensifs');
INSERT INTO speciality(uuid, libelle) VALUES ('4415rez4jir', 'Oncologie clinique');
INSERT INTO speciality(uuid, libelle) VALUES ('123256z4jir', 'Spécialités dentaires supplémentaires');
INSERT INTO speciality(uuid, libelle) VALUES ('4532dez4jir', 'Radiologie dentaire et maxillo-faciale');
INSERT INTO speciality(uuid, libelle) VALUES ('qsd5rez4jir', 'Endodontie');
INSERT INTO speciality(uuid, libelle) VALUES ('454cxsz4jir', 'Chirurgie buccale et maxillo-faciale');
INSERT INTO speciality(uuid, libelle) VALUES ('ds45re14jir', 'Pathologie buccale et maxillo-faciale');
INSERT INTO speciality(uuid, libelle) VALUES ('4545rez1111', 'Médecine buccale');
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (17981,'NDA18','Woking Community Hospital (Virgin Care)',NULL,'Heathside Road',NULL,'Woking','Surrey','GU22 7HS','51.315132141113281','-0.55628949403762817','01483 715911',NULL,NULL,NULL,15);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18101,'NLT01','North Somerset Community Partnership Cic HQ','Castlewood','Tickenham Road',NULL,'Clevedon','Avon','BS21 6AB','51.439693450927734','-2.8400685787200928',NULL,NULL,NULL,NULL,8);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18102,'NLT02','North Somerset Community Hospital','North Somerset Community Hospital','Old Street',NULL,'Clevedon','Avon','BS21 6BS','51.43719482421875','-2.8471927642822266','01275 872212',NULL,'https://www.sirona-cic.org.uk/nhsservices/services/clevedon-minor-injury-unit/',NULL,9);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18138,'NMP01','Bridgewater Hospital','120 Princess Road',NULL,NULL,'Manchester','Greater Manchester','M15 5AT','53.459743499755859','-2.2454688549041748','0161 2270000',NULL,'www.bridgewaterhospital.com',NULL,10);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18142,'NMV01','Kneesworth House','Old North Road','Bassingbourn',NULL,'Royston',NULL,'SG8 5JP','52.078121185302734','-3.0604055151343346','1763255700','reception_kneesworthhouse@partnershipsincare.co.uk','www.partnershipsincare.co.uk',NULL,11);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18143,'NMV02','Stockton Hall Hospital','Stockton Hall','The Village','Stockton On The Forest','York','North Yorkshire','YO32 9UN','53.995403289794922','-1.0025526285171509','1904400500','info@priorygroup.com','https://www.priorygroup.com/stockton-hall',NULL,12);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18289,'NQ901','Lakeside Hospital','The Lane','Wyboston',NULL,'Bedford','Bedfordshire','MK44 3AS','52.198673248291016','-0.31124794483184814',NULL,NULL,NULL,NULL,13);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18305,'NQM01','Orthopaedics and Spine Specialist Hospital','1 Stirling Way','Bretton',NULL,'Peterborough','Cambridgeshire','PE3 8YA','52.604942321777344','-0.28302180767059326','01733 333156','info@orthospine.co.uk',NULL,'01733 373050',23);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (17970,'NDA07','Walton Community Hospital - Virgin Care Services Ltd',NULL,'Rodney Road',NULL,'Walton-on-Thames','Surrey','KT12 3LD','51.379997253417969','-0.40604206919670105','01932 414205',NULL,NULL,'01932 253674', 45);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18314,'NR510','Lee Mill Hospital',NULL,'Beech Road','Ivybridge','Plymouth','Devon','PL21 9HL','50.390365600585937','-3.9617364406585693','01752 314800',NULL,NULL,'01752 314804',25);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18317,'NR527','Mount Gould Hospital',NULL,'Mount Gould Road',NULL,'Plymouth',NULL,'PL4 7QD','50.378402709960938','-4.1127405166625977','01752 435502',NULL,'https://www.livewellsouthwest.co.uk/',NULL,14);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18352,'NT204','Nuffield Health, Brentwood Hospital',NULL,'Shenfield Road',NULL,'Brentwood','Essex','CM15 8EH','51.623332977294922','0.31283530592918396','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/brentwoodhospital',NULL,23);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18353,'NT205','Nuffield Health, Brighton Hospital',NULL,'Warren Road','Woodingdean','Brighton',NULL,'BN2 6DX','50.834518432617188','-8.1910513341426849','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/brightonhospital',NULL,5);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18354,'NT206','Nuffield Health, Bristol Hospital (Chesterfield)','3 Clifton Hill','Clifton',NULL,'Bristol','Avon','BS8 1BN','51.453609466552734','-2.6159844398498535','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/hospitals/bristol',NULL,0);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18356,'NT209','Nuffield Health, Cambridge Hospital','Nuffield Health Cambridge Hospital','4 Trumpington Road',NULL,'Cambridge','Cambridgeshire','CB2 8AF','52.190353393554688','0.12355859577655792','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/cambridgehospital',NULL,0);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18357,'NT210','Nuffield Health, The Grosvenor Hospital, Chester','Nuffield Health Chester Hospital, The Grosvenor','Wrexham Road',NULL,'Chester','Cheshire','CH4 7QP','53.176345825195313','-2.8952467441558838','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/thegrosvenorhospitalchester',NULL,0);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18358,'NT211','Nuffield Health, Cheltenham Hospital',NULL,'Hatherley Lane',NULL,'Cheltenham','Gloucestershire','GL51 6SY','51.891929626464844','-2.1299054622650146','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/cheltenhamhospital',NULL,5);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18360,'NT213','Nuffield Health, Derby Hospital',NULL,'Rykneld Road','Littleover','Derby','Derbyshire','DE23 4SN','52.893550872802734','-1.5301551818847656','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/derbyhospital',NULL,8);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18362,'NT215','Nuffield Health, Exeter Hospital','Nuffield Health Exeter Hospital','Wonford Road',NULL,'Exeter','Devon','EX2 4UG','50.716316223144531','-3.5112717151641846','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/exeterhospital',NULL,10);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18363,'NT216','Nuffield Health, Guildford Hospital',NULL,'Stirling Road',NULL,'Guildford','Surrey','GU2 7RF','51.241653442382813','-0.61254358291625977','01483 555800',NULL,'http://www.nuffieldhealth.com/hospitals/guildford',NULL,12);
INSERT INTO hospitals(organisationId,organisationCode,organisationName,address1,address2,address3,city,county,postCode,latitude,longitude,phone,email,website,fax,emergencyBedrooms) VALUES (18365,'NT218','Nuffield Health, Haywards Heath Hospital',NULL,'Burrell Road',NULL,'Haywards Heath',NULL,'RH16 1UD','51.00836181640625','-0.10619448125362396','0800 015 5020','nuffieldhealth.ereferrals@nhs.net','http://www.nuffieldhealth.com/haywards-heathhospital',NULL,13);
INSERT INTO hospitals_speciality (organisationId, uuid) VALUES (17970,'4545jhvrezr');
INSERT INTO hospitals_speciality (organisationId, uuid) VALUES (18101,'4545jhvrezr');
INSERT INTO hospitals_speciality (organisationId, uuid) VALUES (17970,'4545rez4jir');
INSERT INTO hospitals_speciality (organisationId, uuid) VALUES (17981,'4545rez4jir');
INSERT INTO hospitals_speciality (organisationId, uuid) VALUES (18101,'4545rez4jir');
