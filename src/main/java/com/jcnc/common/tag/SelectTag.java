package com.jcnc.common.tag;


import com.jcnc.common.util.SpringUtil;
import com.jcnc.services.resource.model.generated.DictItem;
import com.jcnc.services.resource.service.DictService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义字典下拉标签
 * @author shihao.li
 * @date 2019-2-26
 */
public class SelectTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String name;

    private String classes;

    private String style;
    
    private String multiple;

    private String value;
    
    private Set<String> multValues = new HashSet<String>();

    private String dictCode;

    private String hasAll;

    private String placeholder;

    private String onchange;

    @Override
    public int doStartTag() throws JspException {
        DictService dictService = (DictService) SpringUtil.getBean("dictServiceImpl");
        DictItem dictItem = new DictItem();
        dictItem.setDictCode(dictCode);
    	List<DictItem> dictList = dictService.queryDictItemList(dictItem);

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
        if (StringUtils.isNotBlank(style)) {
            sb.append(" style=\"" + style + "\"");
        }else{
            sb.append(" style=\"width: 100px;\"");
        }
        if (StringUtils.isNotBlank(multiple) && multiple.equalsIgnoreCase("true")) {
            sb.append(" multiple=\"multiple\" ");
        }
        if (StringUtils.isNotBlank(onchange)) {
            sb.append(" onchange=\"" + onchange + "\"");
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

        doSetValue(value);

        if (dictList != null && dictList.size() > 0) {
            for (DictItem item: dictList) {
                if (multValues.size() > 0
                        && multValues.contains(item.getItemCode())) {
                    sb.append("<option value=\"" + item.getItemCode()
                            + "\" selected=\"selected\" >" + item.getItemName()
                            + "</option>");
                } else {
                    sb.append("<option value=\"" + item.getItemCode() + "\">"
                            + item.getItemName() + "</option>");
                }
            }
        }
        sb.append(" </select>");

        try {
            pageContext.getOut().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public void setHasAll(String hasAll) {
        this.hasAll = hasAll;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        doSetValue(value);
    }

	private void doSetValue(String value) {
		// 处理多选值
        multValues.clear();
        if (StringUtils.isNotBlank(value)) {
        	String[] arrValue = value.split(",");
        	for(String item : arrValue) {
        		if(StringUtils.isNotBlank(item)){
        			multValues.add(item.trim());
        		}
        	}
        }
	}

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setStyle(String style) {
        this.style = style;
    }

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

    public String getOnchange() {
        return onchange;
    }

    public void setOnchange(String onchange) {
        this.onchange = onchange;
    }
}
