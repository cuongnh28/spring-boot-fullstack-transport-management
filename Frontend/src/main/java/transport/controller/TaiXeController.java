package transport.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import transport.model.TaiXe;
import transport.service.TaiXeService;
@Slf4j
@Controller
@RequestMapping("/taiXe")
public class TaiXeController {

    TaiXeService taiXeService;
    @Autowired
    public TaiXeController(TaiXeService taiXeService){
        this.taiXeService = taiXeService;
    }

    @GetMapping("/{id}")
    public String getTaiXeById(@PathVariable("id") Long id, Model model){
        TaiXe taiXe = taiXeService.getTaiXeById(id);
        model.addAttribute("taiXe", taiXe);
        return "TaiXe/infoTaiXe";
    }

    @GetMapping
    public String getAllTaiXe(Model model, String keyword){
        //Neu khong co keyword thi hien thi toan bo, con neu co thi hien thi theo keyword.
        if(keyword != null){
            model.addAttribute("listTaiXe", taiXeService.getTaiXeByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }
        else{
            model.addAttribute("listTaiXe", taiXeService.getAllTaiXe());
        }
        return "TaiXe/listTaiXe";
    }

//    @GetMapping("/search/{keyword}")
//    public String getTaiXeByKeyword(@PathVariable("keyword") String keyword, Model model){
//        List<TaiXe> listTaiXe = taiXeService.getTaiXeByKeyword(keyword);
//        model.addAttribute("listTaiXe", listTaiXe);
//        return "TaiXe/listTaiXe";
//    }

    @GetMapping("/create")
    public String createTaiXe(){
        return "TaiXe/addTaiXe";
    }

    @PostMapping("/store")
    public String storeTaiXe(@Valid TaiXe taiXe,  Errors errors, BindingResult result, RedirectAttributes redirect){
//    	taiXeService.createTaiXe(taiXe);
    	System.out.println(taiXe.toString());
    	if (errors.hasErrors()) {
    		return "TaiXe/addTaiXe";
    		 } 
    	if (taiXeService.testTaiXe(taiXe)==HttpStatus.CREATED) {
    		redirect.addFlashAttribute("success", "Saved successfully!");
            return "redirect:/taiXe";
		}
    	
        redirect.addFlashAttribute("failed", "Vui lòng kiểm tra lại căn cước công dân và mã số bằng lái!");
		return "redirect:/taiXe/create";
    }

    @GetMapping("/edit/{id}")
    public String editTaiXe(@PathVariable("id") Long id, Model model){
        TaiXe taiXe = taiXeService.getTaiXeById(id);
        taiXe.setTaiXeId(id);
        model.addAttribute(taiXe);
        return "TaiXe/editTaiXe";
    }

    @PostMapping("/update/{id}")
    public String updateTaiXe(@PathVariable("id") Long id, TaiXe taiXe){
        taiXeService.updateTaiXe(taiXe, id);
        return "redirect:/taiXe/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaiXe(@PathVariable("id") Long id){
//        TaiXe taiXe = taiXeService.getTaiXeById(id);
        taiXeService.deleteTaiXe(id);
        return "redirect:/taiXe";
    }
    @GetMapping("/salary")
    public String salaryTaiXe(Model model) throws ParseException, IOException {
        List<TaiXe> listTaiXe = taiXeService.getSalaryTaiXe();
    	model.addAttribute("listTaiXe", listTaiXe );
        return "TaiXe/salaryTaiXe";
    }
}
