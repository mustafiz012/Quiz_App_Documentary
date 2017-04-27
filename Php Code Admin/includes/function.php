<?php error_reporting(0);
require_once("thumbnail_images.class.php");
class k_wallpaper
{

//Levels 
	function addlevel()
	{
		
									$level_result=mysql_query('INSERT INTO `tbl_levels` (`level_name` ,`required_points`) VALUES (  \''.addslashes($_POST['level_name']).'\',\''.addslashes($_POST['points']).'\')');
						  }
	
	
	function editlevel()
	{
			 
			 
								 $level_result=mysql_query('UPDATE `tbl_levels` SET `level_name`=\''.addslashes($_POST['level_name']).'\',`required_points`=\''.addslashes($_POST['points']).'\' WHERE lid=\''.$_GET['level_id'].'\'');
 						  }
	function deletelevel()
	{
			$del_result=mysql_query('DELETE FROM `tbl_question` WHERE level_id=\''.$_GET['level_id'].'\'');
		    $level_result=mysql_query('DELETE FROM `tbl_levels` WHERE lid=\''.$_GET['level_id'].'\'');
	}

//Add Question
	function addquestion()
	{
	if($_POST['question']!="")
	{
	 $count=count($_POST['question']);
		for($k=0; $k<$count; $k++)
					{	
								$que=$_POST['question'][$k];
								$op1=$_POST['option1'][$k];
								$op2=$_POST['option2'][$k];
								$op3=$_POST['option3'][$k];
								$op4=$_POST['option4'][$k];
								$ans=$_POST['answer'][$k];
					
				$qry=('INSERT INTO `tbl_question`(`level_id`,`question`,`option_1`,`option_2`,`option_3`,`option_4`,`ans`) 		                VALUES
	  		(\''.$_POST['level_id'].'\',\''.$que.'\',\''.$op1.'\',\''.$op2.'\',\''.$op3.'\',\''.$op4.'\',\''.$ans.'\')');
								$res=mysql_query($qry);
								
	  }
	}
	
	}
		
	function editquestion()
	{
	if($_POST['question']!="")
	{
		$que=$_POST["question"];
			
	$res=mysql_query('UPDATE `tbl_question` SET `level_id`=\''.$_POST['level_id'].'\',`question`=\''.$_POST['question'].'\',
	`option_1`=\''.$_POST['option1'].'\',`option_2`=\''.$_POST['option2'].'\',`option_3`=\''.$_POST['option3'].'\',
	`option_4`=\''.$_POST['option4'].'\',`ans`=\''.$_POST['answer'].'\' WHERE id=\''.$_GET['question_id'].'\'');
	}
	}
	
	function deletequestion()
	{
			$result=mysql_query('DELETE FROM `tbl_question` WHERE id=\''.$_GET['question_id'].'\'');
	}	
	
	function editProfile()
 {
    
   $res=mysql_query('UPDATE `tbl_admin` SET `username`=\''.$_POST['username'].'\',`password`=\''.$_POST['password'].'\',`email`=\''.$_POST['email'].'\' WHERE id=\''.$_SESSION['id'].'\'');
 }	
}


?>