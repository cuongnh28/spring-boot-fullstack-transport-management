package transport.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import transport.model.DoanhThuXeKhach;
import transport.model.TaiXe;
import transport.model.XeKhach;
import transport.service.XeKhachService;

import java.sql.Date;
import java.util.List;

@Slf4j
@RequestMapping("/xeKhach")
@Controller
public class XeKhachController {

    XeKhachService xeKhachService;
    @Autowired
    public XeKhachController(XeKhachService xeKhachService){
        this.xeKhachService = xeKhachService;
    }

    @GetMapping("/{id}")
    public String getXeKhachById(@PathVariable("id") Long id, Model model){
        XeKhach xeKhach = xeKhachService.getXeKhachById(id);
        model.addAttribute("xeKhach", xeKhach);
        return "XeKhach/infoXeKhach";
    }

    @GetMapping
    public String getAllXeKhach(Model model, String keyword){
        //Neu khong co keyword thi hien thi toan bo, con neu co thi hien thi theo keyword.
        if(keyword != null){
            model.addAttribute("listXeKhach", xeKhachService.getXeKhachByKeyword(keyword));
            model.addAttribute("keyword", keyword);
        }
        else{
            model.addAttribute("listXeKhach", xeKhachService.getAllXeKhach());
        }
        return "XeKhach/listXeKhach";
    }

    @GetMapping("/create")
    public String createXeKhach(){
        return "XeKhach/addXeKhach";
    }

    @PostMapping("/store")
    public String storeXeKhach(XeKhach xeKhach, BindingResult result, RedirectAttributes redirect){

    	System.out.println(xeKhach.toString());
    	if (xeKhachService.testXeKhach(xeKhach)==HttpStatus.NO_CONTENT) {
    		redirect.addFlashAttribute("failed", "Biển số đã tồn tại. Vui lòng kiểm tra lại!");
    		return "redirect:/xeKhach/create";
		}
    	
        
		redirect.addFlashAttribute("success", "Saved successfully!");
        return "redirect:/xeKhach";
    }

    @GetMapping("/edit/{id}")
    public String editXeKhach(@PathVariable("id") Long id, Model model){
        XeKhach xeKhach = xeKhachService.getXeKhachById(id);
        xeKhach.setXeKhachId(id);
        model.addAttribute(xeKhach);
        return "XeKhach/editXeKhach";
    }

    @PostMapping("/update/{id}")
    public String updateXeKhach(@PathVariable("id") Long id, XeKhach xeKhach){
        xeKhachService.updateXeKhach(xeKhach, id);
        return "redirect:/xeKhach/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteXeKhach(@PathVariable("id") Long id){
        XeKhach xeKhach = xeKhachService.getXeKhachById(id);
        xeKhachService.deleteXeKhach(id);
        return "redirect:/xeKhach";
    }

    //Xuat man hinh nhap ngay bat dau va ket thuc de tinh doanh thu.

    @GetMapping("/doanhThu")
    public String doanhThu(){
        return "XeKhach/addDoanhThu";
    }

    //Tinh doanh thu.
    @GetMapping("/tinhDoanhThu")
    public String getDoanhThuXeKhach(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate, Model model){
        List<DoanhThuXeKhach> doanhThuXeKhachs = xeKhachService.getDoanhThu(startDate, endDate);
        model.addAttribute("doanhThuXeKhachs", doanhThuXeKhachs);
        return "XeKhach/tinhDoanhThu";
    }
}
