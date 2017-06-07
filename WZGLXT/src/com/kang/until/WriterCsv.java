package com.kang.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;

public class WriterCsv {
	public void writer(){
		File file = new File("������Ϣ.csv");
		try {
			FileWriter fw = new FileWriter(file);
			CSVWriter  cw = new CSVWriter(fw);
			String[] titles = {"����","����","���"};
			cw.writeNext(titles);
			String[] datas = {"����","20","190.0"};
			cw.writeNext(datas);
			cw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new WriterCsv().writer();
	}
}
