package transport.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import transport.model.XeKhach;
import transport.service.XeKhachService;

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
    public String storeXeKhach(XeKhach xeKhach){
        xeKhachService.createXeKhach(xeKhach);
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
}
