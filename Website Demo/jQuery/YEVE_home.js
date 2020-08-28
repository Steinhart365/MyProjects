$(document).ready(function() {

    var slider = $("#image_list");
    var leftProperty, newLeftProperty;

    $("#right_button").click(function() {
        leftProperty = parseInt(slider.css("left"));

        if (leftProperty - 300 <= -1500) {
            newLeftProperty = 0;
        } else {
            newLeftProperty = leftProperty - 300;
        }

        slider.animate({ left: newLeftProperty }, 1000);
    });


    $("#left_button").click(function() {

        leftProperty = parseInt(slider.css("left"));

        if (leftProperty < 0) {
            newLeftProperty = leftProperty + 300;
        } else {
            newLeftProperty = -1200;
        }
        slider.animate({ left: newLeftProperty }, 1000);
    });
});