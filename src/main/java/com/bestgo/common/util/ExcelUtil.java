package com.bestgo.common.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil<B extends Workbook> {
	
	private static final String EXCLE_XLS = "XLS";
	private static final String EXCLE_XLSX = "XLSX";
	/**默认中文字体*/
	public static final String DEFAULT_CN = "宋体";
	/**默认英文字体*/
	public static final String DEFAULT_EN = "Arial";
	
	public static final short DEFAULT_FONTSIZE = 11;
	
	/**行内单元格 数据类型(仅适用于数据行，不适用于表头，表头均为文本)，Excel的每一列的类型都是相同的，在此统一设置*/
	private List<CellType> cellTypes;
	
	/**Excel工作簿 */
	private B wb = null;
	
	
	/**
	 * HSSF	2003
	 * XSSF	2007
	 * SXSSF	2007高级
	 * @param wb
	 */
	public ExcelUtil(B wb) {
		super();
		this.wb = wb;
	}
	public ExcelUtil(File file) throws IOException{
		super();
		String fileExt = getFileExtByFileName(file.getName());
		FileInputStream fis = new FileInputStream(file);
		if(EXCLE_XLS.equals(fileExt.toUpperCase())){//2003
			POIFSFileSystem fs = new POIFSFileSystem(fis);
			wb = (B) new HSSFWorkbook(fs);
		}else if (EXCLE_XLSX.equals(fileExt.toUpperCase())) {//2007及以上
			wb = (B) new XSSFWorkbook(fis);
		}
	}
	
	/**
	 * 返回Excel 单元格列数据类型
	 * @return the cellTypes
	 */
	public List<CellType> getCellTypes() {
		return cellTypes;
	}
	/**
	 * 行内单元格 数据类型(仅适用于数据行，不适用于表头，表头均为文本)，Excel的每一列的类型都是相同的，在此统一设置
	 * @param cellTypes the cellTypes to set
	 */
	public void setCellTypes(List<CellType> cellTypes) {
		this.cellTypes = cellTypes;
	}
	/**
	 * 字体默认为 Arial
	 * @return
	 */
	public Font getFont(String fontName,Short fontSize,boolean isBold){
		Font font = wb.createFont();
		if(StringUtils.isBlank(fontName)){
			fontName = DEFAULT_EN;
		}
		font.setFontName(fontName);//设置字体名称
		if(null == fontSize){
			fontSize = DEFAULT_FONTSIZE;
		}
		font.setFontHeightInPoints(fontSize);//设置字体大小
		if(isBold){
			//font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//粗体显示
			font.setBold(isBold);//粗体显示
		}
		return font;
	}
	
	/**
	 * 获取单元格样式</br>
	 * 默认：垂直居中，左右居中，字体：Arial 8号
	 * @param font	单元格字体		null:使用默认字体
	 * @return
	 */
	public CellStyle getCellStyle(Font font){
		CellStyle style = wb.createCellStyle();
		//style.setFillForegroundColor((short) 13);// 设置背景色
		style.setAlignment(HorizontalAlignment.CENTER); //左右 居中 对齐
		style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直 居中 对齐
		if(null != font){
			style.setFont(font);
		}else {//设置默认字体
			style.setFont(getFont(null, null, false));
		}
		return style;
	}
	
	public Cell getCell(Row row,int columnIndex){
		return row.getCell(columnIndex);
	}
	/**
	 * 获取单元格，根据单元格位置
	 * @param sheet
	 * @param cellPosition 单元格位置(例如D3，为4,3)
	 * @return
	 */
	public Cell getCell(Sheet sheet,String cellPosition){
		String[] pos = cellPosition.split(",");
		String colStr = pos[0];//列号
		String rowStr = pos[1];//行号
		int rownum = Integer.parseInt(rowStr) - 1;
		int cellnum = Integer.parseInt(colStr) - 1;
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell;
	}
	
	/**
	 * 创建sheet页
	 * @param sheetName	sheet页名称
	 * @return
	 */
	public Sheet createSheet(String sheetName){
		return createSheet(sheetName, (short) -1, -1);
	}
	
	/**
	 * 创建sheet页
	 * @param sheetName		sheet页名称
	 * @param rowHeight		sheet页中单元格默认行高，传-1取系统默认值
	 * @param colWidth		sheet页中单元格默认宽度，传-1取系统默认值
	 * @return
	 */
	public Sheet createSheet(String sheetName,short rowHeight,int colWidth){
		Sheet sheet = null;
		if(StringUtils.isBlank(sheetName)){
			sheet = wb.createSheet();
		}else{
			sheet = wb.createSheet(sheetName);
		}
		
		if(rowHeight > 0){
			sheet.setDefaultRowHeight(rowHeight);
		}
		if(colWidth > 0){
			sheet.setDefaultColumnWidth(colWidth);
		}
		return sheet;
	}
	
	/**
	 * 获取sheet页
	 * @param sheetName
	 * @return
	 */
	public Sheet getSheet(String sheetName){
		return wb.getSheet(sheetName);
	}
	/**
	 * 获取sheet页
	 * @param sheetIndex
	 * @return
	 */
	public Sheet getSheet(int sheetIndex){
		return wb.getSheetAt(sheetIndex);
	}
	/**
	 * 新增创建行
	 * @param sheet		待创建行的sheet页
	 * @param rowNum	第一行 传入0
	 * @return
	 */
	public Row createRow(Sheet sheet,int rowNum){
		Row row = sheet.createRow(rowNum);
		return row;
	}
	/**
	 * 新增创建行
	 * @param sheet			待创建行的sheet页
	 * @param rowNum		行号
	 * @param rowHeight		行高
	 * @return
	 */
	public Row createRow(Sheet sheet,int rowNum,short rowHeight){
		Row row = sheet.createRow(rowNum);
		if(rowHeight > 0){
			row.setHeight(rowHeight);
		}
		return row;
	}
	
	/**
	 * 获取行，没有则创建一行
	 * @param sheet
	 * @param rowNum
	 * @return
	 */
	public Row getRow(Sheet sheet,int rowNum){
		Row row = sheet.getRow(rowNum);
		if(null == row){
			row = createRow(sheet, rowNum);
		}
		return row;
	}
	/**
	 * 合并单元格
	 * @param sheet		待合并单元格的sheet页
	 * @param firstRow	待合并单元格起始行
	 * @param lastRow 	待合并单元格终止行
	 * @param firstCol	待合并单元格起始列
	 * @param lastCol 	待合并单元格终止列
	 * @param border 边框粗细,为数组对象：第1个 表示左边框，第2个 表示上边框，第3个 表示右边框，第4个 表示下边框
	 */
	public CellRangeAddress mergeCell(Sheet sheet,int firstRow ,int lastRow ,int firstCol ,int lastCol ,int[] border){
		CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol); // 起始行, 终止行, 起始列, 终止列  
		sheet.addMergedRegion(region);
		if(4 == border.length){//设置合并单元格边框
			RegionUtil.setBorderLeft(border[0], region, sheet);
			RegionUtil.setBorderTop(border[1], region, sheet);
			RegionUtil.setBorderRight(border[2], region, sheet);
			RegionUtil.setBorderBottom(border[3], region, sheet);
		}
		return region;
	}
	
	/**
	 * 设置合并单元格样式
	 * @param sheet
	 * @param region
	 * @param cs
	 */
	public void setRegionStyle(Sheet sheet, CellRangeAddress region, CellStyle cellStyle) {
		if(null == cellStyle){
			cellStyle = getCellStyle(null);//获取默认单元格样式
		}
		for (int i = region.getFirstRow(); i <= region.getLastRow(); i++) {
			Row row = CellUtil.getRow(i, sheet);
			for (int j = region.getFirstColumn(); j <= region.getLastColumn(); j++) {
				Cell cell = CellUtil.getCell(row, (short) j);
				cell.setCellStyle(cellStyle);
			}
		}
	}
	
	/**
	 * 设置单元格列宽度
	 * @param sheet
	 * @param columnIndex	列序号
	 * @param width			列宽度;	MAX:255*256,255 characters
	 */
	public void setColumnWidth(Sheet sheet,int columnIndex,int width){
		sheet.setColumnWidth(columnIndex, width);
	}
	
	/**
	 * 设置单元格 数据格式
	 * @param cellStyle
	 */
	public void setCellDataFormat(CellStyle cellStyle){

	}
	
	/**
	 * 设置单元格表头
	 * @param sheet	Excel的sheet页
	 * @param headRow	表头数据
	 * @param headRowIndex	表头起始行
	 * @param headColumnIndex	表头起始列
	 */
	public void writeHeadRow(Sheet sheet,List<String> headRow,Integer headRowIndex,Integer headColumnIndex){
		int rowNum = headRowIndex < 0 ? 0 : headRowIndex;//首行为表头
		int columnNum = headColumnIndex < 0 ? 0 : headColumnIndex;
		
		
		List<CellType> cts = new ArrayList<CellType>();
		
		
		ExcelRow row = new ExcelRow(rowNum);//表头行
		for(String rowVal : headRow){
			ExcelCell cell = new ExcelCell(rowNum,columnNum ++,rowVal);
			row.addCell(cell);//设置表头行 的单元格列
			cts.add(CellType.STRING);//表头设置为 字符串
		}
		
		List<CellType> cellTypes_bak = cellTypes;
		cellTypes = cts;//设置表头类型
		List<ExcelRow> excelRows = new ArrayList<ExcelRow>();
		excelRows.add(row);
		writeRow(sheet, excelRows);
		cellTypes = cellTypes_bak;//恢复表头类型
	}
	
	/**
	 * 写入行数据
	 * @param sheet
	 * @param excelRows
	 */
	public void writeRow(Sheet sheet,List<ExcelRow> excelRows){
		//根据表头值，输出到Excel指定的单元格中
		for(ExcelRow erow : excelRows){//行
			int rowNum = erow.getRowIndex();//行号
			Row row = getRow(sheet, rowNum);
			
			CellType type = null;
			String value = null;
			//String comment = null;
			for(ExcelCell ecell : erow.getExcelCells()){//行内 单元格
				int columnIndex = ecell.getColumnIndex();
				type = cellTypes.get(columnIndex);//获取该 单元格列的 数据格式
				value = ecell.getValue();
				//comment = ecell.getComment();
				Cell cell = row.createCell(columnIndex, type);//创建指定 列的单元格
				if(null != ecell.getStyle()){//设置单元格样式
					cell.setCellStyle(ecell.getStyle());
				}
				/*if(null != comment){
					cell.setCellComment(comment);
				}*/
				writeCell(cell, type, value);//单元格 写入值
			}
		}
	}
	
	
	
	/**
	 * 写入单元格
	 * @param cell	待写入值的单元格
	 * @param type	单元格数据类型
	 * @param value	单元格值
	 * @return
	 */
	public Cell writeCell(Cell cell,CellType type,String value){
		if (cell == null)
			return cell;
		
		switch (type) {
		case FORMULA:// 函数
			cell.setCellFormula(value);
			break;
		case BLANK:
		case STRING:
			cell.setCellValue(value);
			break;
		case NUMERIC:
			Double dval = Double.valueOf(value);
			cell.setCellValue(dval);
			break;
		case BOOLEAN:
			Boolean bval = Boolean.parseBoolean(value);
			cell.setCellValue(bval);
			break;
		case ERROR:
			break;
		default:
			break;
		}
		return cell;
	}
	
	/**
	 * Excel版本
	 * true : 2003
	 * false :2007
	 * @return
	 */
	public boolean isExcel2003(){
		boolean flag = false;
		if(HSSFWorkbook.class.isInstance(wb)){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @description 根据文件名获得文件后缀
	 * @param filename
	 * @return
	 */
	public static String getFileExtByFileName(String filename) {
		if (filename == null) {
			return null;
		}
		if (filename.indexOf(".") == -1) {
			return "";
		}
		return filename.substring(filename.lastIndexOf(".") + 1);
	}
	
	
	/**
	 * 将表格数据转换成字符串(小数只保留整数部分)
	 * 
	 * @param cell
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getStringValue(Cell cell) {
		String value = "";
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_FORMULA:
		case Cell.CELL_TYPE_BLANK:
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			value = Long.valueOf(
					Double.valueOf(cell.getNumericCellValue()).longValue())
					.toString();// 只取整数部分
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			value = String.valueOf(cell.getErrorCellValue());
			break;
		}
		return value.trim().replace("_x0000_", "");
	}
	/**
	 * 将表格数据转换成字符串(小数只保留整数部分)
	 * 
	 * @param cell
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getStringValueDouble(Cell cell) {
		String value = "";
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_FORMULA:
			try {
				value = String.valueOf(cell.getNumericCellValue());
			} catch (IllegalStateException e) {
				 value = String.valueOf(cell.getRichStringCellValue());
			}
			break;
		case Cell.CELL_TYPE_BLANK:
		case Cell.CELL_TYPE_STRING:
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			value = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			value = String.valueOf(cell.getErrorCellValue());
			break;
		}
		return value.trim().replace("_x0000_", "");
	}
	
	/**  
	* 判断是否合并了行  
	* @param sheet  
	* @param row  
	* @param column  
	* @return boolean
	*/  
	public static boolean isMergedRow(Sheet sheet,int row ,int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if(row == firstRow && row == lastRow){
				if(column >= firstColumn && column <= lastColumn){
					return true;
				}
			}
		}
		return false;
	}
	
	/**  
	* 判断指定的单元格是否是合并单元格  
	* @param sheet   
	* @param row 行下标  
	* @param column 列下标  
	* @return boolean
	*/  
	public static boolean isMergedRegion(Sheet sheet,int row ,int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if(row >= firstRow && row <= lastRow){
				if(column >= firstColumn && column <= lastColumn){
					return true;  
				}  
			}  
		  }  
		return false;  
	}
	
	/**
	 * 转码文件名
	 * @param fileName 文件名
	 * @return file 转码后的文件名
	 */
	public static String getFileName(String fileName)
	{
		String file = "";
		try {
			file =  new String(fileName.getBytes("GBK"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
	/**
	 * 当前workbook写入文件
	 * @param fileName
	 * @throws Exception
	 */
	public void workbook2File(String fileName) throws Exception{
		workbook2File(this.wb, fileName);
	}
	/**
	 * 当前workbook写入流，并返回
	 * @return
	 * @throws Exception
	 */
	public InputStream workbook2InputStream() throws Exception {
		return workbook2InputStream(this.wb);
	}
	
	/**
	 * 读取Excel，转换为输入流
	 * @param workbook HSSFWorkbook对象
	 * @return InputStream Excel输入流
	 * @throws Exception
	 */
	public static InputStream workbook2InputStream(Workbook wb) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wb.write(baos);
		baos.flush();
		byte[] aa = baos.toByteArray();
		InputStream excelStream = new ByteArrayInputStream(aa, 0, aa.length);
		baos.close();

		return excelStream;
	}
	/**
	 * workbook的Excel流，转储到文件中
	 * @param wb
	 * @param fileName
	 * @throws Exception
	 */
	public static void workbook2File(Workbook wb,String fileName) throws Exception{
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		fos.close();
	}
	
}
