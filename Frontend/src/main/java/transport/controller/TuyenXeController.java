package transport.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String getTuyenXeById(@PathVariable ("id") Long id, Model model){
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
    public String storeTuyenXe(TuyenXe tuyenXe, BindingResult result, RedirectAttributes redirect){
    	if (tuyenXeService.testTuyenXe(tuyenXe)==HttpStatus.CREATED) {
    		redirect.addFlashAttribute("success", "Saved successfully!");
    		return "redirect:/tuyenXe";
		}
    	
        redirect.addFlashAttribute("Vui lòng điền đầy đủ thông tin");
		return "redirect:/tuyenXe/create";
    	
        
    }

    @GetMapping("/edit/{id}")
    public String editTuyenXe(@PathVariable ("id") Long id, Model model){
        TuyenXe tuyenXe = tuyenXeService.getTuyenXeById(id);
        model.addAttribute("tuyenXe", tuyenXe);
        return "TuyenXe/editTuyenXe";
    }

    @PostMapping("/update/{id}")
    public String updateTuyenXe(@PathVariable ("id") Long id, TuyenXe tuyenXe){
        tuyenXeService.updateTuyenXe(tuyenXe, id);
        return "redirect:/tuyenXe/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteTuyenXe(@PathVariable ("id") Long id){
        tuyenXeService.deleteTuyenXe(id);
        return "redirect:/tuyenXe";
    }

}
