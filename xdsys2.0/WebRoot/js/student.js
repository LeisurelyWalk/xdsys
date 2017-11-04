/**
 * Created by Administrator on 2017/10/29.
 */
$(document).ready(function () {
    var myDate = new Date();
    var mytime=myDate.toLocaleString();
    $("#welcome").append(mytime);
    
    
    $("#checkSubmit").click(function () {
        var numidArr= new Array();
        $("input[type='checkbox']:checkbox:checked").each(function(){
            var temp=($(this).parent().parent());
            numidArr.push(temp.children("td.CourseId").attr("id"));
//            console.log($(this).attr("id"));
        });
        $.ajax({
            url: "../course/submitCourses",
            type: "POST",
            contentType : "application/x-www-form-urlencoded",
            dataType: "json",
            data: {"arrId":JSON.stringify(numidArr)},
            success: function(data) {
                alert()
//	            $("#result").val(ss);
                console.log(data);
            }
        });
    });
    
});