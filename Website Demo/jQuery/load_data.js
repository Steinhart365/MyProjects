// simple function to load data when element is clicked

$(document).ready(function() {
    $("#schedule").click(function() {
        $("#display").load("data_holder.html #schedule");
    });
    $("#grades").click(function() {
        $("#display").load("data_holder.html #grades");
    });
    $("#appraisals").click(function() {
        $("#display").load("data_holder.html #praise");
    });
});