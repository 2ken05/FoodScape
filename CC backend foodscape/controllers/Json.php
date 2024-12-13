<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Json extends CI_Controller
{
            
        function qna_json() {
            $this->load->model('Json_model', NULL);
            $data['data'] = array();
            $rest = $this->Json_model->tmpil()->result();
            foreach ($rest as $value) {
            $json = array();
            $json['id'] = $value->id;
            $json['pertanyaan'] = $value->pertanyaan;
            
            
            array_push($data['data'], $json);
            }
            print json_encode($data);
            
}
 function get_all() {
                $this->load->model('Json_model', NULL);
                $data['data'] = array();
                $rest = $this->Json_model->getall()->result();
                foreach ($rest as $value) {
                $json = array();
                $json['Nama_Tempat'] = $value->Nama_Tempat;
                $json['Kategori_Tempat'] = $value->Kategori_Tempat;
                $json['Kategori_Makanan'] = $value->Kategori_Makanan;
                $json['Alamat'] = $value->Alamat;
                $json['Review'] = $value->Review;
                
                
                array_push($data['data'], $json);
                }
                print json_encode($data);
                }

function getcat()  {
            $Kategori_Tempat= $this->input->get('Kategori_Tempat');
            
            //loadmodel
            $this->load->model('Json_model',NULL);
            $data['data']=array();
            $rest= $this->Json_model->get_cat($Kategori_Tempat)->result();
            foreach ($rest as $value){
            $json=array();
            $json['Nama_Tempat'] = $value->Nama_Tempat;
                $json['Kategori_Tempat'] = $value->Kategori_Tempat;
                $json['Kategori_Makanan'] = $value->Kategori_Makanan;
                $json['Alamat'] = $value->Alamat;
                $json['Review'] = $value->Review;
           
            array_push($data['data'], $json);
            }
            print json_encode($data);
            
        }
function getall_cat() {
$Kategori_Tempat= $this->input->get('Kategori_Tempat');
$Kategori_Makanan= $this->input->get('Kategori_Makanan');
$Review= $this->input->get('Review');
//loadmodel
$this->load->model('Json_model',NULL);
$data['data']=array();
$rest= $this->Json_model->get_cat_all($Kategori_Tempat,$Kategori_Makanan,$Review)->result();
foreach ($rest as $value){
$json=array();
$json['Nama_Tempat'] = $value->Nama_Tempat;
$json['Kategori_Tempat'] = $value->Kategori_Tempat;
$json['Kategori_Makanan'] = $value->Kategori_Makanan;
$json['Alamat'] = $value->Alamat;
$json['Review'] = $value->Review;

array_push($data['data'],$json);
}
print json_encode($data);
}
}
