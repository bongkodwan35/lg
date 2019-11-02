<?php

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $edit_username = $_POST['edit_username'];
    $edit_pass = $_POST['edit_pass']
    $edit_email = $_POST['edit_email'];
    $edit_fname = $_POST['edit_fname'];
    $edit_lname = $_POST['edit_lname'];
    $edit_age = $_POST['edit_age'];

    $edit_pass = password_hash($edit_pass, PASSWORD_DEFAULT);

    require_once 'connect.php';

    $sql = "INSERT INTO signup (edit_username, edit_pass, edit_email, edit_fname, edit_lname, edit_age) VALUES ('$edit_username', '$edit_pass', '$edit_email', '$edit_fname', '$edit_lname', '$edit_age')";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>