function checkValidation()
{
	if(document.getElementById('level_name').value=="")
	{
		alert("Please Enter Level Name.!");
		 
		document.getElementById('level_name').focus();
		document.getElementById('level_name').select();
		return false;
	}
	
		if(document.getElementById('points').value=="")
	{
		alert("Please select Required Points!");
		 
		document.getElementById('points').focus();
		document.getElementById('points').select();
		return false;
	}
	
	
	return true;
} 