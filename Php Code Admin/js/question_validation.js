function checkValidation()
{
	 
	if(document.getElementById('level_id').value=="")
	{
		alert("Please Select Level.!");
		 
		document.getElementById('level_id').focus();		 
		return false;
	}
	if(document.getElementById('question[]').value=="")
	{
		alert("Please Add Question!");
		 
		document.getElementById('question[]').focus();	
		document.getElementById('question[]').select();	 
		return false;
	}
		if(document.getElementById('option1[]').value=="")
	{
		alert("Please Add Option1!");
		 
		document.getElementById('option1[]').focus();	
		document.getElementById('option1[]').select();	 
		return false;
	}
		if(document.getElementById('option2[]').value=="")
	{
		alert("Please Add Option2!");
		 
		document.getElementById('option2[]').focus();	
		document.getElementById('option2[]').select();	 
		return false;
	}
		if(document.getElementById('option3[]').value=="")
	{
		alert("Please Add Option3!");
		 
		document.getElementById('option3[]').focus();	
		document.getElementById('option3[]').select();	 
		return false;
	}
	
		if(document.getElementById('option4[]').value=="")
	{
		alert("Please Add Option4!");
		 
		document.getElementById('option4[]').focus();	
		document.getElementById('option4[]').select();	 
		return false;
	}
	
		if(document.getElementById('answer[]').value=="")
	{
		alert("Please Add Answer!");
		 
		document.getElementById('answer[]').focus();	
		document.getElementById('answer[]').select();	 
		return false;
	}

return true;
} 
function editValidation()
{
	 
	if(document.getElementById('level_id').value=="")
	{
		alert("Please Select Level.!");
		 
		document.getElementById('level_id').focus();		 
		return false;
	}
	if(document.getElementById('question[]').value=="")
	{
		alert("Please Add Question!");
		 
		document.getElementById('question[]').focus();	
		document.getElementById('question[]').select();	 
		return false;
	}
		if(document.getElementById('option1[]').value=="")
	{
		alert("Please Add Option1!");
		 
		document.getElementById('option1[]').focus();	
		document.getElementById('option1[]').select();	 
		return false;
	}
		if(document.getElementById('option2[]').value=="")
	{
		alert("Please Add Option2!");
		 
		document.getElementById('option2[]').focus();	
		document.getElementById('option2[]').select();	 
		return false;
	}
		if(document.getElementById('option3[]').value=="")
	{
		alert("Please Add Option3!");
		 
		document.getElementById('option3[]').focus();	
		document.getElementById('option3[]').select();	 
		return false;
	}
	
		if(document.getElementById('option4[]').value=="")
	{
		alert("Please Add Option4!");
		 
		document.getElementById('option4[]').focus();	
		document.getElementById('option4[]').select();	 
		return false;
	}
	
		if(document.getElementById('answer[]').value=="")
	{
		alert("Please Add Answer!");
		 
		document.getElementById('answer[]').focus();	
		document.getElementById('answer[]').select();	 
		return false;
	}
	 
	return true;
}