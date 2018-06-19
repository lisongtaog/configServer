package com.bestgo.common.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.bestgo.common.service.BeanConverter;

public class DozerBeanConverterServiceImpl implements BeanConverter {
	
	private DozerBeanMapper converter;
	
	public void setConverter(DozerBeanMapper converter) {
		this.converter = converter;
	}
	
	public DozerBeanConverterServiceImpl(){		
	}
	
	public DozerBeanConverterServiceImpl(DozerBeanMapper mapper){
		this.converter = mapper;
	}
	

	@Override
	public void convert(Object src, Object des) {
		if(src == null)
			des = null;
		else
			converter.map(src, des);
	}

	@Override
	public void convert(Object src, Object des, String mapId) {
		if(src == null)
			des = null;
		else
			converter.map(src, des, mapId);
	}

	@Override
	public <T> T convert(Object src, Class<T> desClass, String mapId) {

		return src==null?null:converter.map(src, desClass, mapId);
	}

	@Override
	public <T> T convert(Object src, Class<T> desClass) {

		return src==null?null:converter.map(src, desClass);
	}
	
	@Override
	public <T> List<T> convertList(Collection sourceList , Class<T> desClass) {
		if(sourceList == null || sourceList.size() == 0){
			return Collections.EMPTY_LIST;
		}
		List<T> destList = new ArrayList<T>();
		for (Object srcObject : sourceList) {
			T destObject = converter.map(srcObject, desClass);
			destList.add(destObject);
		}
		return destList;
	}

	@Override
	public <T> void convertList(Collection sourceList, Collection destList, Class<T> desClass) {
		if(sourceList == null || sourceList.size() == 0){
			return ;
		}
		for (Object srcObject : sourceList) {
			T destObject = converter.map(srcObject, desClass);
			destList.add(destObject);
		}
	}
	
}
