package com.jcnc.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.jcnc.common.constant.Constants;
import com.jcnc.common.param.UserParam;
import com.jcnc.common.util.CommonUtil;
import com.jcnc.common.util.EnumJsonConverter;
import com.jcnc.common.util.PaginationResult;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import com.jcnc.services.resource.enums.AvailStatusEnum;
import com.jcnc.services.resource.model.generated.Image;
import com.jcnc.services.resource.model.generated.Resource;
import com.jcnc.services.resource.service.ImageService;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.resource.vo.ResourceVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 资源控制类
 *
 * @author shihao.li
 * @date 2019-2-16
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ImageService imageService;

    private Gson gson = new Gson();

    /**
     * 跳转到用户管理页面
     * @return
     */
    @RequestMapping("/toUser")
    public ModelAndView toUser() {
        ModelAndView mav = new ModelAndView("system/user");
        return mav;
    }

    /**
     * 跳转到产品管理页面
     * @return
     */
    @RequestMapping("/toProduct")
    public ModelAndView toProduct() {
        ModelAndView mav = new ModelAndView("system/product/product");
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        return mav;
    }

    /**
     * 跳转到新增产品页面
     * @return
     */
    @RequestMapping("/toAddProduct")
    public ModelAndView toAddProduct() {
        ModelAndView mav = new ModelAndView("system/product/addProduct");
        return mav;
    }

    /**
     * 跳转到修改产品页面
     * @param productId
     * @return
     */
    @RequestMapping("/toUpdateProduct")
    public ModelAndView toUpdateProduct(Long productId) {
        ModelAndView mav = new ModelAndView("system/product/updateProduct");
        ProductModel productModel = productService.getProductById(productId);
        mav.addObject("product", productModel);
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        return mav;
    }

    /**
     * 跳转到资源管理页面
     * @return
     */
    @RequestMapping("/toResource")
    public ModelAndView toResource() {
        ModelAndView mav = new ModelAndView("system/resource");
        List<ResourceVo> voList = resourceService.queryPackageAllResources();
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        mav.addObject("nodes", gson.toJson(voList));
        return mav;
    }

    /**
     * 跳转到修改资源页面
     * @param resource
     * @return
     */
    @RequestMapping("/toUpdateResource")
    public ModelAndView toUpdateResource(Resource resource) {
        ModelAndView mav = new ModelAndView("system/updateResource");
        //根据资源id,获取对应的资源
        List<Resource> resourceList = resourceService.queryResourceByExample(resource);

        Long parentId = resourceList.get(0).getParentId();
        Resource parentResouce = new Resource();
        parentResouce.setResourceId(parentId);
        List<Resource> parentList = resourceService.queryResourceByExample(parentResouce);

        mav.addObject("resource", resourceList.get(0));
        if (parentList != null && parentList.size() == 1) {
            mav.addObject("parentResouce", parentList.get(0));
        } else {
            mav.addObject("parentResouce", resourceList.get(0));
        }
        return mav;
    }

    /**
     * 分页查询产品
     * @param response
     */
    @RequestMapping("/getProductList")
    public void getProductList(HttpServletResponse response) {
        try {
            PageInfo<ProductModel> pageInfo = productService.queryPageProduct();
            int total = (int) pageInfo.getTotal();
            PaginationResult<List<ProductModel>> result = PaginationResult.newInstance(pageInfo.getList());

            result.setiTotalRecords(total);
            result.setiTotalDisplayRecords(total);
            actionResult4Json(result.json(), response);
        } catch (Exception e) {
            logger.error("【用户管理】查询产品_异常,异常原因:", e);
        }
    }

    /**
     * 根据资源id,获取对应的资源
     * @param resource
     * @return
     */
    @RequestMapping("/getResourceById")
    @ResponseBody
    public Object getResourceById(Resource resource) {
        logger.info("【资源管理】根据资源id获取资源_开始,入参:" + gson.toJson(resource));
        JCResponse res;
        try {
            if (resource.getResourceId() == null) {
                return new JCResponse(RetCode.INVALID_ARGS);
            }
            //根据资源id,获取对应的资源
            List<Resource> resourceList = resourceService.queryResourceByExample(resource);
            res = new JCResponse(RetCode.SUCCESS);
            res.setData(resourceList.get(0));
        } catch (Exception e) {
            logger.error("【资源管理】根据资源id获取资源_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】根据资源id获取资源_结束");
        return res;
    }

    /**
     * 新增产品保存
     * @param product
     * @return
     */
    @RequestMapping("/addSaveProduct")
    @ResponseBody
    public Object addSaveProduct(Product product) {
        JCResponse res;
        try {
            productService.insertProduct(product);
            res = new JCResponse(RetCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【产品管理】新增产品保存_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【产品管理】新增产品保存_结束");
        return res;
    }

    /**
     * 修改产品保存
     * @param product
     * @return
     */
    @RequestMapping("/updateSaveProduct")
    @ResponseBody
    public Object updateSaveProduct(Product product) {
        JCResponse res;
        try {
            productService.updateProductById(product);
            res = new JCResponse(RetCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【产品管理】修改产品保存_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【产品管理】修改产品保存_结束");
        return res;
    }

    /**
     * 根据资源id,修改对应的资源
     */
    @RequestMapping("/updateResource")
    @ResponseBody
    public Object updateResource(Resource resource) {
        logger.info("【资源管理】修改资源_开始,入参:" + gson.toJson(resource));
        JCResponse res;
        try {
            if (StringUtils.isEmpty(resource.getResourceName()) || resource.getResourceType() == null) {
                return new JCResponse(RetCode.INVALID_ARGS);
            }
//            int result = resourceService.updateResourceById(resource);
//            logger.info("【资源管理】修改资源,修改条数:" + result);
            res = new JCResponse(RetCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【资源管理】修改资源_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】修改资源_结束");
        return res;
    }

    /**
     * 上传产品图片
     * @param file
     * @return
     */
    @RequestMapping(value="/upImg")
    @ResponseBody
    public Object upImg(@RequestParam(value = "multipartFile", required = false) MultipartFile file,
                        HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        Long productId = Long.valueOf(request.getParameter("productId"));
        try {
            Image image = new Image();
            image.setImageName(fileName);
            image.setSize(CommonUtil.getFileSize(file.getSize()));
            image.setImage(file.getBytes());
            image.setStatus(AvailStatusEnum.AVAILABLE.getKey());
            Product product = new Product();
            product.setProductId(productId);
            product.setImageName(fileName);
            productService.updateImageBusiness(product, image);
            logger.info("【资源管理】上传图片_完成,图片名:" + fileName);
        } catch (Exception e) {
            logger.error("【资源管理】上传图片_错误,", e);
            return new JCResponse(RetCode.FAILURE);
        }
        return new JCResponse(RetCode.SUCCESS);
    }
}
