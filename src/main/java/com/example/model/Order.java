package com.example.model;

public class Order {
	private long orderId;
	private double amount;
	private String currency;
	private String comment;
	private String fileName;
	private long line;


	public Order(long orderId, double amount, String currency, String comment, String fileName, long line) {
		this.orderId = orderId;
		this.amount = amount;
		this.currency = currency;
		this.comment = comment;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getLine() {
		return line;
	}

	public void setLine(long line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return " Id=" + orderId + ", amount=" + amount + ", currency=" + currency + ", comment=" + comment
				+ "";
	}
	

}
