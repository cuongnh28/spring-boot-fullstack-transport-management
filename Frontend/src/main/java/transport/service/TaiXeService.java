package transport.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import transport.model.DoanhThuXeKhach;
import transport.model.TaiXe;

import java.sql.Date;
import java.util.List;

@Service
public class TaiXeService {
    public static final String REST_SERVICE_URI = "http://localhost:8080/taiXe/";
    RestTemplate restTemplate = new RestTemplate();

    //Get
    public TaiXe getTaiXeById(Long id){
//        System.out.println("Tets API get theo ID");
        TaiXe taiXe = restTemplate.getForObject(REST_SERVICE_URI + id, TaiXe.class);
        return taiXe;
    }

    //Get
    public List<TaiXe> getAllTaiXe(){
//        System.out.println("Test API lay toan bo tai xe.");
        List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return listTaiXe;
    }

    //Get
    public List<TaiXe> getTaiXeByKeyword(String keyword){
//        System.out.println("Test API tim kiem tai xe.");
        List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI + "search/" + keyword, List.class);
        return listTaiXe;
    }

    //Post
    public void createTaiXe(TaiXe taiXe){
//        System.out.println("Test API them tai xe.");
        restTemplate.postForObject(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
    }

    //Put
    public void updateTaiXe(TaiXe taiXe, Long id){
//        System.out.println("Test API sua tai xe.");
//        taiXe.setTaiXeId(id);
        restTemplate.put(REST_SERVICE_URI+"update/"+id, taiXe, TaiXe.class);
//        System.out.println(taiXe);
    }

    //Delete
    public void deleteTaiXe(Long id){
        restTemplate.delete(REST_SERVICE_URI+"delete/"+id);
    }
    public HttpStatus testTaiXe(TaiXe taiXe) {
//		System.out.println("Test API them tai xe.");
//		System.out.println(REST_SERVICE_URI);
//		ResponseEntity<TaiXe> response = restTemplate.getForEntity(REST_SERVICE_URI + "store", TaiXe.class, 1 );
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TaiXe> requestEntity = new HttpEntity<>(taiXe, headers);
		ResponseEntity<TaiXe> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "create", taiXe, TaiXe.class);
//		if (response.getStatusCode() == HttpStatus.OK) {
			// restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
//		System.out.println(responseEntity.getStatusCode());
			return responseEntity.getStatusCode();
//		} else {
//			return 0;
//		}
	}
    //Salary
//    public List<TaiXe> getSalaryTaiXe() {
//		System.out.println("Test API lay toan bo luong tai xe.");
//		List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI+"salary", List.class);
//		return listTaiXe;
//	}
    public List<TaiXe> getSalaryTaiXe(Date startDate, Date endDate){
    	List<TaiXe> listTaiXe = restTemplate.getForObject(REST_SERVICE_URI + "salary/" + startDate + "/" + endDate , List.class);
        return listTaiXe;
    }
    public HttpStatus testUpdateTaiXe(TaiXe taiXe) {
//		System.out.println("Test API them tai xe.");
//		System.out.println(REST_SERVICE_URI);
//		ResponseEntity<TaiXe> response = restTemplate.getForEntity(REST_SERVICE_URI + "store", TaiXe.class, 1 );
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TaiXe> requestEntity = new HttpEntity<>(taiXe, headers);
		Long id = taiXe.getTaiXeId();
		ResponseEntity<TaiXe> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "update/"+id, taiXe, TaiXe.class);
//		if (response.getStatusCode() == HttpStatus.OK) {
			// restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
//		System.out.println(responseEntity.getStatusCode());
        return responseEntity.getStatusCode();
//		} else {
//			return 0;
//		}
	}
}
