package com.bestgo.common.util;

import java.util.ArrayList;
import java.util.List;

public class ExcelRow {
	/**行号/待合并单元格起始行*/
	private int rowIndex;
	/**行内 单元格*/
	private List<ExcelCell> excelCells = new ArrayList<ExcelCell>();
	
	public ExcelRow(int rowIndex) {
		super();
		this.rowIndex = rowIndex;
	}
	/**
	 * @return the rowIndex
	 */
	public int getRowIndex() {
		return rowIndex;
	}
	
	/**
	 * @return the cells
	 */
	public List<ExcelCell> getExcelCells() {
		return excelCells;
	}
	
	/**
	 * 添加单元格
	 * @param cell
	 */
	public void addCell(ExcelCell cell){
		excelCells.add(cell);
	}
	/**
	 * 清空行
	 */
	public void clearCell(){
		this.excelCells.clear();
	}
	
}
