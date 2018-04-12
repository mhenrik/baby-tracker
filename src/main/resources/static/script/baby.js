const babyController = {

    addNewBaby: function () {
        $("#newBabyButton").on("click", function (event) {
            event.preventDefault(event);
            $.ajax({
                type: "POST",
                url: "/new-baby",
                data: $("#newBabyForm").serialize(),
                success: function (response) {
                    console.log(response);
                },
                error: function (response) {
                    console.log(response)
                }
            })
        })
    }

};