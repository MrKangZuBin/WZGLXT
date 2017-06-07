package com.kang.until;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class POIWrite {
	public void saveAsEcxl() {
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet = workBook.createSheet("采购订单-物品");
			HSSFRow titleRow = sheet.createRow(0);
			
			HSSFCellStyle style = workBook.createCellStyle();
			//设置对齐方式
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//设置边框
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			//设置填充色
			style.setFillForegroundColor(HSSFColor.GOLD.index);
			//设置填充方式(全部填充)
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			HSSFFont font = workBook.createFont();
			//font.setBold(true);
			//设置字号
			font.setFontHeightInPoints((short)24);
			//设置字体颜色
			font.setColor(HSSFColor.RED.index);
			style.setFont(font);
			
			// 姓名 年龄 身高 生日
			HSSFCell cell1 = titleRow.createCell(0);
			cell1.setCellStyle(style);
			cell1.setCellValue("物品代码");
			HSSFCell cell2 = titleRow.createCell(1);
			cell2.setCellStyle(style);
			cell2.setCellValue("物品名称");
			HSSFCell cell3 = titleRow.createCell(2);
			cell3.setCellStyle(style);
			cell3.setCellValue("物品条码");
			HSSFCell cell4 = titleRow.createCell(3);
			cell4.setCellStyle(style);
			cell4.setCellValue("规格");
			HSSFCell cell5 = titleRow.createCell(4);
			cell5.setCellStyle(style);
			cell5.setCellValue("单位");
			HSSFCell cell6 = titleRow.createCell(5);
			cell6.setCellStyle(style);
			cell6.setCellValue("数量");
			HSSFCell cell7= titleRow.createCell(6);
			cell7.setCellStyle(style);
			cell7.setCellValue("总数量");
			// 数据行
			HSSFRow dataRow = sheet.createRow(1);
			HSSFCell name = dataRow.createCell(0);
			name.setCellValue("李四");
			HSSFCell age = dataRow.createCell(1);
			age.setCellValue(20);
			HSSFCell height = dataRow.createCell(2);
			height.setCellValue(185.5);

			HSSFCell birthDay = dataRow.createCell(3);
			HSSFCellStyle dateStyle = workBook.createCellStyle();
			HSSFDataFormat dateFormat = workBook.createDataFormat();
			dateStyle.setDataFormat(dateFormat.getFormat("yyyy-MM-dd"));
			birthDay.setCellStyle(dateStyle);
			birthDay.setCellValue(new Date());
			FileOutputStream fos = new FileOutputStream("student信息.xls");
			workBook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new POIWrite().saveAsEcxl();
	}
}
