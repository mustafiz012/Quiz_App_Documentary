<?php include("includes/header.php");

	require("includes/function.php");
	$kwallpaper=new  k_wallpaper;
	
	
	//Get all Category 
	$qry="SELECT * FROM tbl_levels";
	$result=mysql_query($qry);
	
	if(isset($_GET['level_id']))
	{
		$kwallpaper->deletelevel();
		
		 
		echo "<script>document.location='manage_levels.php';</script>"; 
	    exit;
		
	}	
	 
?>
                <!-- h2 stays for breadcrumbs -->
              
                <div id="main">
                  <h2> Manage Levels &raquo;</h2>
                
                
                	<form action="" class="jNice">
					 <h3 class="abtn"><a href="add_levels.php?add=yes">Add Level</a></h3>
					 
                    	<table cellpadding="0" cellspacing="0">
						<tr align="center">
						<th>Level</th>						 
						<th>Required Points</th>
						<th>Edit</th>
						<th>Delete</th>
						
						</tr>
						<?php
						
							$i=0;
							while($row=mysql_fetch_array($result))
							{
							
						?>	
						                    
							<tr <?php if($i%2==0){?>class="odd"<?php }?> align="center">
                                <td><?php echo $row['level_name'];?></td>
                                <td><?php echo $row['required_points'];?></td>
                                <td class="action"><a href="add_levels.php?level_id=<?php echo $row['lid'];?>" class="edit">Edit</a></td>
                                <td class="action"><a href="?level_id=<?php echo $row['lid'];?>" class="delete" onclick="return confirm('Are you sure you want to delete this Level and related Questions?');">Delete</a></td>
                            </tr>  
                               
						<?php
							$i++;
							}
						?>	 
				        </table>
					 
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
<?php include("includes/footer.php");?>       
