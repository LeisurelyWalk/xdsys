/**
 * 
 */
$(document).ready(function(){

	
	$("#submit").on("click",function(){
		var numid=$("#name").val();
		var password=$("#password").val();
		var user={"numid":numid,"password":password}; 
		$.ajax({  
	        url: "submit",  
	        type: "POST",  
	        contentType : "application/x-www-form-urlencoded",  
	        dataType: "json",  
	        data: user,  
	        success: function(data) {  
	             var msg=data.msg;
	             if(msg=="failure"){
	            	 alert("学号，密码不匹配");
	             }
	             else if(msg=="noNumid"){
	            	 alert("学号输入有误");
	             }
	             else{
//	            	 alert(window.location.host);
	            	 var host=window.location.host;
	            	 window.location.replace("http://"+host+"/xdsys2.0/users/student?numid="+numid);
	             }
//	            $("#result").val(ss);  
	            console.log(data.msg);  
	        }  
	    });  
	})
});