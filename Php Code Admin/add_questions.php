<?php include("includes/header.php");

	require("includes/function.php");
	$kwallpaper=new  k_wallpaper;
	
	
	//Get all Category 
	$qry="SELECT * FROM tbl_levels";
	$result=mysql_query($qry);
	
	 	
	if(isset($_POST['submit']) and isset($_GET['add']))
	{	
		 
		$kwallpaper->addquestion();
		
		echo "<script>document.location='manage_questions.php';</script>"; 
	    exit;
		
	}	
	 
?>
<script src="js/question_validation.js" type="text/javascript"></script>
 <script src="js/add_question.js" type="text/javascript"></script> 

                  
                <!-- h2 stays for breadcrumbs -->                                
                <div id="main">                	
					 <h2><a href="home.php">Dashboard</a> &raquo; <a href="#" class="active"></a></h2>
                     <h3>Add Questions</h3>                   	
					
					<form action="" method="post"  enctype="multipart/form-data" onsubmit="return checkValidation(this);">
						<fieldset>
						
							<p>
								<label>Select Level:</label>
								
								 
									<select name="level_id" id="level_id" style="width:280px; height:25px;">
			
										<option value="">--Select Level--</option>
										<?php
												while($row=mysql_fetch_array($result))
												{
										?>
										<?php if($_POST['level']==$row['lid']){?>
										<option value="<?php echo $row['lid'];?>"  selected="selected"><?php echo $row['level_name'];?> </option>								<?php }else{?>
										<option value="<?php echo $row['lid'];?>"><?php echo $row['level_name'];?></option>								
										<?php }?>
										<?php
											}
										?>
									</select>
									  </p>
                                     <div class="wrapper"> 
                                      <p>
                                      
                                      <p><label>Your Question:</label>
                                	<input type="text" name="question[]" id="question[]" value="" class="text-long" /></p>
                                    
                                    
                                      <p><label>Option 1:</label>
                                	<input type="text" name="option1[]" id="option1[]" value="" class="text-long" /></p>
                                    
                                      <p><label>Option 2:</label>
                                	<input type="text" name="option2[]" id="option2[]" value="" class="text-long" /></p>
                                    
                                      <p><label>Option 3:</label>
                                	<input type="text" name="option3[]" id="option3[]" value="" class="text-long" /></p>
                                    
                                      <p><label>Option 4:</label>
                                	<input type="text" name="option4[]" id="option4[]" value="" class="text-long" /></p>
                                    
                                      <p><label>Answer:</label>
                                	<input type="text" name="answer[]" id="answer[]" value="" class="text-long" /></p>
							
                            </div>
                            </p>
                        	<p><div id="dynamicInput"></div></p>
                        	<p><input type="submit" name="submit" value="Submit" />
                            <input type="reset" value="reset" />
                            <input type="button" value="Add another Question" onClick="addInput('dynamicInput');"></p>
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
