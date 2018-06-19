package com.bestgo.common.dto;

import com.bestgo.common.dto.BaseDto;

/**
 * 
 * @description 查询条件对象基类
 * @author maliang
 */
public class BaseQueryConditionDto  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public BaseQueryConditionDto(){};
	/**
	 * 分页查询对象
	 * @param pageNo 第几页/页码
	 * @param pageSize 每页数量
	 */
	public BaseQueryConditionDto(int pageNo,int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	/**
	 * 分页查询对象
	 * @param pageNo 第几页/页码
	 * @param pageSize 每页数量
	 * @param orderByClause 排序字段
	 */
	public BaseQueryConditionDto(int pageNo,int pageSize,String orderByClause){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderByClause = orderByClause;
		
	}
	/** 当前页码 */
	private int pageNo;

	/** 每页显示条数 */
	private int pageSize;

	/** 排序字段 */
	private String orderByClause;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
