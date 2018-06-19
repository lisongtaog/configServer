package com.bestgo.common.dto;

import com.bestgo.common.dto.ResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description 查询结果分页对象
 * @author maliang
 */
public class PageInfo<T> extends ResponseDto implements java.io.Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public final static int DEFAULT_PAGE_SIZE = 10;

	/** 当前页 */
	private int pageNum = 1;

	/** 每页 显示多少行 */
	private int pageSize;

	/** 其实行 */
	private int startRow;

	/** 数据集合 */
	private List<T> list= new ArrayList<>();

	/** 总数据 count */
	private long totalCount;

	/** 总页数 count */
	private int pages;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
