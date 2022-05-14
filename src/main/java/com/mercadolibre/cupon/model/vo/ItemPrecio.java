package com.mercadolibre.cupon.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class ItemPrecio {
	private String id;
	private String price;

	private String siteId;
	private String tittle;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(final String price) {
		this.price = price;
	}

	@JsonProperty("site_id")
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(final String siteId) {
		this.siteId = siteId;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(final String tittle) {
		this.tittle = tittle;
	}

}
