package com.example.app;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.app.service.FileParser;

@SpringBootApplication
public class OrdersParserApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(OrdersParserApplication.class, args);
		System.out.println("------- running application -------");

		FileParser cvsFileParser = context.getBean("CSVFileParser", FileParser.class);
		FileParser jsonFileParser = context.getBean("jsonFileParser", FileParser.class);

		for (String arg : args) {
			String ext = FilenameUtils.getExtension(arg);
			Runnable r = null;
			if ("csv".equals(ext)) {
				r = new ExtractThread(cvsFileParser, arg);
			} else if("json".equals(ext)){
				r = new ExtractThread(jsonFileParser, arg);
			}
			else {
				throw new RuntimeException("file " + arg + " is not supported" );
			}
			new Thread(r).start();
		}

	}




}
