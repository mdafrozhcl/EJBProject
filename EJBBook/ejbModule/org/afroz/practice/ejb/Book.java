package org.afroz.practice.ejb;

import javax.ejb.Stateless;

import org.afroz.practice.ejb.remotes.BookRemote;

@Stateless(name="Book")
public class Book implements BookRemote{
	private String bName;
	private double bPrice;
	private String author;

	public Book() {
		super();
		bName="Java";
		bPrice=120.05;
		author="Afroz";
	}

	public Book(String bName, double bPrice, String author) {
		super();
		this.bName = bName;
		this.bPrice = bPrice;
		this.author = author;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public double getbPrice() {
		return bPrice;
	}

	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bName=" + bName + ", bPrice=" + bPrice + ", author=" + author + "]";
	}

	@Override
	public String getBook() {
		// TODO Auto-generated method stub
		return "Book [bName=" + bName + ", bPrice=" + bPrice + ", author=" + author + "]";
	}
}