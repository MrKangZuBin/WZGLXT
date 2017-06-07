package com.kang.until;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kang.pojo.IntemInformation;

public class POIReader {

	public static List<IntemInformation> readXls(String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		IntemInformation iif = null;
		List<IntemInformation> list = new ArrayList<IntemInformation>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					iif = new IntemInformation();
					HSSFCell no = hssfRow.getCell(0);
					HSSFCell name = hssfRow.getCell(1);
					HSSFCell shortName = hssfRow.getCell(2);
					HSSFCell ename = hssfRow.getCell(3);
					HSSFCell shortename = hssfRow.getCell(4);
					HSSFCell guige = hssfRow.getCell(5);
					HSSFCell danwei = hssfRow.getCell(6);
					iif.setArticlebarcode(no.toString());
					iif.setChinesename(name.toString());
					iif.setChineseabbreviation(shortName.toString());
					iif.setEnglishname(ename.toString());
					iif.setEnglishabbreviation(shortename.toString());
					iif.setPurchasespecifications(guige.toString());
					iif.setPurchasingunit(danwei.toString());
					list.add(iif);
				}
			}
		}
		return list;
	}
	public static List<IntemInformation> readXlsx(String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		IntemInformation iif = null;
		List<IntemInformation> list = new ArrayList<IntemInformation>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					iif = new IntemInformation();
					XSSFCell no = xssfRow.getCell(0);
					XSSFCell name = xssfRow.getCell(1);
					XSSFCell shortName = xssfRow.getCell(2);
					XSSFCell ename = xssfRow.getCell(3);
					XSSFCell shortename = xssfRow.getCell(4);
					XSSFCell guige = xssfRow.getCell(5);
					XSSFCell danwei = xssfRow.getCell(6);
					iif.setArticlebarcode(no.toString());
					iif.setChinesename(name.toString());
					iif.setChineseabbreviation(shortName.toString());
					iif.setEnglishname(ename.toString());
					iif.setEnglishabbreviation(shortename.toString());
					iif.setPurchasespecifications(guige.toString());
					iif.setPurchasingunit(danwei.toString());
					list.add(iif);
				}
			}
		}
		return list;
	}
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfCell) {
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(xssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}
}