<?php include("includes/header.php");

	require("includes/function.php");
	$kwallpaper=new  k_wallpaper;
	
	
	//Get all Level 
	$qry="SELECT * FROM tbl_levels";
	$result=mysql_query($qry);

	
	if(isset($_GET['question_id']))
	{
		$que_qry="SELECT * FROM tbl_question WHERE id='".$_GET['question_id']."'";
		$que_res=mysql_query($que_qry);
		$que_row=mysql_fetch_assoc($que_res);
		 
		 
	}
	if(isset($_POST['submit']) and isset($_GET['question_id']))
	{
	 
		$kwallpaper->editquestion();
		
		 
		echo "<script>document.location='manage_questions.php';</script>"; 
	    exit;
	}	
?>
<script src="js/levels.js" type="text/javascript"></script>
  
                <!-- h2 stays for breadcrumbs -->                                
                <div id="main">                	
					 <h2><a href="home.php">Dashboard</a> &raquo; <a href="#" class="active"></a></h2>
                     <h3>Edit Question</h3>                   	
					
					<form action="" method="post"  enctype="multipart/form-data" onsubmit="return editValidation(this)">
						<fieldset>
						
							<p>
								<label>Select Level:</label>
								
								 
									<select name="level_id" id="level_id" style="width:280px; height:25px;">
			
										<option value="0">--Select level--</option>
										<?php
												while($row=mysql_fetch_array($result))
												{
										 			if(isset($_POST['level']))
													{
															if($_POST['level']==$row['lid']){
															?>
															<option value="<?php echo $row['lid'];?>"  selected="selected"><?php echo $row['level_name'];?></option>								<?php }else{?>
										<option value="<?php echo $row['lid'];?>"><?php echo $row['level_name'];?></option>								
										<?php 				}?>
												<?php }
													else
													{
														 if($que_row['level_id']==$row['lid']){
											 
											 ?>
										<option value="<?php echo $row['lid'];?>"  selected="selected"><?php echo $row['level_name'];?> </option>								<?php }else{?>
										<option value="<?php echo $row['lid'];?>"><?php echo $row['level_name'];?></option>								
										<?php 				}
														}
												}
										?>
									</select>
									  </p>
				                      <p><label>Your Question:</label>
                            	<input type="text" name="question" id="question" value="<?php echo $que_row['question'];?>" class="text-long" />
                            </p>
                            
                              <p><label>Option 1:</label>
                                	<input type="text" name="option1" id="option1" value="<?php echo $que_row['option_1'];?>" class="text-long" /></p>
                                    
                                      <p><label>Option 2:</label>
                                	<input type="text" name="option2" id="option2" value="<?php echo $que_row['option_2'];?>" class="text-long" /></p>
                                    
                                      <p><label>Option 3:</label>
                                	<input type="text" name="option3" id="option3" value="<?php echo $que_row['option_3'];?>" class="text-long" /></p>
                                    
                                      <p><label>Option 4:</label>
                                	<input type="text" name="option4" id="option4" value="<?php echo $que_row['option_4'];?>" class="text-long" /></p>
                                    
                                      <p><label>Answer:</label>
                                	<input type="text" name="answer" id="answer" value="<?php echo $que_row['ans'];?>" class="text-long" /></p>
							
                         	 
                            <input type="submit" name="submit" value="Edit Question" />
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
