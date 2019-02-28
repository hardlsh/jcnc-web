package com.jcnc.common.tag;


import com.jcnc.common.util.SpringUtil;
import com.jcnc.services.product.model.generated.Product;
import com.jcnc.services.product.service.ProductService;
import com.jcnc.common.enums.AvailStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * 自定义产品多选标签
 * @author shihao.li
 * @date 2019-2-23
 */
@Service
public class ProductSelectTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String name;

    private String multiple;

    private String dataLiveSearch;

    private String classes;

    private String placeholder;

    private String value;

    private String style;

    private String hasAll;

    private String onchange;
    /**
     * 宽度类型
     * fit：根据内容自适应
     * auto:当前选定的选项的宽度
     * 100%：按照百分比
     * 100px：按照像素
     */
    private String dataWidth;

    @Override
    public int doStartTag() throws JspException {
        ProductService productService = (ProductService) SpringUtil.getBean("productServiceImpl");
        Product product = new Product();
        product.setStatus(AvailStatusEnum.AVAILABLE.getKey());
        List<Product> productList = productService.queryProductList(product);

        StringBuffer sb = new StringBuffer();
        sb.append("<select ");
        if (StringUtils.isNotBlank(id)) {
            sb.append(" id=\"" + id + "\"");
        }
        if (StringUtils.isNotBlank(name)) {
            sb.append(" name=\"" + name + "\"");
        }
        if (StringUtils.isNotBlank(classes)) {
            sb.append(" class=\"" + classes + "\"");
        }
        if (StringUtils.isNotBlank(placeholder)) {
            sb.append(" placeholder=\"" + placeholder + "\"");
        }
        if (StringUtils.isNotBlank(value)) {
            sb.append(" value=\"" + value + "\"");
        }
        if (StringUtils.isNotBlank(style)) {
            sb.append(" style=\"" + style + "\"");
        }
        if (StringUtils.isNotBlank(onchange)) {
            sb.append(" onchange=\"" + onchange + "\"");
        }
        if(StringUtils.isNotBlank(dataLiveSearch)){
            sb.append(" data-live-search=\""+dataLiveSearch+"\"");
        }
        if(StringUtils.isNotBlank(multiple)){
            sb.append(" multiple ");
        }
        if(StringUtils.isNotBlank(dataWidth)){
            sb.append(" data-width=\""+dataWidth+"\" ");
        }
        sb.append(" >");

        if (StringUtils.isNotBlank(placeholder)) {
            if (!(StringUtils.isNotBlank(hasAll) && hasAll.equals("false"))) {
                sb.append("<option value=\"\">" + placeholder + "</option>");
            }
        } else {
            if (!(StringUtils.isNotBlank(hasAll) && hasAll.equals("false"))) {
                sb.append("<option value=\"\">请选择</option>");
            }
        }
        if (productList != null && productList.size() > 0) {
            for (Product item : productList) {
                if (sb.indexOf(item.getProductName()) == -1) {
                    if (StringUtils.isNotBlank(value) && Long.valueOf(value).equals(item.getProductId())) {
                        sb.append("<option selected=\"selected\" value=\"" + item.getProductId()
                                + "\" data-tokens=\"" + item.getProductName() + "|"
                                + item.getProductId() + "\">" + item.getProductName() + "</option>");
                    } else {
                        sb.append("<option value=\"" + item.getProductId()
                                + "\" data-tokens=\"" + item.getProductName() + "|"
                                + item.getProductId() + "\">" + item.getProductName() + "</option>");
                    }
                }
            }
        }
        sb.append(" </select>");

        if (productList != null && productList.size() > 0) {
            for (Product item : productList) {

            }
        }

        try {
            pageContext.getOut().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getHasAll() {
        return hasAll;
    }

    public void setHasAll(String hasAll) {
        this.hasAll = hasAll;
    }

    public String getOnchange() {
        return onchange;
    }

    public void setOnchange(String onchange) {
        this.onchange = onchange;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getDataLiveSearch() {
        return dataLiveSearch;
    }

    public void setDataLiveSearch(String dataLiveSearch) {
        this.dataLiveSearch = dataLiveSearch;
    }

    public String getDataWidth() {
        return dataWidth;
    }

    public void setDataWidth(String dataWidth) {
        this.dataWidth = dataWidth;
    }
}
