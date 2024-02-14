CREATE TABLE emergency(
   uuid   UUID  PRIMARY KEY 
  ,hospitalUuid   VARCHAR(90)  NOT NULL
  ,hospitalName   VARCHAR(90)  NOT NULL
  ,speciality   VARCHAR(57)  NOT NULL
  ,origin   VARCHAR(255)  NOT NULL
);

-- INSERT INTO emergency(uuid, hospitalUuid, hospitalName, speciality, origin) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'fdfdfdff', 'hopital Clermont', 'Anesthésie', '10 rue du baron dEste')
