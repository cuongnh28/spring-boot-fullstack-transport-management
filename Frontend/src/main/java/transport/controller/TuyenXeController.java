package transport.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import transport.model.TuyenXe;
import transport.service.TuyenXeService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/tuyenXe")
public class TuyenXeController {
    TuyenXeService tuyenXeService;
    @Autowired
    public TuyenXeController(TuyenXeService tuyenXeService){
        this.tuyenXeService = tuyenXeService;
    }

    @GetMapping("/{id}")
    public String getTuyenXeById(@PathVariable ("id") int id, Model model){
        TuyenXe tuyenXe = tuyenXeService.getTuyenXeById(id);
        model.addAttribute("tuyenXe", tuyenXe);
        return "TuyenXe/infoTuyenXe";
    }

    @GetMapping
    public String getAllTuyenXe(Model model, String keyword){
        if(keyword == null){
            List<TuyenXe> listTuyenXe = tuyenXeService.getAllTuyenXe();
            model.addAttribute("listTuyenXe", listTuyenXe);
        }
        else{
            List<TuyenXe> listTuyenXe = tuyenXeService.getTuyenXeByKeyword(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("listTuyenXe", listTuyenXe);
        }
        return "TuyenXe/listTuyenXe";
    }

    @GetMapping("/create")
    public String createTuyenXe(){
        return "TuyenXe/addTuyenXe";
    }

    @PostMapping("/store")
    public String storeTuyenXe(TuyenXe tuyenXe, Model model){
        tuyenXeService.addTuyenXe(tuyenXe);
        return "redirect:/tuyenXe";
    }

    @GetMapping("/edit/{id}")
    public String editTuyenXe(@PathVariable ("id") int id, Model model){
        TuyenXe tuyenXe = tuyenXeService.getTuyenXeById(id);
        model.addAttribute("tuyenXe", tuyenXe);
        return "TuyenXe/editTuyenXe";
    }

    @PostMapping("/update/{id}")
    public String updateTuyenXe(@PathVariable ("id") int id, TuyenXe tuyenXe){
        tuyenXeService.updateTuyenXe(tuyenXe, id);
        return "redirect:/tuyenXe/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteTuyenXe(@PathVariable ("id") int id){
        tuyenXeService.deleteTuyenXe(id);
        return "redirect:/tuyenXe";
    }

}
