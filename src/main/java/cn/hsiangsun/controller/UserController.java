package cn.hsiangsun.controller;


import cn.hsiangsun.domain.SysUser;
import cn.hsiangsun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/allInfo")
    public ModelAndView findAllInfo(ModelAndView modelAndView){
        List<SysUser> user = mapper.findAllUser();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
