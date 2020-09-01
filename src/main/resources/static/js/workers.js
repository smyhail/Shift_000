$(document).ready(function () {
    // alert("Hello! I am an alert box!!");
    // const moment = require('moment');
    $(' .nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        if (text == 'Edytuj') {

            //  alert("BEDZIEMY EDYTOWAC");
            let now = moment();
          //  alert()
            $.get(href, function (worker, status) {

                $(".myForm #myFormLabel").empty();
                $(".myForm #myFormLabel").append("Edycja pracowników");
                $('.myForm #idW').val(worker.idW);
                $('.myForm #workerFirstName').val(worker.workerFirstName);
                $('.myForm #workerName').val(worker.workerSurname);
                $('.myForm #workerSurname').val(worker.workerSurname);
                $('.myForm #stamp').val(worker.stamp);
                $('.myForm #shiftName').val(worker.shiftName);
                $('.myForm #statusWorker').val(worker.statusWorker);
                $('.myForm #actual').val(now.format("YYYY-MM-DD HH:mm:ss"));
            });

        } else {
            let now = moment();
             $(".myForm #myFormLabel").empty();
             $(".myForm #myFormLabel").append("Dodawanie pracownika");
             $('.myForm #idW').val('');
             $('.myForm #workerFirstName').val('');
             $('.myForm #workerName').val('');
             $('.myForm #workerSurname').val('');
             $('.myForm #stamp').val('');
             $('.myForm #shiftName').val('');
             $('.myForm #statusWorker').val("");
             $('.myForm #actual').val(now.format("YYYY-MM-DD HH:mm:ss"));
        }
        $('.myForm #exampleModal').modal();
    });


    ///DELETE MODAL
    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });


});