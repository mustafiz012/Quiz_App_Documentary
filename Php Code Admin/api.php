<?php include("includes/connection.php");
 
	
	if(isset($_GET['level_id']))
	{
		
		$level_id=$_GET['level_id'];		
	
			$query="SELECT * FROM tbl_question
		LEFT JOIN tbl_levels ON tbl_question.level_id= tbl_levels.lid 
		where tbl_question.level_id='".$level_id."'";
		
	}
	else if(isset($_GET['latest']))
	{
		$limit=$_GET['latest'];	 	
		$query="SELECT * FROM tbl_question
		LEFT JOIN tbl_levels ON tbl_question.level_id= tbl_levels.lid 
		ORDER BY tbl_question.id DESC LIMIT $limit";
	}
	else
	{
		$query="SELECT lid,level_name,required_points FROM tbl_levels";
	}
	
	$resouter = mysql_query($query);
     
    $set = array();
     
    $total_records = mysql_numrows($resouter);
    if($total_records >= 1){
     
      while ($link = mysql_fetch_array($resouter, MYSQL_ASSOC)){
	   
        $set['Quiz'][] = $link;
      }
    }
     
     echo $val= str_replace('\\/', '/', json_encode($set));
	 	 
	 
?>