package com.mercadolibre.cupon.model.dao;

public interface ItemDAO {
	/**
	 * consulta precio de determinado item por su identificador
	 *
	 * @param item identificador del item
	 * @return valor del item en caso de que el item exista , en caso contrario null
	 */
	Float consultarPrecio(String item);
}
