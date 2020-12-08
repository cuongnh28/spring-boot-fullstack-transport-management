package transport.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import transport.model.ChuyenXe;

import java.util.List;

@Service
public class ChuyenXeService {
    public static final String REST_SERVICE_URI = "http://localhost:8080/chuyenXe/";
    RestTemplate restTemplate = new RestTemplate();

    //Get
    public ChuyenXe getChuyenXeById(Long id){
        ChuyenXe chuyenXe = restTemplate.getForObject(REST_SERVICE_URI + id, ChuyenXe.class);
        return chuyenXe;
    }

    //GetAllChuyenXe.
    public List<ChuyenXe> getAllChuyenXe(){
        List<ChuyenXe> listChuyenXe = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return listChuyenXe;
    }

    //Post.
    public void creatChuyenXe(ChuyenXe chuyenXe){
        restTemplate.postForObject(REST_SERVICE_URI + "create", chuyenXe, ChuyenXe.class);
    }

    //put
    public void updateChuyenXe(ChuyenXe chuyenXe, Long id){
        chuyenXe.setChuyenXeId(id);
        restTemplate.put(REST_SERVICE_URI + "update/" +id, chuyenXe);
    }

    //Delete
    public void deleteChuyenXe(Long id){
        restTemplate.delete(REST_SERVICE_URI + "delete/" + id);
    }
}
