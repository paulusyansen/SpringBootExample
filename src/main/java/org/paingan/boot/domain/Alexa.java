package org.paingan.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "alexa")
public class Alexa{
	
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
	private int isshow;
	
	public Alexa() {
		
	}
//	
	public Alexa(int id, String date, int score, String site, int isshow) {
		this.id = id;
		this.date = date;
		this.score = score;
		this.site = site;
		this.isshow = isshow;
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
	
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	
	@Override
	public String toString() {
		return "Alexa [eid = " + id + ", date = " + date + ", score = " + score + ", site = " + site + ", isshow = " + isshow + "]";
	}
}
