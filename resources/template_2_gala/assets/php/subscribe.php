<?php

// User Changeable Option
$apiKey = '4e38ca9afcf9b1a00f223f108f16925c-us19';

// Replace Your List ID
$listId = '39379';

$double_optin=false;

$send_welcome=false;

$email_type = 'html';

$email = $_POST['newsletter_email'];

//Replace us19 with your actual datacenter
$submit_url = "https://us19.api.mailchimp.com/3.0/?method=listSubscribe";




$data = array(
    'email_address'=>$email,
    'apikey'=>$apiKey,
    'id' => $listId,
    'double_optin' => $double_optin,
    'send_welcome' => $send_welcome,
    'email_type' => $email_type
);
$payload = json_encode($data);
 
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $submit_url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, urlencode($payload));
 
$result = curl_exec($ch);
curl_close ($ch);
$data = json_decode($result);
if ($data->error){
    echo $data->error;
} else {
    echo "Got it, you've been added to our email list.";
}
