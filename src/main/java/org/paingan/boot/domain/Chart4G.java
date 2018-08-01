package org.paingan.boot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chart_4G")
public class Chart4G implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "*Please provide a date")
	private String date;

	@NotNull @Min(value = 1, message = "*Please provide a elevenia score")
	private int elevenia;
	
	@NotNull @Min(value = 1, message = "*Please provide a tokopedia score")
	private int tokopedia;
	
	@NotNull @Min(value = 1, message = "*Please provide a shoppe score")
	private int shopee;
	
	@NotNull @Min(value = 1, message = "*Please provide a lazada score")
	private int lazada;
	
	@NotNull @Min(value = 1, message = "*Please provide a blibli score")
	private int blibli;

	@NotBlank(message = "*Please provide a page")
	private String page;

	@NotBlank(message = "*Please provide a device")
	private String device;

	@Column(name = "show_yn")
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
