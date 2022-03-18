package com.example.demo.web.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.IndexService;

/**
 * @auther suijinchi
 * @description 前端入口
 * @date 2022/3/17
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping(value = {"/", "/index", "index.htm", "/idnex.html"})
    public String indexManager(ModelMap model) {
        model.addAttribute("user", indexService.selectUser());
        return "index";
    }

}
