package transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import transport.model.TaiXe;
import transport.service.TaiXeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TaiXeController {
    private TaiXeService taiXeService;
    @Autowired
    public TaiXeController(TaiXeService taiXeService){
        this.taiXeService = taiXeService;
    }

    //Lay toan bo tai xe.
    @RequestMapping(value = "/taixe", method = RequestMethod.GET)
    public ResponseEntity<List<TaiXe>> findAllTaiXe() {
        List<TaiXe> taiXes = taiXeService.getAllTaiXe();
        if (taiXes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(taiXes, HttpStatus.OK);
    }

    //Lay tai xe theo Id.
    @RequestMapping(value = "/taixe/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaiXe> getTaiXeById(@PathVariable("id") int id) {
        Optional<TaiXe> taiXe = taiXeService.getTaiXeById(id);
        if (!taiXe.isPresent()) {
            return new ResponseEntity<>(taiXe.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(taiXe.get(), HttpStatus.OK);
    }

    //Them tai xe.
    @RequestMapping(value = "/taixe", method = RequestMethod.POST)
    public ResponseEntity<TaiXe> createTaiXe(@RequestBody TaiXe taiXe, UriComponentsBuilder builder) {
        taiXeService.saveTaiXe(taiXe);
        return new ResponseEntity<>(taiXe, HttpStatus.CREATED);
    }

    //Sua tai xe.
    @RequestMapping(value = "/taixe/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TaiXe> updateTaiXe(@PathVariable("id") Integer id, @RequestBody TaiXe taiXe) {
        Optional<TaiXe> currentTaiXe = taiXeService.getTaiXeById(id);

        if (!currentTaiXe.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentTaiXe.get().setTen(taiXe.getTen());
        currentTaiXe.get().setCmt(taiXe.getCmt());
        currentTaiXe.get().setLoaiBang(taiXe.getLoaiBang());
        currentTaiXe.get().setMaSoBangLai(taiXe.getMaSoBangLai());
        currentTaiXe.get().setDiaChi(taiXe.getDiaChi());
        currentTaiXe.get().setNgaySinh(taiXe.getNgaySinh());
        currentTaiXe.get().setThamNien(taiXe.getThamNien());

        taiXeService.saveTaiXe(currentTaiXe.get());
        return new ResponseEntity<>(currentTaiXe.get(), HttpStatus.OK);
    }

    //Xoa tai xe theo id.
    @RequestMapping(value = "/taixe/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaiXe> deleteTaiXe(@PathVariable("id") int id) {
        Optional<TaiXe> taiXe = taiXeService.getTaiXeById(id);
        if (!taiXe.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        taiXeService.deleteTaiXe(taiXe.get().getTaiXeId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
