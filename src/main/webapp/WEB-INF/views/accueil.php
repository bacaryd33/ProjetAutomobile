<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body style='background:#fff;'>

    <div id="content">
        <!-- tester si l'utilisateur est connecté -->
        <?php
        session_start();
        if ($_SESSION['username'] !== "") {
            $user = $_SESSION['username'];
            // afficher un message
            echo "Bonjour $user, vous êtes connecté";
        }
        ?>
    </div>
    <div id="content">
        <a href='login.php?deconnexion=true'><span>Déconnexion</span></a>
    </div>
    <table id="myData">

    </table>

    <script type="text/javascript">
        $('#search').click(function() {
            alert("submit handler has fired");
            $.ajax({
                type: 'POST',
                url: 'cityResults.htm',
                data: $('#cityDetails').serialize(),

                success: function(data){
                    $.each(data, function( index, value ) {
                        var row = $("<tr><td>" + value.city + "</td><td>" + value.cStatus + "</td></tr>");
                        $("#myData").append(row);
                    });
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus + ': ' + errorThrown);
                }
            });
            return false;//suppress natural form submission
        });

    </script>
</body>
</html>