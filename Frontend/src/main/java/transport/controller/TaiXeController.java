package transport.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Date;
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

import transport.model.DoanhThuXeKhach;
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
    public String createTaiXe(Model model){
        model.addAttribute("taiXe", new TaiXe());
        return "TaiXe/addTaiXe";
    }

    @PostMapping("/store")
    public String storeTaiXe(@Valid TaiXe taiXe,  BindingResult result, RedirectAttributes redirect){
//    	taiXeService.createTaiXe(taiXe);
//    	System.out.println(taiXe.toString());
    	if (result.hasErrors()) {
    		return "redirect:/taiXe/create";
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
    @GetMapping("/salaryDate")
    public String salaryDate(){
        return "TaiXe/salaryDate";
    }

//    //Tinh doanh thu.
//    @GetMapping("/tinhDoanhThu")
//    public String getDoanhThuXeKhach(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate, Model model){
//        List<DoanhThuXeKhach> doanhThuXeKhachs = xeKhachService.getDoanhThu(startDate, endDate);
//        model.addAttribute("doanhThuXeKhachs", doanhThuXeKhachs);
//        return "XeKhach/tinhDoanhThu";
//    }
    @GetMapping("/salary")
    public String salaryTaiXe(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate, Model model) throws ParseException, IOException {
        List<TaiXe> listTaiXe = taiXeService.getSalaryTaiXe(startDate, endDate);
    	model.addAttribute("listTaiXe", listTaiXe );
        return "TaiXe/salaryTaiXe";
    }
}
