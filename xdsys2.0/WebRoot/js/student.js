/**
 * Created by Administrator on 2017/10/29.
 */
$(document).ready(function () {
    var myDate = new Date();
    var mytime=myDate.toLocaleString();
    $("#welcome").append(mytime);
});