package com.jw.controller;

import com.jw.model.Material;
import com.jw.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/Material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @ResponseBody
    @PostMapping("/add")
    public int add(@RequestBody Material material) {
        return materialService.createMaterial(material);
    }


    @ResponseBody
    @RequestMapping("/get")
    public Material get(@RequestParam(name = "materialID", required = true, defaultValue = "1")
                                int id) {
        return materialService.getMaterial(id);
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public int delete(@RequestParam(name = "materialID", required = true, defaultValue = "1") int id) {

        return materialService.deleteMaterial(id);
    }


    @ResponseBody
    @PostMapping("/update")
    public int change(@RequestBody Material material) {
        return materialService.updateMaterial(material);
    }
}
