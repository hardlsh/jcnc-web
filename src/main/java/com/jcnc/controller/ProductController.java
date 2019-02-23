package com.jcnc.controller;

import com.jcnc.common.constant.Constants;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.common.enums.ProductTypeEnum;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 产品控制器类
 * @author shihao.li
 * @date 2019-1-6
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/toMainProduct")
    public ModelAndView toMainProduct() {
        ModelAndView mav = new ModelAndView("product/main/mainproducts");
        Product product = new Product();
        product.setProductType(ProductTypeEnum.MAIN_PRODUCT.getKey());
        List<Product> productList = productService.queryProductList(product);

        Integer rowNum = getRowNum(productList);
        mav.addObject("rowNum", rowNum);
        mav.addObject("columnNum", Constants.COLUMN_NUM);
        mav.addObject("productList",productList);
        mav.addObject("jumpPath", "/product/toBaseMainProduct.do?productId=");
        return mav;
    }

    /**
     * 获取产品展示行数
     * @param productList
     * @return
     */
    private Integer getRowNum(List<Product> productList) {
        Integer rowNum;
        if (productList == null) {
            rowNum = 0;
        } else {
            if (productList.size() % Constants.COLUMN_NUM == 0) {
                rowNum = productList.size() / Constants.COLUMN_NUM;
            } else {
                rowNum = productList.size() / Constants.COLUMN_NUM + 1;
            }
        }
        return rowNum;
    }

    @RequestMapping("/toBaseMainProduct")
    public ModelAndView toBaseMainProduct(Long productId) {
        ModelAndView mav = new ModelAndView("product/main/basemainproduct");
        Product product = productService.getProductById(productId);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/toQualityProduct")
    public ModelAndView toQualityProduct() {
        ModelAndView mav = new ModelAndView("product/quality/qualityproducts");
        Product product = new Product();
        product.setProductType(ProductTypeEnum.QUALITY_PRODUCT.getKey());
        List<Product> productList = productService.queryProductList(product);

        Integer rowNum = getRowNum(productList);
        mav.addObject("rowNum", rowNum);
        mav.addObject("columnNum", Constants.COLUMN_NUM);
        mav.addObject("productList",productList);
        mav.addObject("jumpPath", "/product/toBaseQualityProduct.do?productId=");
        return mav;
    }

    @RequestMapping("/toBaseQualityProduct")
    public ModelAndView toBaseQualityProduct(Long productId) {
        ModelAndView mav = new ModelAndView("product/quality/basequalityproduct");
        Product product = productService.getProductById(productId);
        mav.addObject("product", product);
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
            String imagePath = Constants.MY_IMAGE_PATH;
            File fileMkdir = new File(imagePath);

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
    @RequestMapping("/toLoadPicture")
    @ResponseBody
    public String toLoadPicture(HttpServletRequest request,HttpServletResponse response){
        String imagePath = Constants.MY_IMAGE_PATH+"营业执照.jpg";
        FileInputStream in;
        try {

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

}
