SET SCHEMA FN45465;

CREATE VIEW V_MAXSEATCAPACITY
AS SELECT MAX(SEATCAPACITY) AS MAX_CAPACITY, VEHICLE_TYPE.NAME AS VEHICHLE_TYPE
FROM LINE, VEHICLE, VEHICLE_TYPE
WHERE VEHICLETYPEID = VEHICLE_TYPE.ID
GROUP BY VEHICLE_TYPE.NAME;

SELECT * FROM V_MAXSEATCAPACITY;

CREATE VIEW V_VALID_PASSENGERS
AS SELECT FIRSTNAME, LASTNAME, LINE.NUMBER
FROM PASSENGER, LINE, CARD_LINE, CARD_STATUS
WHERE PASSENGEREGN = PASSENGER.EGN AND LINEID = LINE.ID AND CARDSTATUSID = CARD_STATUS.ID AND CARD_STATUS.STATUS = 'valid';

SELECT * FROM V_VALID_PASSENGERS;
