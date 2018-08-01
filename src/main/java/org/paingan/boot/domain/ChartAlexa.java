package org.paingan.boot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chart_alexa")
public class ChartAlexa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "*Please provide a date")
	private String date;
	
	@NotNull
	private int elevenia;
	
	@NotNull
	private int tokopedia;
	
	@NotNull
	private int shopee;
	
	@NotNull
	private int lazada;
	
	@NotNull
	private int blibli;
	
	@Column(name="show_yn")
	private int showYn = 1; // default 1
	
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
		return "Chart Alexa [id = " + id + ", date = " + date + ", elevenia = " + elevenia + ", tokopedia = " + tokopedia + ", shopee = " + shopee + ", blibli = " + blibli + ", showYn = " + showYn + "]";
	}
}
