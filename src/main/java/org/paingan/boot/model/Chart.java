package org.paingan.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "chart")
public class Chart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank
	private String date;
	
	@NotBlank
	private int score;
	
	@NotBlank
	private String site;
	
	@NotBlank
	private String page;
	
	@NotBlank
	private String device;
	
	public Chart(int id, String date, int score, String site, String page, String device) {
		this.id = id;
		this.date = date;
		this.score = score;
		this.site = site;
		this.page = page;
		this.device = device;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	@Override
	public String toString() {
		return "Chart [eid = " + id + ", date = " + date + ", score = " + score + ", site = " + site + ", page = " + page + ", device = " + device +"]";
	}
}
