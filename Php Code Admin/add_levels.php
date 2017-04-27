<?php include("includes/header.php");

	require("includes/function.php");
	$kwallpaper=new  k_wallpaper;
	
	if(isset($_POST['submit']) and isset($_GET['add']))
	{
	
		$_SESSION['msg']="Level added successfully";
		
		
		$kwallpaper->addlevel();
		
		 
		echo "<script>document.location='manage_levels.php';</script>"; 
	    exit;
		
	}
	
	if(isset($_GET['level_id']))
	{
			 
			$qry="SELECT * FROM tbl_levels where lid='".$_GET['level_id']."'";
			$result=mysql_query($qry);
			$row=mysql_fetch_assoc($result);

	}
	if(isset($_POST['submit']) and isset($_POST['edit']))
	{
		 
		$kwallpaper->editlevel();
		
		echo "<script>document.location='manage_levels.php';</script>"; 
	    exit;
	}


?>
<script src="js/edit_levels.js" type="text/javascript"></script>
<script src="js/levels.js" type="text/javascript"></script>  
                 
                <div id="main">
                <h2><a href="home.php">Dashboard</a> &raquo; <a href="#" class="active"></a></h2>
                
                
                	<form action="" name="addeditlevel" method="post" class="jNice" 
onsubmit="<?php if(isset($_GET['level_id'])){?>return checkeditValidation(this)<?php }else{?>return checkValidation(this)<?php }?>" enctype="multipart/form-data">
					 
					<input  type="hidden" name="edit" value="<?php echo $_GET['level_id'];?>" />
					                    	 
					<h3><?php if(isset($_GET['level_id'])){?>Edit<?php }else{?>Add<?php }?> Level</h3>
                    	<fieldset>
						 
                        	<p><label>Level Name:</label>
								<input type="text" name="level_name" id="level_name" value="<?php if(isset($_GET['level_id'])){echo $row['level_name'];}?>" class="text-long" />
							</p>
                            
                            	<p><label>Points required:</label>
								<input type="number" name="points" id="points" min="0" max="999" value="<?php if(isset($_GET['level_id'])){echo $row['required_points'];}?>" class="text-long" />
							</p>
                        
                        	<input type="submit" name="submit" value="<?php if(isset($_GET['level_id'])){?>Edit Level<?php }else {?>Add Level<?php }?>" onclick="return chk(this);"/>
                        </fieldset>
                    </form>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
<?php include("includes/footer.php");?>       
