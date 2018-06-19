package com.bestgo.common.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.bestgo.common.dto.BaseQueryConditionDto;
import com.bestgo.common.dto.PageInfo;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractPageQuery<T extends BaseQueryConditionDto, P> {
	public PageInfo<P> queryPage(T condition) {
		Integer pageNo = condition.getPageNo();
		Integer pageSize = condition.getPageSize();
		pageNo = (pageNo == null || pageNo==0 ? 1 : pageNo);
		pageSize = (pageSize == null || pageSize==0 ? 10 : pageSize);
		PageHelper.startPage(pageNo, pageSize);
		com.github.pagehelper.PageInfo helperPage = new com.github.pagehelper.PageInfo(doQueryPage(condition));
		PageInfo<P> page = new PageInfo<P>();
		page.setPageNum(pageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(helperPage.getTotal());
		//设置起始数据条数
		page.setStartRow((pageNo-1) * pageSize + 1);
		//计算设置总页数
		Long pages = page.getTotalCount() / pageSize;
		page.setPages(1 + pages.intValue());
		
		for (int i = 0; i < helperPage.getList().size(); i++) {
			P p = beanConvert(helperPage.getList().get(i));
			page.getList().add(p);
		}
		return page;
	}

	protected abstract List doQueryPage(T condition);

	protected abstract P beanConvert(Object src);
}
