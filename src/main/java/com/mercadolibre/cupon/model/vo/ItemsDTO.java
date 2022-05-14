package com.mercadolibre.cupon.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class ItemsDTO {
	@JsonProperty("item_ids")
	private List<String> itemsId= new ArrayList<>();
	private String amount;
	private String total;

	public String getAmount() {
		return amount;
	}

	public void setAmount(final String amount) {
		this.amount = amount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(final String total) {
		this.total = total;
	}

	public List<String> getItemsId() {
		return itemsId;
	}

	public void setItemsId(final List<String> itemsId) {
		this.itemsId = itemsId;
	}

}
