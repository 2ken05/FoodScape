<?php

class Json_model extends CI_Model
{  
                    
    function tmpil() {
        $datam = $this->db->query("select * from qna");
        return$datam;}
     function getall() {
            $lvl = $this->db->query("select * from foods");
            return$lvl;}    
    function get_cat($Kategori_Tempat) {
            $query = $this->db->query("select * from foods where Kategori_Tempat LIKE '%$Kategori_Tempat%'");
            return$query;
    }

    }
