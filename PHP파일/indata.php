<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<?php

$con=mysqli_connect("localhost","root","","toilet");
if (mysqli_connect_errno($con))

{

   echo "Failed to connect to MySQL: " . mysqli_connect_error();

}
mysqli_set_charset($con,"utf8");

$name = $_POST['name'];
$latitude = $_POST['latitude'];
$longitude = $_POST['longitude'];
$murinal = $_POST['murinal'];
$mcloset = $_POST['mcloset'];
$wcloset = $_POST['wcloset'];
$addr = $_POST['addr'];
$etc = $_POST['etc'];


$sql = " INSERT INTO crowdata(name,latitude,longitude,murinal,mcloset,wcloset,addr,etc) VALUES ('$name','$latitude','$longitude','$murinal','$mcloset','$wcloset','$addr','$etc')";
$result = mysqli_query($con,$sql);

if(!$result){
	die(mysqli_error($con));
}
else{
	echo "1 record added";
}

mysqli_close($con);
?>