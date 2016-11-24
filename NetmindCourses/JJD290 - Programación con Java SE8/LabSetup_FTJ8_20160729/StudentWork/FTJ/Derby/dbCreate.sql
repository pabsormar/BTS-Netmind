DROP TABLE Item;


CREATE TABLE Item
(
   ITEM_ID     BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   Title       VARCHAR(40),
   Artist      VARCHAR(40),
   Price       DECIMAL(5,2),
   CONSTRAINT  PK_Item  PRIMARY KEY(ITEM_ID)
);


INSERT INTO Item VALUES (DEFAULT, 'Diva', 'Annie Lennox', 13.99);
INSERT INTO Item VALUES (DEFAULT, 'Dream of the Blue Turtles', 'Sting', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'Trouble is...', 'Kenny Wayne Shepherd Band', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'Lie to Me', 'Jonny Lang', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'Little Earthquakes', 'Tori Amos', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'Seal', 'Seal', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'Ian Moore', 'Ian Moore', 9.97);
INSERT INTO Item VALUES (DEFAULT, 'So Much for the Afterglow', 'Everclear', 13.99);
INSERT INTO Item VALUES (DEFAULT, 'Surfacing', 'Sarah McLachlan', 13.99);
INSERT INTO Item VALUES (DEFAULT, 'Hysteria', 'Def Leppard', 14.99);
INSERT INTO Item VALUES (DEFAULT, 'A Life of Saturdays', 'Dexter Freebish', 12.99);
INSERT INTO Item VALUES (DEFAULT, 'Human Clay', 'Creed', 13.28);
INSERT INTO Item VALUES (DEFAULT, 'My, I''m Large', 'Bobs', 11.97);
INSERT INTO Item VALUES (DEFAULT, 'So', 'Peter Gabriel', 13.99);
INSERT INTO Item VALUES (DEFAULT, 'Big Ones', 'Aerosmith', 14.99);
INSERT INTO Item VALUES (DEFAULT, '90125', 'Yes', 11.97);
INSERT INTO Item VALUES (DEFAULT, '1984', 'Van Halen', 11.97);
INSERT INTO Item VALUES (DEFAULT, 'Escape', 'Journey', 11.97);
INSERT INTO Item VALUES (DEFAULT, 'Greatest Hits', 'Jay and the Americans', 9.97);
INSERT INTO Item VALUES (DEFAULT, 'Ray of Light', 'Madonna', 10.97);
INSERT INTO Item VALUES (DEFAULT, 'Music', 'Madonna', 11.97);




COMMIT;
