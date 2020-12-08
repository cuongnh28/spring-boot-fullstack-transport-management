package transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transport.model.XeKhach;
import transport.service.XeKhachService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class XeKhachController {
    private XeKhachService xeKhachService;
    @Autowired
    public XeKhachController(XeKhachService xeKhachService){
        this.xeKhachService = xeKhachService;
    }

    //lay toan bo xe khach.
    @RequestMapping(value = "/xeKhach", method = RequestMethod.GET)
    public ResponseEntity<List<XeKhach>> getAllXeKhach(){
        List<XeKhach> listXeKhach = xeKhachService.getAllXeKhach();
        if(listXeKhach.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(listXeKhach, HttpStatus.OK);
        }
    }

    //Lay xe khach theo id.
    @RequestMapping(value = "/xeKhach/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XeKhach> getXeKhachById(@PathVariable("id") Long id){
        Optional<XeKhach> xeKhach = xeKhachService.getXeKhachById(id);
        if(!xeKhach.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(xeKhach.get(), HttpStatus.OK);
        }
    }

    //Tim kiem thong tin theo bien so.
    @RequestMapping(value = "/xeKhach/search/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<XeKhach>> getXeKhachByKeyword(@PathVariable("keyword") String keyword){
        List<XeKhach> listXeKhach = xeKhachService.searchXeKhachByKeyword(keyword);
        if(listXeKhach.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(listXeKhach, HttpStatus.OK);
        }
    }

    //Them xe khach.
    @RequestMapping(value = "/xeKhach/create", method = RequestMethod.POST)
    public ResponseEntity<XeKhach> createXeKhach(@RequestBody XeKhach xeKhach){
        if(xeKhachService.checkTonTai(xeKhach.getBienSo())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            xeKhachService.saveXeKhach(xeKhach);
            return new ResponseEntity<>(xeKhach, HttpStatus.CREATED);
        }
    }

    //Sua xe khach.
    @RequestMapping(value = "/xeKhach/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<XeKhach> updateXeKhach(@RequestBody XeKhach xeKhach, @PathVariable("id") Long id){
        Optional<XeKhach> currentXeKhach = xeKhachService.getXeKhachById(id);
        if(!currentXeKhach.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            currentXeKhach.get().setBienSo(xeKhach.getBienSo());
            currentXeKhach.get().setDoiXe(xeKhach.getDoiXe());
            currentXeKhach.get().setHangSanXuat(xeKhach.getHangSanXuat());
            currentXeKhach.get().setMauXe(xeKhach.getMauXe());
            currentXeKhach.get().setModel(xeKhach.getModel());
            currentXeKhach.get().setNgayBaoDuong(xeKhach.getNgayBaoDuong());
            currentXeKhach.get().setSoGhe(xeKhach.getSoGhe());
            currentXeKhach.get().setSoNamSuDung(xeKhach.getSoNamSuDung());

            xeKhachService.saveXeKhach(currentXeKhach.get());
            return new ResponseEntity<>(currentXeKhach.get(), HttpStatus.OK);
        }
    }

    //Xoa xe khach theo id.
    @RequestMapping(value = "/xeKhach/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteXeKhach(@PathVariable("id") Long id){
        Optional<XeKhach> xeKhach = xeKhachService.getXeKhachById(id);
        if(!xeKhach.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            xeKhachService.deleteXeKhach(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
