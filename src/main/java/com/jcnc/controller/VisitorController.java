package com.jcnc.controller;

import com.jcnc.common.param.VisitorParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 访客控制器类
 * @author shihao.li
 * @date 2018-12-24
 */
@Controller
@RequestMapping("visitor")
public class VisitorController {

    @RequestMapping("/saveMessage")
    @ResponseBody
    public Object saveMessage (VisitorParam param) {
        return null;
    }
}
