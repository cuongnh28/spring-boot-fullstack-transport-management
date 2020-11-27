package transport.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import transport.model.TuyenXe;

import java.util.List;

@Service
public class TuyenXeService {
    RestTemplate restTemplate = new RestTemplate();
    private String REST_SERVICE_URI = "http://localhost:8080/tuyenXe/";

    //Get
    public TuyenXe getTuyenXeById(int id){
        TuyenXe tuyenXe = restTemplate.getForObject(REST_SERVICE_URI + id, TuyenXe.class);
        return tuyenXe;
    }

    //Get
    public List<TuyenXe> getAllTuyenXe(){
        List<TuyenXe> listTuyenXe = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return  listTuyenXe;
    }

    //Get tuyen xe theo diem dau hoac diem cuoi.
    public List<TuyenXe> getTuyenXeByKeyword(String keyword){
        List<TuyenXe> listTuyenXe = restTemplate.getForObject(REST_SERVICE_URI + "search/" + keyword, List.class);
        return  listTuyenXe;
    }

    //Post
    public void addTuyenXe(TuyenXe tuyenXe){
        restTemplate.postForObject(REST_SERVICE_URI + "create", tuyenXe, TuyenXe.class);
    }

    //Put
    public void updateTuyenXe(TuyenXe tuyenXe, int id){
        tuyenXe.setTuyenXeId(id);
        restTemplate.put(REST_SERVICE_URI + "update/" + id, tuyenXe);
    }

    //Delete
    public void deleteTuyenXe(int id){
        restTemplate.delete(REST_SERVICE_URI + "delete/" + id);
    }
}
