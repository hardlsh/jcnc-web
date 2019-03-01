package com.jcnc.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.jcnc.common.constant.Constants;
import com.jcnc.common.enums.AvailStatusEnum;
import com.jcnc.common.enums.ResourceLevelEnum;
import com.jcnc.common.enums.ResourceTypeEnum;
import com.jcnc.common.param.UserParam;
import com.jcnc.common.util.CommonUtil;
import com.jcnc.common.util.EnumJsonConverter;
import com.jcnc.common.util.PaginationResult;
import com.jcnc.common.vo.JCResponse;
import com.jcnc.common.vo.RetCode;
import com.jcnc.services.product.model.customized.ProductModel;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
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
import java.io.IOException;
import java.util.List;

/**
 * 用户资源控制类
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
    private ImageService imageService;
    @Autowired
    private ResourceService resourceService;

    private Gson gson = new Gson();

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
        Product product = productService.getProductById(productId);
        mav.addObject("product", product);
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        return mav;
    }

    /**
     * 跳转到资源管理页面
     * @return
     */
    @RequestMapping("/toResource")
    public ModelAndView toResource() {
        ModelAndView mav = new ModelAndView("system/resource/resource");
        List<ResourceVo> voList = resourceService.queryPackageAllResources();
        mav.addObject("resourceTypeEnum", EnumJsonConverter.buildEnumJson(ResourceTypeEnum.class));
        mav.addObject("resourceLevelEnum", EnumJsonConverter.buildEnumJson(ResourceLevelEnum.class));
        mav.addObject("availStatusEnum", EnumJsonConverter.buildEnumJson(AvailStatusEnum.class));
        mav.addObject("nodes", gson.toJson(voList));
        return mav;
    }

    /**
     * 跳转到新增资源页面
     * @param resourceId
     * @return
     */
    @RequestMapping("/toAddResource")
    public ModelAndView toAddResource(Long resourceId) {
        ModelAndView mav = new ModelAndView("system/resource/addResource");
        Resource resource = resourceService.getResourceById(resourceId);
        resource.setLevel(resource.getLevel() + 1);
        mav.addObject("resource", resource);
        return mav;
    }

    /**
     * 跳转到修改资源页面
     * @param record
     * @return
     */
    @RequestMapping("/toUpdateResource")
    public ModelAndView toUpdateResource(Resource record) {
        ModelAndView mav = new ModelAndView("system/resource/updateResource");
        //根据资源id,获取对应的资源
        Resource resource = resourceService.getResourceById(record.getResourceId());
        Resource parentResource = resourceService.getResourceById(resource.getParentId());
        mav.addObject("resource", resource);
        if (parentResource != null) {
            mav.addObject("parentResouce", parentResource);
        } else {
            mav.addObject("parentResouce", resource);
        }
        return mav;
    }

    /**
     * 分页查询产品
     * @param response
     * @param param
     */
    @RequestMapping("/getProductList")
    public void getProductList(HttpServletResponse response, UserParam param) {
        try {
            PageInfo<ProductModel> pageInfo = productService.queryPageProductByParam(param);
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
     * 根据资源级别,获取对应的可用资源
     * @param resource
     */
    @RequestMapping("/getResourceByLevel")
    @ResponseBody
    public Object getResourceByLevel(Resource resource) {
        logger.info("【资源管理】根据资源级别获取资源_开始,入参:" + gson.toJson(resource));
        JCResponse res;
        try {
            if (resource.getLevel() == null) {
                return new JCResponse(RetCode.INVALID_ARGS);
            }
            resource.setStatus(AvailStatusEnum.AVAILABLE.getKey());
            if (resource.getLevel() > 0) {
                resource.setLevel(resource.getLevel() - 1);
            }
            List<Resource> resourceList = resourceService.queryResourceByExample(resource);
            res = new JCResponse(RetCode.SUCCESS);
            res.setData(resourceList);
        } catch (Exception e) {
            logger.error("【资源管理】根据资源级别获取资源_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】根据资源级别获取资源_结束");
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
            Product record = productService.getProductByName(product.getProductName());
            if (record != null) {
                res = new JCResponse(RetCode.FAILURE);
                res.setResultMsg("产品名称重复");
                logger.info("【产品管理】新增产品保存_失败,产品名称重复");
                return res;
            }
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
     * 新增资源保存
     * @param resource
     * @return
     */
    @RequestMapping("/addSaveResource")
    @ResponseBody
    public Object addSaveResource(Resource resource) {
        JCResponse res;
        try {
            Resource record = resourceService.getResourceByName(resource.getResourceName());
            if (record != null) {
                res = new JCResponse(RetCode.FAILURE);
                res.setResultMsg("资源名称重复");
                logger.info("【资源管理】新增资源保存_失败,资源名称重复");
                return res;
            }
            resource.setResourceType(ResourceTypeEnum.MENU.getKey());
            resourceService.insertResourceBusiness(resource);
            res = new JCResponse(RetCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【资源管理】新增资源保存_异常,异常原因:", e);
            res = new JCResponse(RetCode.FAILURE);
        }
        logger.info("【资源管理】新增资源保存_结束");
        return res;
    }

    /**
     * 修改资源保存
     * @param resource
     * @return
     */
    @RequestMapping("/updateSaveResource")
    @ResponseBody
    public Object updateSaveResource(Resource resource) {
        JCResponse res;
        try {
            resourceService.updateResourceBusiness(resource);
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
        String filename = file.getOriginalFilename();
        Double fileSize = CommonUtil.getFileSize(file.getSize());
        Long productId = Long.valueOf(request.getParameter("productId"));
        // 覆盖标识
        Boolean coverFlag = Boolean.valueOf(request.getParameter("coverFlag"));
        Integer type = Integer.valueOf(request.getParameter("type"));
        try {
            Image image = imageService.queryImageByName(filename);
            if (image != null && coverFlag.equals(false)) {
                if (image.getImageName().equals(filename) && image.getSize().equals(fileSize)) {
                    logger.info("【资源管理】上传图片相同_待确认,图片名:" + filename);
                    return new JCResponse(RetCode.IMG_SAME);
                } else if (image.getImageName().equals(filename)) {
                    logger.info("【资源管理】上传图片重名_待确认,图片名:" + filename);
                    return new JCResponse(RetCode.IMG_DUPLICATE_NAME);
                }
            }
            productService.updateImageBusiness(file, filename, fileSize, productId, type);
            logger.info("【资源管理】上传图片_完成,图片名:" + filename);
        } catch (Exception e) {
            logger.error("【资源管理】上传图片_错误,", e);
            return new JCResponse(RetCode.FAILURE);
        }
        return new JCResponse(RetCode.SUCCESS);
    }
}
