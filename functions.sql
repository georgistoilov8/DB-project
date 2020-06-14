IF OBJECT_ID (N'Getstops', N'IF') IS NOT NULL  
    DROP FUNCTION Getstops;  
GO  
CREATE FUNCTION Getstops (@veid varchar)  
RETURNS TABLE  
AS  
RETURN   
(  
    Select stopID from consistsOf where lineID in (Select lineID from Vehicle where numberPlate = @veid)
);  



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