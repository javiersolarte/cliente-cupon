package com.mercadolibre.cupon.model.ejb;

import com.mercadolibre.cupon.model.vo.ItemsDTO;
import com.mercadolibre.cupon.util.RespuestaExcepcion;

public interface BeneficioBO {
	/**
	 * serivicio uqe maximisa el beneficio para un usuraio retornando la mayor
	 * cantida de items que puede recibir como beneficio en determinado cupon y que
	 * no superan el valor indicado
	 *
	 * @param items listado de items disponibles para el beneficio
	 * @return listado con los items q no superan el monto indicado
	 * @throws RespuestaExcepcion 404-NOT_FOUND en caso de que la lista
	 *                            resultante sea vacia
	 */

	ItemsDTO calcularBeneficioCupon(ItemsDTO items) throws RespuestaExcepcion;

}
