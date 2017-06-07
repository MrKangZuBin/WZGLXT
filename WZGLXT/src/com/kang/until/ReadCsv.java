package com.kang.until;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsv {
	public void read() {
		try {
			File csv = new File("������Ϣ.csv");
			FileReader fr = new FileReader(csv);
			CSVReader cr = new CSVReader(fr);
			List<String[]> list = cr.readAll();
			if (list != null) {
				for (int i = 1; i < list.size(); i++) {
					for (String info : list.get(i)) {
						System.out.print(info+"\t");
					}
					System.out.println();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ReadCsv().read();
	}
}
