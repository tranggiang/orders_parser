package com.example.app.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
@Component("CSVFileParser")
public class CSVFileParser implements FileParser {


	@Override
	public void parseFile(String fileName) {
		String[] HEADERS = { "orderId", "amount", "currency", "comment" };
		int lineNumber = 1;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(fileName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withHeader(HEADERS).withIgnoreHeaderCase().withFirstRecordAsHeader().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				lineNumber++;
				System.out.println(csvRecord.toMap());

				System.out.println("[Id=" + Long.parseLong(csvRecord.get("orderId")) + ", amount="
						+ Double.parseDouble(csvRecord.get("amount")) + ", currency=" + csvRecord.get("currency")
						+ ", comment=" + csvRecord.get("comment") + ", fileName=" + fileName + ", line=" + lineNumber
						+ "]");

			}

		} catch (NumberFormatException e) {
			throw new RuntimeException("fail to parse CSV file " + fileName + " at line number  " + lineNumber + " " + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());

		}

	}

}
