package transport.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import transport.model.TaiXe;
import java.util.List;

@Service
public class TaiXeService {
    public static final String REST_SERVICE_URI = "http://localhost:8080/taixe/";
    RestTemplate restTemplate = new RestTemplate();

    //Get
    public TaiXe getTaiXeById(int id){
        System.out.println("Tets API get theo ID");
        TaiXe taiXe = restTemplate.getForObject(REST_SERVICE_URI + id, TaiXe.class);
        return taiXe;
    }

    //Get
    public List<TaiXe> getAllTaiXe(){
        System.out.println("Test API lay toan bo tai xe.");
        List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return listTaiXe;
    }

    //Get
    public List<TaiXe> getTaiXeByKeyword(String keyword){
        System.out.println("Test API tim kiem tai xe.");
        List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI + "search/" + keyword, List.class);
        return listTaiXe;
    }

    //Post
    public void createTaiXe(TaiXe taiXe){
        System.out.println("Test API them tai xe.");
        restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
    }

    //Put
    public void updateTaiXe(TaiXe taiXe, int id){
        System.out.println("Test API sua tai xe.");
        taiXe.setTaiXeId(id);
        restTemplate.put(REST_SERVICE_URI+"update/"+id, taiXe);
        System.out.println(taiXe);
    }

    //Delete
    public void deleteTaiXe(TaiXe taiXe, int id){
        System.out.println("Test API xoa tai xe.");
        System.out.println(taiXe);
        restTemplate.delete(REST_SERVICE_URI+"delete/"+id);
    }
}
