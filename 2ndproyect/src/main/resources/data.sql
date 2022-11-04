INSERT into passengers (NAME, USERNAME, NATIONALITY, IDENTIFICATION, AGE) VALUES ('Cristian', 'Sandu', 'Romanian', 'AB12345', 20),('Mario', 'Rossi', 'Italian', 'CD5678', 25),('Enrique', 'Iglesias', 'Spanish', 'FR4444', 2), ('Victor', 'Irimeis', 'Greek', 'GT1234', 50), ('Marco', 'Piccoli', 'Italian', 'OP2456', 21), ('Peter', 'Pan', 'Polish', 'XD1234', 36);
INSERT into airlines(ID_AIRLINE, NAME)VALUES(1,'Iberica'),(2,'Ryanair'),(3,'American Airlines'),(4,'Qatar Airways'), (5, 'Flying Emirates'),(6, 'British Airways'),(7, 'easyJet');
INSERT into places(NAME)VALUES('Rome'),('Seville'),('Madrid'),('Venice'),('Paris'),('Lisbon'),('Dublin'),('London'),('Vienna'),('Athens'),('Prague');

INSERT into trips(AIRLINE_ID,ORIGIN,DEST,SCALE,LUGGAGE,DEPARTURE,ARRIVAL,ONEWAY,PRICE) VALUES('1','Rome','Madrid',false,false,'2022-11-18T16:00:49.455','2022-11-18T20:00:49.455',false,300),
('2','Venice','Seville',true,true,'2022-11-27T23:00:49.455','2022-11-28T05:00:49.455',false,450),('3','Lisbon','Vienna',true,false,'2022-11-15T16:00:49.455','2022-11-15T20:00:49.455',false,450),
('7','Dublin','London',true,true,'2022-11-04T22:00:49.455','2022-11-05T00:00:49.455',false,450),('1','Athens','Prague',true,false,'2022-11-07T04:00:49.455','2022-11-07T09:00:49.455',false,450),
('1','Rome','Prague',false,false,'2023-01-02T04:00:49.455','2023-12-05T09:00:49.455',false,450);

INSERT into tickets(ID_TICKET,ID_FLIGHT,ID_PASSENGER) VALUES(1,1,2),(2,1,1),(3,2,4),(4,2,5),(5,2,6),(6,5,1),(7,5,2),(8,5,6),(9,6,1),(10,4,2);