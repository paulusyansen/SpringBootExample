package org.paingan.boot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ChartDTO {

	public String date;
	public float elevenia;
	public float tokopedia;
	public float shopee;
	public float lazada;
	public float blibli;
	
	public ChartDTO(String date, float elevenia, float tokopedia, float shopee, float lazada, float blibli){
		this.date = date;
		this.elevenia = elevenia;
		this.tokopedia = tokopedia;
		this.shopee = shopee;
		this.lazada = lazada;
		this.blibli = blibli;
	}
}
