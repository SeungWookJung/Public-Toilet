
<?php

$con=mysqli_connect("localhost","root","","toilet");

 

if (mysqli_connect_errno($con))

{

   echo "Failed to connect to MySQL: " . mysqli_connect_error();

}
mysqli_set_charset($con,"utf8");
    
 

$res = mysqli_query($con,"select * from toiletdata");  
$res2 = mysqli_query($con,"select * from crowdata");
 
$reduced_arr = array();
$reduced_arr2 = array();
    
 while($row = mysqli_fetch_array($res)){  
   array_push($reduced_arr,  
 array('ID'=>$row[0],'addrRoad'=>$row[1],'addrJibun'=>$row[2],'toiletName'=>$row[3],'longitude'=>$row[4],'latitude'=>$row[5],'mcloset'=>$row[6],'wcloset'=>$row[7],'murinal'=>$row[8]));  
 }
 while($row2 = mysqli_fetch_array($res2)){
 	array_push($reduced_arr2,array('ID'=>$row2[0],'addrRoad'=>$row2[7],'toiletName'=>$row2[1],'longitude'=>$row2[3],'latitude'=>$row2[2],'mcloset'=>$row2[5],'wcloset'=>$row2[6]));
 }




    header('Content-Type: application/json;');

  $json =json_encode(array("result"=>$reduced_arr),JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);  
  $json2 =json_encode(array("result2"=>$reduced_arr2),JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
    echo $json2;
 mysqli_close($con);  

?>