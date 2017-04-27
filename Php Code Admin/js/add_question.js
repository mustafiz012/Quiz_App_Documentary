// JavaScript Document

var counter = 1;
var limit = 10;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML =" <br><div class='wrapper' style='margin-left:0px;margin-top:10px;'><br><label style='margin-top:10px;'>Your Question:</label><input type='text' name='question[]' id='question[]' class='text-long' /><br><br><label style='margin-top:10px;'>Option 1:</label><input type='text' name='option1[]' id='option1[]' class='text-long' /><br><br><label style='margin-top:10px;'>Option 2:</label><input type='text' name='option2[]' id='option2[]' class='text-long' /><br><br><label style='margin-top:10px;'>Option 3:</label><input type='text' name='option3[]' id='option3[]' class='text-long' /><br><br><label style='margin-top:10px;'>Option 4:</label><input type='text' name='option4[]' id='option4[]' class='text-long' /><br><br><label style='margin-top:10px;'>Answer:</label><input type='text' name='answer[]' id='answer[]' class='text-long' /></div>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
