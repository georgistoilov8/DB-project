/* Това не работи в DataGrip...
IF OBJECT_ID (N'Getstops', N'IF') IS NOT NULL  
    DROP FUNCTION Getstops;  
GO  
CREATE FUNCTION Getstops (@veid varchar)  
RETURNS TABLE  
AS  
RETURN   
(  
    Select stopID from consistsOf where lineID in (Select lineID from Vehicle where numberPlate = @veid)
);*/

CREATE FUNCTION Getstops (V_numberPlate CHAR(8))
RETURNS TABLE(
    stopID INT
)
RETURN SELECT stopID FROM CONSIST_OF WHERE lineID IN (SELECT lineID FROM Vehicle WHERE numberPlate = V_numberPlate);

DROP FUNCTION Getstops;

SELECT * FROM TABLE (FN45465.Getstops('CB2020HX'));


/* -||-
IF OBJECT_ID (N'Getmaxdist', N'IF') IS NOT NULL  
    DROP FUNCTION Getdist;  
GO  
CREATE FUNCTION Getmaxdist ()  
RETURNS REAL
AS  
BEGIN
	DECLARE @ret real;
    	Select @ret = Max (distance) from Line;
	Return @ret;

END;
*/
DROP FUNCTION Getdist;

CREATE FUNCTION Getmaxdist ()
RETURNS REAL
RETURN SELECT Max (distance) FROM Line;

SELECT * FROM Line WHERE distance = FN45465.Getmaxdist()
