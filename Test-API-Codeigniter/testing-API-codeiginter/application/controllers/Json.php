<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Json extends CI_Controller
{
    
    function tampil(){
        $this->load->view('welcome_message');
    }
}
