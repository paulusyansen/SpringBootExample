package org.paingan.boot.dto;


public class ChartDTO {

	private String date;
	private float elevenia;
	private float tokopedia;
	private float shopee;
	private float lazada;
	private float blibli;
	
	public ChartDTO(String date, float elevenia, float tokopedia, float shopee, float lazada, float blibli){
		this.date = date;
		this.elevenia = elevenia;
		this.tokopedia = tokopedia;
		this.shopee = shopee;
		this.lazada = lazada;
		this.blibli = blibli;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getElevenia() {
		return elevenia;
	}

	public void setElevenia(float elevenia) {
		this.elevenia = elevenia;
	}

	public float getTokopedia() {
		return tokopedia;
	}

	public void setTokopedia(float tokopedia) {
		this.tokopedia = tokopedia;
	}

	public float getShopee() {
		return shopee;
	}

	public void setShopee(float shopee) {
		this.shopee = shopee;
	}

	public float getLazada() {
		return lazada;
	}

	public void setLazada(float lazada) {
		this.lazada = lazada;
	}

	public float getBlibli() {
		return blibli;
	}

	public void setBlibli(float blibli) {
		this.blibli = blibli;
	}

}
