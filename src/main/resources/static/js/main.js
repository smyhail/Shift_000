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
            alert(now)
            $.get(href, function (zadania, status) {
                $('.myForm #id').val(zadania.id);
                $('.myForm #title').val(zadania.title);
                $('.myForm #desc').val(zadania.desc);
                $('.myForm #status').val(zadania.status);
                $('.myForm #actual').val(now.format("YYYY-MM-DD HH:mm:ss"));

            });

        } else {

            // alert("BEDZIEMY DODAWAC NOWEGO");
            let now = moment();
            //  var d = new Date();
            //  var dd = d.getFullYear() + "-" + d.get + "-" + d.getDay();
            //  var time = d.getFullYear() + "-" + d.getMinutes() + ":" + d.getSeconds();

            $('.myForm #id').val('');
            $('.myForm #title').val('');
            $('.myForm #desc').val('');
            $('.myForm #status').val('');
            $('.myForm #actual').val(now.format("yyyy-MM-dd hh:mm"));

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