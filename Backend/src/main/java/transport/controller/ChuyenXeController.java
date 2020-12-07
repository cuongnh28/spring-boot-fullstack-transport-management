package transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import transport.model.ChuyenXe;
import transport.service.ChuyenXeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ChuyenXeController {

    private ChuyenXeService chuyenXeService;
    @Autowired
    public ChuyenXeController(ChuyenXeService chuyenXeService){
        this.chuyenXeService = chuyenXeService;
    }

    //Lay toan bo danh sach chuyen xe.
    @RequestMapping(value = "/chuyenXe", method = RequestMethod.GET)
    public ResponseEntity<List<ChuyenXe>> getAllChuyenXe(){
        List<ChuyenXe> listChuyenXe = chuyenXeService.getAllChuyenXe();
        if(listChuyenXe.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(listChuyenXe, HttpStatus.OK);
        }
    }

    //Lay chuyen xe theo id.
    @RequestMapping(value = "/chuyenXe/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChuyenXe> getChuyenXeById(@PathVariable("id") int id){
        Optional<ChuyenXe> chuyenXe = chuyenXeService.getChuyenXeById(id);
        if(!chuyenXe.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(chuyenXe.get(), HttpStatus.OK);
        }
    }

    //Them chuyen xe.
    @RequestMapping(value = "/chuyenXe/create", method = RequestMethod.POST)
    public ResponseEntity<ChuyenXe> addChuyenXe(@RequestBody ChuyenXe chuyenXe, UriComponentsBuilder builder){
        //Kiem tra so khach < so ghe - 2. Va lai xe voi phu xe phai khac nhau
//        int soKhach = chuyenXe.getSoKhach();
//        int soGhe = chuyenXe.getSoGhe();
//        int taiXeId = chuyenXe.getLaiXeId();
//        int phuXeId = chuyenXe.getPhuXeId();
//        if(soKhach >= soGhe - 2 || taiXeId == phuXeId){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        else{
//            chuyenXeService.saveChuyenXe(chuyenXe);
//            return new ResponseEntity<>(chuyenXe, HttpStatus.OK);
//        }
        chuyenXeService.saveChuyenXe(chuyenXe);
        return new ResponseEntity<>(chuyenXe, HttpStatus.OK);
    }

    //Sua chuyen xe.
    @RequestMapping(value = "/chuyenXe/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ChuyenXe> updateChuyenXe(@PathVariable("id") int id, @RequestBody ChuyenXe chuyenXe){
        Optional<ChuyenXe> currentChuyenXe = chuyenXeService.getChuyenXeById(id);
        if(!currentChuyenXe.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            currentChuyenXe.get().setGiaVe(chuyenXe.getGiaVe());
            currentChuyenXe.get().setNgayDi(chuyenXe.getNgayDi());
            currentChuyenXe.get().setSoKhach(chuyenXe.getSoKhach());
//            currentChuyenXe.get().setLaiXe(chuyenXe.getLaiXe());
//            currentChuyenXe.get().setPhuXe(chuyenXe.getPhuXe());
//            currentChuyenXe.get().setTuyenXe(chuyenXe.getTuyenXe());
//            currentChuyenXe.get().setXeKhach(chuyenXe.getXeKhach());
//            currentChuyenXe.get().setLaiXeId(chuyenXe.getLaiXeId());
//            currentChuyenXe.get().setPhuXeId(chuyenXe.getPhuXeId());
//            currentChuyenXe.get().setXeKhachId(chuyenXe.getXeKhachId());
//            currentChuyenXe.get().setTuyenXeId(chuyenXe.getTuyenXeId());
//            chuyenXeService.saveChuyenXe(currentChuyenXe.get());
            return new ResponseEntity<>(currentChuyenXe.get(), HttpStatus.OK);
        }
    }

    //Xoa chuyen xe.
    @RequestMapping(value = "/chuyenXe/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteChuyenXe(@PathVariable ("id") int id){
        Optional<ChuyenXe> chuyenXe = chuyenXeService.getChuyenXeById(id);
        if(!chuyenXe.isPresent()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else{
            chuyenXeService.deleteChuyenXe(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
