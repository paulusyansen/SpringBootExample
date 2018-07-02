package org.paingan.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tmp_chart_4G")
public class Chart4G {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	private String date;

	private int elevenia;
	private int tokopedia;
	private int shopee;
	private int lazada;
	private int blibli;

	@NotBlank
	private String page;

	@NotBlank
	private String device;

	@Column(name = "show_yn")
	private int showYn;
	
	public Chart4G(String date, int elevenia, int tokopedia, int shopee, int lazada, int blibli){
		this.date = date;
		this.elevenia = elevenia;
		this.tokopedia = tokopedia;
		this.shopee = shopee;
		this.lazada = lazada;
		this.blibli = blibli;
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

	public int getShowYn() {
		return showYn;
	}

	public void setShowYn(int showYn) {
		this.showYn = showYn;
	}
}
