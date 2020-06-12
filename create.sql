SET SCHEMA FN45465;

/*
Workers(firstName, lastName, egn, phone, email, salary, workerTypeID)
Passengers(firstName, lastName, egn)
Workers_Passengers(firstName, lastName, egn, phone, email, salary, workerTypeID)
Vehicle(brand, model, numberPlate, seatCapacity, standingCapacity, airConditioner, wheelchairRamp, vehicleTypeID, lineID)
Vehicle_Type(id, name)
Line(id, number, stopsCount, Distance)
Stop(id, address, longitude, latitude, chargeCard)
Work_Type(id, name)
Card_Status(id, status)
Schedule_Type(id, season, weekday/holiday)
Arrival_Type(id, time)
Schedule(id, lineID, stopID, scheduleTypeID, Date)
Card_Line(lineID, passengerEGN, price, startDate, endDate, cardStatusID)
Card_Travel(lineID, passengerEGN, price, number, cardStatusID)
Works(lineID, workerEGN)
Consist_Of(lineID, stopID)
Provides(arrivalTimeID, scheduleID)
*/

DROP TABLE Worker;
DROP TABLE Passenger;
DROP TABLE Vehicle;
DROP TABLE Vehicle_Type;
DROP TABLE Line;
DROP TABLE Stop;
DROP TABLE Work_Type;
DROP TABLE Card_Status;
DROP TABLE Schedule_Type;
DROP TABLE Arrival_Type;
DROP TABLE Schedule;
DROP TABLE Card_Line;
DROP TABLE Card_Travel;
DROP TABLE Works;
DROP TABLE Consist_Of;
DROP TABLE Provides;

--Workers(firstName, lastName, egn, phone, email, salary, workerTypeID)
CREATE TABLE Worker(
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    egn CHAR(10) NOT NULL CHECK ( LENGTH(RTRIM(TRANSLATE(egn, '*', ' 0123456789'))) = 0 ),
    phone CHAR(10) NOT NULL,
    email VARCHAR(64),
    salary INT CHECK ( salary > 0 ),
    workerTypeID INT NOT NULL,   -- FK to Work_Type
    PRIMARY KEY (egn)
);

-- Passengers(firstName, lastName, egn)
CREATE TABLE Passenger(
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    egn CHAR(10) NOT NULL CHECK ( LENGTH(RTRIM(TRANSLATE(egn, '*', ' 0123456789'))) = 0 ),
    PRIMARY KEY (egn)
);

--Workers_Passengers(firstName, lastName, egn, phone, email, salary, workerTypeID)
-- Няма да го правим. Тъпо е...

-- Vehicle(brand, model, numberPlate, seatCapacity, standingCapacity, airConditioner, wheelchairRamp, vehicleTypeID, lineID)
CREATE TABLE Vehicle(
    brand VARCHAR(32),
    model VARCHAR(32),
    numberPlate CHAR(8) NOT NULL,
    seatCapacity INT NOT NULL CHECK ( seatCapacity > 0 ),
    standingCapacity INT CHECK ( standingCapacity > 0 ),
    airConditioner INT CHECK ( airConditioner IN (0, 1) ),          -- 0 - false, 1 - true
    wheelchairRamp INT NOT NULL CHECK ( wheelchairRamp IN (0, 1) ), -- 0 - false, 1 - true
    vehicleTypeID INT NOT NULL,  -- FK to Vehicle_Type
    lineID INT NOT NULL,         -- FK to Line
    PRIMARY KEY (numberPlate)
);

--Vehicle_Type(id, name)
CREATE TABLE Vehicle_Type(
    name VARCHAR(32) NOT NULL CHECK ( NAME IN ('tram', 'metro', 'train', 'bus', 'trolleybus') ),
    ID INT NOT NULL CHECK ( ID > 0 ),
    PRIMARY KEY (ID)
);

--Line(id, number, stopsCount, distance)
CREATE TABLE Line(
    ID INT NOT NULL CHECK ( ID > 0 ),
    number INT NOT NULL CHECK ( number > 0 ),
    stopsCount INT NOT NULL CHECK ( stopsCount > 0 ),
    distance REAL CHECK ( distance > 0 ),
    PRIMARY KEY (ID)
);

--Stop(id, address, longitude, latitude, chargeCard)
CREATE TABLE Stop(
    ID INT NOT NULL CHECK ( ID > 0 ),
    address VARCHAR(128) NOT NULL,
    longitude REAL,
    latitude REAL,
    chargeCard INT CHECK ( chargeCard IN (0, 1) ),  -- 0 - false, 1 - true
    PRIMARY KEY (ID)
);

--Work_Type(id, name)
CREATE TABLE Work_Type(
    ID INT NOT NULL CHECK ( ID > 0 ),
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (ID)
);

--Card_Status(id, status)
CREATE TABLE Card_Status(
    ID INT NOT NULL CHECK ( ID > 0 ),
    status VARCHAR(32) NOT NULL CHECK ( status IN ('valid', 'blocked', 'invalid') ),
    PRIMARY KEY (ID)
);

