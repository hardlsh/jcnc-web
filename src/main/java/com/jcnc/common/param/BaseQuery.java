package com.jcnc.common.param;

import java.io.Serializable;

/**
 * 基础查询类
 * @author shihao.li
 * @date 2019-2-17
 */
public class BaseQuery implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer start;

    private Integer length;

    private String orderBy;
    
    private String dir;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
}
