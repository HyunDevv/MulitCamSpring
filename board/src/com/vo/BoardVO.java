package com.vo;

import java.util.Date;

public class BoardVO {
	private int bid;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int cnt;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int bid, String title, String content, String writer, Date regdate, int cnt) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.cnt = cnt;
	}

	public BoardVO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVO(int bid, String title, String content, String writer) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVO(String title, String content, String writer, int cnt) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.cnt = cnt;
	}



	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
	
	
}
