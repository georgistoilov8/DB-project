CREATE OR REPLACE TRIGGER PN_format
BEFORE INSERT OR UPDATE
ON Vehicle
FOR EACH ROW
DECLARE 
pnexcp EXCEPTION;
BEGIN 
IF NOT REGEXP_LIKE (:NEW.numberPlate,'^[A-Z]{2}[0-9]{4}[A-Z]{2}$') THEN   
RAISE pnexcp;
END IF;

EXCEPTION
WHEN pnexcp THEN
RAISE_APPLICATION_ERROR(-203, 'Plate number not valid.');
END;



CREATE OR REPLACE TRIGGER EGN_format
BEFORE INSERT OR UPDATE
ON Vehicle
FOR EACH ROW
DECLARE 
pnexcp EXCEPTION;
BEGIN 
IF NOT REGEXP_LIKE (:NEW.numberPlate,'^[0-9]{10}$') THEN   
RAISE pnexcp;
END IF;

EXCEPTION
WHEN pnexcp THEN
RAISE_APPLICATION_ERROR(-203, 'EGN not valid.');
END;