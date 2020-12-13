package transport.service;

import org.springframework.http.*;
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
    public HttpStatus testChuyenXe(ChuyenXe chuyenXe) {
		System.out.println("Test API them chuyen xe.");
		System.out.println(REST_SERVICE_URI);
//		ResponseEntity<TaiXe> response = restTemplate.getForEntity(REST_SERVICE_URI + "store", TaiXe.class, 1 );
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ChuyenXe> requestEntity = new HttpEntity<>(chuyenXe, headers);
		ResponseEntity<ChuyenXe> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "create", chuyenXe, ChuyenXe.class);;
//		if (response.getStatusCode() == HttpStatus.OK) {
			// restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
		System.out.println(responseEntity.getStatusCode());
			return responseEntity.getStatusCode();
//		} else {
//			return 0;
//		}
	}
    public HttpStatus testUpdateChuyenXe(ChuyenXe chuyenXe) {
        System.out.println("Test API them chuyen xe.");
        System.out.println(REST_SERVICE_URI);
//		ResponseEntity<TaiXe> response = restTemplate.getForEntity(REST_SERVICE_URI + "store", TaiXe.class, 1 );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ChuyenXe> requestEntity = new HttpEntity<>(chuyenXe, headers);
        Long id = chuyenXe.getChuyenXeId();
        ResponseEntity<ChuyenXe> responseEntity = restTemplate.exchange(REST_SERVICE_URI + "update/" + id, HttpMethod.PUT, requestEntity, ChuyenXe.class);
//		if (response.getStatusCode() == HttpStatus.OK) {
        // restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getStatusCode();
//		} else {
//			return 0;
//		}
    }
}
