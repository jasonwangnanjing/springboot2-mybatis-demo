package com.jw.controller;

import com.jw.model.Material;
import com.jw.model.User;
import com.jw.service.user.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/Material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @ResponseBody
    @PostMapping("/add")
    public int addMaterial(Material material){
        return materialService.createMaterial(material);
    }


    @ResponseBody
    @PostMapping("/getAll")
    public Material getMaterial(int id){
        return materialService.getMaterial(id);
    }

}
