package com.example.app;

import com.example.app.service.FileParser;

public class ExtractThread implements Runnable {
	private FileParser fileParser;
	private String filename;

	public ExtractThread(FileParser fileParser, String filename) {
		this.fileParser = fileParser;
		this.filename = filename;
	}

	@Override
	public void run() {
		fileParser.parseFile(filename);
	}

}
