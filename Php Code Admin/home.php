<?php include("includes/header.php");?>
                
                <!-- h2 stays for breadcrumbs -->
                
                <div id="main">
                	 <h2> Dashboard</h2>
                
					<h3 align="left">Total Levels</h3>
                   <?php 
						
						$qry_level="SELECT COUNT(*) as num FROM tbl_levels";
						$total_level= mysql_fetch_array(mysql_query($qry_level));
						$total_level = $total_level['num'];
					
					?>	
                    	<p style="margin-left:50px;"><a href="manage_category.php" style="color:#009900;text-decoration:none; font-size:16px;"><?php echo $total_level;?></a></p>
                    
                    	 
					<h3 align="right" style="margin-top:-40px">Total Questions</h3>
                     <?php 
						
						$qry_que="SELECT COUNT(*) as num FROM tbl_question";
						$total_que = mysql_fetch_array(mysql_query($qry_que));
						$total_que = $total_que['num'];
					
					?>	 
                     <p align="right" style="margin-right:45px; margin-bottom:50px;"><a href="manage_questions.php" style="color:#009900;text-decoration:none; font-size:16px;"><?php echo $total_que;?></a></p>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
<?php include("includes/footer.php");?>       