--Schedule_Type(id, season, weekday/holiday)
CREATE TABLE Schedule_Type(
    ID INT NOT NULL CHECK ( ID > 0 ),
    season VARCHAR(32) NOT NULL CHECK ( season IN ('summer', 'winter') ),
    dayType VARCHAR(32) NOT NULL CHECK ( dayType IN ('weekday', 'holiday') ),
    PRIMARY KEY (ID)
);

--Arrival_Type(id, time)
CREATE TABLE Arrival_Type(
    ID INT NOT NULL CHECK ( ID > 0 ),
    time TIME NOT NULL,
    PRIMARY KEY (ID)
);

--Schedule(id, lineID, stopID, scheduleTypeID, Date)
CREATE TABLE Schedule(
    ID INT NOT NULL CHECK ( ID > 0 ),
    lineID INT NOT NULL,                      -- FK to Line
    stopID INT NOT NULL,                      -- FK to Stop
    scheduleTypeID INT NOT NULL,              -- FK to Schedule_Type
    currentDate DATE NOT NULL,
    PRIMARY KEY (ID)
);

--Card_Line(lineID, passengerEGN, price, startDate, endDate, cardStatusID)
-- Проверка дали startDate < endDate
CREATE TABLE Card_Line(
    lineID INT NOT NULL CHECK ( lineID > 0 ),
    passengerEGN CHAR(10) NOT NULL CHECK ( LENGTH(RTRIM(TRANSLATE(passengerEGN, '*', ' 0123456789'))) = 0 ),
    price INT NOT NULL CHECK ( price > 0 ),
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    cardStatusID INT,                                   -- FK to Card_Status
    PRIMARY KEY (lineID, passengerEGN)
);

--Card_Travel(lineID, passengerEGN, price, number, cardStatusID)
CREATE TABLE Card_Travel(
    lineID INT NOT NULL CHECK ( lineID > 0 ),
    passengerEGN CHAR(10) NOT NULL CHECK ( LENGTH(RTRIM(TRANSLATE(passengerEGN, '*', ' 0123456789'))) = 0 ),
    price INT NOT NULL CHECK ( price > 0 ),
    number INT NOT NULL,
    cardStatusID INT,                                   -- FK to Card_Status
    PRIMARY KEY (lineID, passengerEGN)
);

--Works(lineID, workerEGN)
CREATE TABLE Works(
    lineID INT NOT NULL CHECK ( lineID > 0 ),
    workerEGN CHAR(10) NOT NULL CHECK ( LENGTH(RTRIM(TRANSLATE(workerEGN, '*', ' 0123456789'))) = 0 ),
    PRIMARY KEY (lineID, workerEGN)
);

--Consist_Of(lineID, stopID)
CREATE TABLE Consist_Of(
    lineID INT NOT NULL CHECK ( lineID > 0 ),
    stopID INT NOT NULL CHECK ( stopID > 0 ),
    PRIMARY KEY (lineID, stopID)
);

--Provides(arrivalTimeID, scheduleID)
CREATE TABLE Provides
(
    arrivalTimeID INT NOT NULL CHECK ( arrivalTimeID > 0 ),
    scheduleID    INT NOT NULL CHECK ( scheduleID > 0 ),
    PRIMARY KEY (arrivalTimeID, scheduleID)
);


-- Add all foreign keys
ALTER TABLE Worker
ADD FOREIGN KEY (workerTypeID) REFERENCES WORK_TYPE(ID);

ALTER TABLE Vehicle
ADD FOREIGN KEY (vehicleTypeID) REFERENCES Vehicle_Type(ID);

ALTER TABLE Vehicle
ADD FOREIGN KEY (lineID) REFERENCES Line(ID);

ALTER TABLE Schedule
ADD FOREIGN KEY (lineID) REFERENCES Line(ID);

ALTER TABLE Schedule
ADD FOREIGN KEY (stopID) REFERENCES Stop(ID);

ALTER TABLE Schedule
ADD FOREIGN KEY (scheduleTypeID) REFERENCES Schedule_Type(ID);

ALTER TABLE Card_Line
ADD FOREIGN KEY (cardStatusID) REFERENCES Card_Status(ID);

ALTER TABLE Card_Travel
ADD FOREIGN KEY (cardStatusID) REFERENCES Card_Status(ID);
                                               
ALTER TABLE Works
ADD FOREIGN KEY (lineID) REFERENCES Line(ID)
ADD FOREIGN KEY (workerEGN) REFERENCES Worker(EGN);

ALTER TABLE Consist_Of
ADD FOREIGN KEY (lineID) REFERENCES Line(ID)
ADD FOREIGN KEY (stopID) REFERENCES Stop(ID);

ALTER TABLE Provides
ADD FOREIGN KEY (arrivalTimeID) REFERENCES Arrival_Type(ID)
ADD FOREIGN KEY (scheduleID) REFERENCES Schedule(ID);
