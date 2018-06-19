package com.bestgo.common.util.transform;
/**
 * 实现代码转名称的接口说明
 */
public interface TransfromInter {
	/**
	 * 根据代码类型和代码 转换为目标值
	 * @return 
	 */
	public Object transVal(String codeType, Object codeCode);
}
