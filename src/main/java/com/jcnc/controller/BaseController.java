package com.jcnc.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基础控制器类
 * @author shihao.li
 * @date 2019-2-17
 */
public abstract class BaseController {

    /**
     * 输出Json串到前端
     *
     * @param content Json串内容
     */
    public void actionResult4Json(String content, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
