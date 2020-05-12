package com.zsk.controller;

import com.zsk.bean.Date;
import com.zsk.service.ImpDateservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DateController {
    @Autowired
    private ImpDateservice dateservice;
    @GetMapping("/")
    public String list(Model model){
        List<Date> dates = dateservice.list();
        model.addAttribute("dates",dates);
        return "list";
    }
}
