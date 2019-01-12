package com.jcnc.controller;

import com.jcnc.common.util.PropertiesUtil;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import jdk.nashorn.internal.objects.Global;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * 产品控制器类
 * @author shihao.li
 * @date 2019-1-6
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @RequestMapping("/toMainProduct")
    public ModelAndView toMainProduct() {
        ModelAndView mav = new ModelAndView("product/main/mainproducts");
        return mav;
    }

    @RequestMapping("/toBaseMainProduct")
    public ModelAndView toBaseMainProduct() {
        ModelAndView mav = new ModelAndView("product/main/basemainproduct");
        return mav;
    }

    @RequestMapping("/toFileUpload")
    public ModelAndView toFileUpload() {
        ModelAndView mav = new ModelAndView("product/main/fileupload");
        return mav;
    }


    @RequestMapping(value="/uploadPicture")
    @ResponseBody
    public Object uploadPicture(@RequestParam(value = "multipartFile", required = false) MultipartFile file,
                                HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = file.getOriginalFilename();

        try {
            File fileMkdir = new File("E:\\photoTest");

            if (!fileMkdir.exists()) {
                fileMkdir.mkdir();
            }
            //定义输出流 将文件保存在E盘
            FileOutputStream out = new FileOutputStream(fileMkdir.getPath()+"\\"+fileName);
            // 写入文件
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            return new JCResponse(RetCode.FAILURE);
        }
        return new JCResponse(RetCode.SUCCESS);
    }

    //根据请求的路径中的参数id,从本地磁盘中读取图片，picUrl是从配置文件中读取出来的
    @RequestMapping("/tofindPic")
    @ResponseBody
    public String tofindPic(HttpServletRequest request,HttpServletResponse response){
        String fileName = "product.properties";
        String key = "product.imagePath";

        String imagePath = getProductString(fileName, key)+"营业执照.jpg";
        FileInputStream in;
        try {
            //图片读取路径

            in = new FileInputStream(imagePath);
            //写图片
            OutputStream outputStream = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }
            in.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    public static String getProductString(String fileName, String key) {
        return PropertiesUtil.getPropertiesValue(fileName, key);
    }
}
