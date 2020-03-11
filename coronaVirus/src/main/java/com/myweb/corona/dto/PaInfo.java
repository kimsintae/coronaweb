package com.myweb.corona.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("painfo")
public class PaInfo {
	private int no;
	private String name;
	private String comment;
	private String color;
	private List<PaRoute> route;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<PaRoute> getRoute() {
		return route;
	}
	public void setRoute(List<PaRoute> route) {
		this.route = route;
	}
	
	
	
}
