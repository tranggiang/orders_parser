package com.example.app.service;

import java.io.FileReader;

import org.springframework.stereotype.Component;

import com.example.model.Order;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Component("jsonFileParser")
public class JsonParser implements FileParser{

	@Override
	public void parseFile(String fileName) {
		Gson gson = new Gson();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			Order[] orders = gson.fromJson(reader, Order[].class);
			for (Order order : orders) {
				System.out.println(order.toString() +  " fileName=" + fileName );
			}

		} catch (Exception e) {
			System.out.println("exception when parsing file  " + fileName + " " + e.getMessage());
		}
		
	}

}
