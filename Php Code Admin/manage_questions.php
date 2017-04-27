<?php include("includes/header.php");

	require("includes/function.php");
	$kwallpaper=new  k_wallpaper;
	
	 

	$tableName="tbl_question";		
	$targetpage = "manage_questions.php"; 	
	$limit = 15; 
	
	$query = "SELECT COUNT(*) as num FROM $tableName";
	$total_pages = mysql_fetch_array(mysql_query($query));
	$total_pages = $total_pages['num'];
	
	$stages = 3;
	$page=0;
	if(isset($_GET['page'])){
	$page = mysql_escape_string($_GET['page']);
	}
	if($page){
		$start = ($page - 1) * $limit; 
	}else{
		$start = 0;	
		}	
	
    // Get page data
	if(isset($_POST["search"]))
{
	$question_value=$_POST['search_value']; 
	$qry="SELECT * FROM tbl_question,tbl_levels WHERE level_id=lid and question LIKE '%".$question_value."%' ORDER BY tbl_question.id DESC LIMIT $start, $limit"; 
	
}
else{ 
   $qry="SELECT * FROM tbl_question LEFT JOIN tbl_levels ON tbl_question.level_id= tbl_levels.lid ORDER BY tbl_question.id DESC LIMIT $start, $limit";	  
}
	$result=mysql_query($qry);

 
	
	if(isset($_GET['question_id']))
	{
		$kwallpaper->deletequestion();
		
		 
		echo "<script>document.location='manage_questions.php';</script>"; 
	    exit;
		
	}	
	 
?>
                <!-- h2 stays for breadcrumbs -->                
                <div id="main">
				<h2> Manage Quiz Questions &raquo;</h2>
                
                 <form  method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">
                    <div class="search">
                        <input  type="text" name="search_value" placeholder="Find" class="search_text"> 
                        <button type="submit" value="submit" name="search" class="search_button">Search</button>
                    </div>       
                </form>         
                	<form action="" class="jNice">
					 
					<h3 class="abtn"><a href="add_questions.php?add=yes">Add New Question</a></h3>
                    	<table cellpadding="0" cellspacing="0">
						
						<tr align="center">
						<th>Level</th>						 
						<th>Question</th>
						<th>Edit</th>
						<th>Delete</th>
						
						</tr>
						
						
						<?php
						
							$i=0;
							while($row=mysql_fetch_array($result))
							{
							  $letter = mb_substr($row['question'], 0, 40)
						?>							
							                   
							<tr <?php if($i%2==0){?>class="odd"<?php }?> align="center">
								<td><?php echo $row['level_name'];?></td>					 
                               <td><?php echo $letter;?></td>						 
                                <td class="action"><a href="edit_question.php?question_id=<?php echo $row['id'];?>" class="edit">Edit</a></td>
								<td class="action"><a href="?question_id=<?php echo $row['id'];?>" class="delete" onclick="return confirm('Are you sure you want to delete this Question?');">Delete</a></td>
                            </tr>                        
						
						<?php
						
							$i++;
							}
						?>	 
							                    
                        </table><br />
						<?php
								// Initial page num setup
	if ($page == 0){$page = 1;}
	$prev = $page - 1;	
	$next = $page + 1;							
	$lastpage = ceil($total_pages/$limit);		
	$LastPagem1 = $lastpage - 1;					
	
	
	$paginate = '';
	if($lastpage > 1)
	{	
	

	
	
		$paginate .= "<div class='paginate'>";
		// Previous
		if ($page > 1){
			$paginate.= "<a href='$targetpage?page=$prev'>previous</a>";
		}else{
			$paginate.= "<span class='disabled'>previous</span>";	}
			

		
		// Pages	
		if ($lastpage < 7 + ($stages * 2))	// Not enough pages to breaking it up
		{	
			for ($counter = 1; $counter <= $lastpage; $counter++)
			{
				if ($counter == $page){
					$paginate.= "<span class='current'>$counter</span>";
				}else{
					$paginate.= "<a href='$targetpage?page=$counter'>$counter</a>";}					
			}
		}
		elseif($lastpage > 5 + ($stages * 2))	// Enough pages to hide a few?
		{
			// Beginning only hide later pages
			if($page < 1 + ($stages * 2))		
			{
				for ($counter = 1; $counter < 4 + ($stages * 2); $counter++)
				{
					if ($counter == $page){
						$paginate.= "<span class='current'>$counter</span>";
					}else{
						$paginate.= "<a href='$targetpage?page=$counter'>$counter</a>";}					
				}
				$paginate.= "...";
				$paginate.= "<a href='$targetpage?page=$LastPagem1'>$LastPagem1</a>";
				$paginate.= "<a href='$targetpage?page=$lastpage'>$lastpage</a>";		
			}
			// Middle hide some front and some back
			elseif($lastpage - ($stages * 2) > $page && $page > ($stages * 2))
			{
				$paginate.= "<a href='$targetpage?page=1'>1</a>";
				$paginate.= "<a href='$targetpage?page=2'>2</a>";
				$paginate.= "...";
				for ($counter = $page - $stages; $counter <= $page + $stages; $counter++)
				{
					if ($counter == $page){
						$paginate.= "<span class='current'>$counter</span>";
					}else{
						$paginate.= "<a href='$targetpage?page=$counter'>$counter</a>";}					
				}
				$paginate.= "...";
				$paginate.= "<a href='$targetpage?page=$LastPagem1'>$LastPagem1</a>";
				$paginate.= "<a href='$targetpage?page=$lastpage'>$lastpage</a>";		
			}
			// End only hide early pages
			else
			{
				$paginate.= "<a href='$targetpage?page=1'>1</a>";
				$paginate.= "<a href='$targetpage?page=2'>2</a>";
				$paginate.= "...";
				for ($counter = $lastpage - (2 + ($stages * 2)); $counter <= $lastpage; $counter++)
				{
					if ($counter == $page){
						$paginate.= "<span class='current'>$counter</span>";
					}else{
						$paginate.= "<a href='$targetpage?page=$counter'>$counter</a>";}					
				}
			}
		}
					
				// Next
		if ($page < $counter - 1){ 
			$paginate.= "<a href='$targetpage?page=$next'>next</a>";
		}else{
			$paginate.= "<span class='disabled'>next</span>";
			}
			
		$paginate.= "</div>";		
	
	
}
  
 // pagination
 echo $paginate;
								?>		 
 <br />
					 
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
<?php include("includes/footer.php");?>       
