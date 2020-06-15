CREATE FUNCTION Getstops (V_numberPlate CHAR(8))
RETURNS TABLE(
    stopID INT
)
RETURN SELECT stopID FROM CONSIST_OF WHERE lineID IN (SELECT lineID FROM Vehicle WHERE numberPlate = V_numberPlate);

DROP FUNCTION Getstops;

SELECT * FROM TABLE (FN45465.Getstops('CB2020HX'));

-- --------------------------------------------------------------------------------------------------------

CREATE FUNCTION Getmaxdist ()
RETURNS REAL
RETURN SELECT Max (distance) FROM Line;

DROP FUNCTION Getmaxdist;
				      
SELECT * FROM Line WHERE distance = FN45465.Getmaxdist()
