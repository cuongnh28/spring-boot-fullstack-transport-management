package transport.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import transport.model.TaiXe;
import transport.service.TaiXeService;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/taixe")
public class TaiXeController {
    @Autowired
    TaiXeService taiXeService;

    @GetMapping("/{id}")
    public String getTaiXeById(@PathVariable("id") int id, Model model){
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

    @PostMapping("/create")
    public String createTaiXe(TaiXe taiXe, Model model){
        taiXeService.createTaiXe(taiXe);
        return "redirect:/taixe";
    }

    @GetMapping("update/{id}")
    public String editTaiXe(@PathVariable("id") int id, Model model){
        TaiXe taiXe = taiXeService.getTaiXeById(id);
        taiXe.setTaiXeId(id);
        model.addAttribute(taiXe);
        return "TaiXe/editTaiXe";
    }

    @PostMapping("update/{id}")
    public String updateTaiXe(@PathVariable("id") int id, TaiXe taiXe, Model model){
        taiXeService.updateTaiXe(taiXe, id);
        return "redirect:/taixe/{id}";
    }

    @GetMapping("delete/{id}")
    public String deleteTaiXe(@PathVariable("id") int id){
        TaiXe taiXe = taiXeService.getTaiXeById(id);
        taiXeService.deleteTaiXe(taiXe, id);
        return "redirect:/taixe";
    }
}
