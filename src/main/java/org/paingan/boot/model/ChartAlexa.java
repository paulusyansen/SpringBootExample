package org.paingan.boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chart_alexa")
public class ChartAlexa implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "*Please provide a date")
	private String date;
	
	@NotNull(message = "*Please provide a valid elevenia score")
	private int elevenia;
	
	@NotNull(message = "*Please provide a valid tokopedia score")
	private int tokopedia;
	
	@NotNull(message = "*Please provide a valid shopee score")
	private int shopee;
	
	@NotNull(message = "*Please provide a valid lazada score")
	private int lazada;
	
	@NotNull(message = "*Please provide a valid blibli score")
	private int blibli;
	
	@Column(name="show_yn")
	private int showYn = 1;
	
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
	public int getElevenia() {
		return elevenia;
	}
	public void setElevenia(int elevenia) {
		this.elevenia = elevenia;
	}
	public int getTokopedia() {
		return tokopedia;
	}
	public void setTokopedia(int tokopedia) {
		this.tokopedia = tokopedia;
	}
	public int getShopee() {
		return shopee;
	}
	public void setShopee(int shopee) {
		this.shopee = shopee;
	}
	public int getLazada() {
		return lazada;
	}
	public void setLazada(int lazada) {
		this.lazada = lazada;
	}
	public int getBlibli() {
		return blibli;
	}
	public void setBlibli(int blibli) {
		this.blibli = blibli;
	}
	public int getShowYn() {
		return showYn;
	}
	public void setShowYn(int showYn) {
		this.showYn = showYn;
	}
	@Override
	public String toString() {
		return "Alexa [eid = " + id + ", date = " + date + ", elevenia = " + elevenia + ", tokopedia = " + tokopedia + ", shopee = " + shopee + ", blibli = " + blibli + ", showYn = " + showYn + "]";
	}
}
