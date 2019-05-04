package com.jw.controller;

import com.jw.model.SysUser;
import com.jw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @PostMapping("/add")
    @PreAuthorize( "hasRole('ADMIN')" )
    public int addUser(@RequestBody SysUser sysUser){
        return sysUserService.addUser(sysUser);
    }

    @ResponseBody
    @PostMapping("/update")
    public int updateUser(@RequestBody SysUser sysUser){
        return sysUserService.updateUser(sysUser);
    }


    @ResponseBody
    @GetMapping("/all")
    @PreAuthorize( "hasRole('ADMIN')" )
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return sysUserService.findAllUser();
    }
}
