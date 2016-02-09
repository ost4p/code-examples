<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<title>Robot</title>
    <style type="text/css">
        #robotHead{
            border: 2px solid #000;
            width: 70px;
            height: 70px;
            /*position: absolute;*/
            top: 40px;
            left: 400px;
        }
        
        #robotBody{
            border: 2px solid #000;
            width: 150px;
            height: 200px;
            position: absolute;
            top: 112px;
            left: 365px;
        }
        
        #robotLeftArm{
            border: 2px solid #000;
            width: 50px;
            height: 50px;
            position: absolute;
            top: 150px;
            left: 313px;
        }
        
        #robotRightArm{
            border: 2px solid #000;
            width: 50px;
            height: 50px;
            position: absolute;
            top: 150px;
            left: 517px;
        }
        
        #robotLeftLeg{
            border: 2px solid #000;
            width: 50px;
            height: 70px;
            position: absolute;
            top: 314px;
            left: 380px;
        }
        
        #robotRightLeg{
            border: 2px solid #000;
            width: 50px;
            height: 70px;
            position: absolute;
            top: 314px;
            left: 450px;
        }
    </style>
</head>

<body>
	<div id="robotHead"></div>
    <div id="robotBody"></div>
    <div id="robotLeftArm"></div>
    <div id="robotRightArm"></div>
    <div id="robotLeftLeg"></div>
    <div id="robotRightLeg"></div>
</body>
</html>
<?php
    echo "HELLO WORLD! I am an ugly robot";

    
?>
