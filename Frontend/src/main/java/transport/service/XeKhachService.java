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
import transport.model.TuyenXe;
import transport.model.XeKhach;

import java.sql.Date;
import java.util.List;

@Service
public class XeKhachService {
    public static final String REST_SERVICE_URI = "http://localhost:8080/xeKhach/";
    RestTemplate restTemplate = new RestTemplate();

    //Get
    public XeKhach getXeKhachById(Long id){
        XeKhach xeKhach = restTemplate.getForObject(REST_SERVICE_URI + id, XeKhach.class);
        return xeKhach;
    }

    //Get
    public List<XeKhach> getAllXeKhach(){
        List<XeKhach> listXeKhach = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        return listXeKhach;
    }

    //Get
    public List<XeKhach> getXeKhachByKeyword(String keyword){
        List<XeKhach> listXeKhach = restTemplate.getForObject(REST_SERVICE_URI + "search/" + keyword, List.class);
        return listXeKhach;
    }

    //Post
    public void createXeKhach(XeKhach xeKhach){
        restTemplate.postForLocation(REST_SERVICE_URI+"create", xeKhach, XeKhach.class);
    }

    //Put
    public void updateXeKhach(XeKhach xeKhach, Long id){
        xeKhach.setXeKhachId(id);
        restTemplate.put(REST_SERVICE_URI+"update/"+id, xeKhach);
//        System.out.println(xeKhach);
    }

    //Delete
    public void deleteXeKhach(Long id){
        restTemplate.delete(REST_SERVICE_URI+"delete/"+id);
    }

    //Tinh doanh thu xe khach tu ngay A den ngay B.
    public List<DoanhThuXeKhach> getDoanhThu(Date startDate, Date endDate){
        List<DoanhThuXeKhach> doanhThuXeKhachs = restTemplate.getForObject(REST_SERVICE_URI + "doanhThu/" + startDate + "/" + endDate , List.class);
        return doanhThuXeKhachs;
    }
    public HttpStatus testXeKhach(XeKhach xeKhach) {

		System.out.println(REST_SERVICE_URI);
//		ResponseEntity<TaiXe> response = restTemplate.getForEntity(REST_SERVICE_URI + "store", TaiXe.class, 1 );
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<XeKhach> requestEntity = new HttpEntity<>(xeKhach, headers);
		ResponseEntity<XeKhach> responseEntity = restTemplate.postForEntity(REST_SERVICE_URI + "create", xeKhach, XeKhach.class);
//		if (response.getStatusCode() == HttpStatus.OK) {
			// restTemplate.postForLocation(REST_SERVICE_URI+"create", taiXe, TaiXe.class);
		System.out.println(responseEntity.getStatusCode());
			return responseEntity.getStatusCode();
//		} else {
//			return 0;
//		}
	}
}
