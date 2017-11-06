$(document).ready(function () {
    var myDate = new Date();
    var mytime=myDate.toLocaleString();
    $("#welcome").append(mytime);
    
    $("#courseSubmit").on("click",function () {
        $("#newCourses").show();
    })
});