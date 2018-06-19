package com.bestgo.common.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelCell {
	/**行号/待合并单元格起始行*/
	private int rowIndex;
	/**列号/待合并单元格起始列*/
	private int columnIndex;
	/**
	 * the cell's data type
	 * 单元格数据类型
	 */
	private CellType type;
	/**单元格值*/
	private String value;
	/**单元格样式*/
	private CellStyle style;
	/**单元格批注*/
	private String comment;
	/**是否是合并的单元格，默认为否*/
	private boolean merge = false;
	/**待合并单元格终止行*/
	private int lastRow = -1;
	/**待合并单元格终止列*/
	private int lastCol = -1;
	
	
	public ExcelCell(int rowIndex, int columnIndex, String value) {
		super();
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.value = value;
	}
	/**
	 * @return the rowIndex
	 */
	public int getRowIndex() {
		return rowIndex;
	}
	/**
	 * @param rowIndex the rowIndex to set
	 */
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	/**
	 * @return the columnIndex
	 */
	public int getColumnIndex() {
		return columnIndex;
	}
	/**
	 * @param columnIndex the columnIndex to set
	 */
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	
	/**
	 * @return the type
	 */
	public CellType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(CellType type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the style
	 */
	public CellStyle getStyle() {
		return style;
	}
	/**
	 * @param style the style to set
	 */
	public void setStyle(CellStyle style) {
		this.style = style;
	}
	
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the merge
	 */
	public boolean isMerge() {
		return merge;
	}
	/**
	 * @param merge the merge to set
	 */
	public void setMerge(boolean merge) {
		this.merge = merge;
	}
	/**
	 * @return the lastRow
	 */
	public int getLastRow() {
		return lastRow;
	}
	/**
	 * @param lastRow the lastRow to set
	 */
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	/**
	 * @return the lastCol
	 */
	public int getLastCol() {
		return lastCol;
	}
	/**
	 * @param lastCol the lastCol to set
	 */
	public void setLastCol(int lastCol) {
		this.lastCol = lastCol;
	}
	
	
}
