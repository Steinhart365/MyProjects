$(document).ready(function() {

    // the handler that triggers validation and submission
    $("#clientInfo").submit(
        function(event) {
            var isValid = true;

            /* validate last name-trimming for spaces, then expression ensures there is actual text not just spaces */
            var regex = /^[a-zA-Z ]{2,30}$/;
            var last = $("#lastName").val().trim();
            if (last == "") {
                $("#lastName").next().text("Please enter your last name");
                isValid = false;
            } else if (!regex.test(last)) {
                $("#lastName").next().text("Please enter a valid name");
                isValid = false;
            } else {
                $("#lastName").next().text("");
            }
            $("#lastName").val(last);

            // first name validation - very similar to last name - uses same reg. expression
            var first = $("#firstName").val().trim();
            if (first == "") {
                $("#firstName").next().text("Please submit your first name");
                isValid = false;
            } else if (!regex.test(first)) {
                $("#firstName").next().text("Please enter a valid name");
                isValid = false;
            } else {
                $("#firstName").next().text("");
            }
            $("#firstName").val(first);

            // validate the email entry with a regular expression and then test if it works 
            var emailPattern = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b/;
            var email = $("#email").val().trim();
            if (email == "") {
                $("#email").next().text("Please enter your email");
                isValid = false;
            } else if (!emailPattern.test(email)) {
                $("#email").next().text("Sorry, that email is not registered");
                isValid = false;
            } else {
                $("#email").next().text("");
            }
            $("#email").val(email);

            // validate the zip-code entry length, and allow numbers only
            var zip = $("#zip").val().trim();
            var regex = /^[1-9]\d{5}$/;
            if (zip == "") {
                $("#zip").next().text("Please enter your zipcode");
                isValid = false;
            } else if (zip.length != 5) {
                $("#zip").next().text("Use 5 digit format");
                isValid = false;

            } // if zip is valid do a calculation and alert the sender they have an ID number
            else {
                $("#zip").next().text("");
            }
            $("#zip").val(zip);

            // validate that a button is selected
            if (!$("input[name='choice']:checked").val()) {
                $("#misc").next().text("Please check an option");
                isValid = false;
            } else {
                $("#misc").next().text("");
            }

            // if valid, calculate and alert the case ID number
            if (isValid) {
                var code = parseInt(("#zip").val()) * 3;
                alert("Your case ID is: " + code + ". Please make sure to remember it.");
            }
            // prevent the default action of submitting the form if any entries are invalid 
            else {
                event.preventDefault();
                return false;
            }
        }
    );
});