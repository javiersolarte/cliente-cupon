package com.mercadolibre.cupon.model.ejb.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mercadolibre.cupon.model.dao.ItemDAO;
import com.mercadolibre.cupon.model.ejb.BeneficioBO;
import com.mercadolibre.cupon.model.vo.ItemsDTO;
import com.mercadolibre.cupon.util.RespuestaExcepcion;

@Service
public class BeneficioBOImpl implements BeneficioBO {

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public ItemsDTO calcularBeneficioCupon(final ItemsDTO items) throws RespuestaExcepcion {
		final Map<String, Float> map = crearMapItemsIniciales(items);
		List<String> calculo = calculate(map, Float.valueOf(items.getAmount()));
		ItemsDTO result = new ItemsDTO();
		result.setItemsId(calculo);
		result.setTotal(obtenerTotalItems(map, calculo));
		return result;
	}

	private String obtenerTotalItems(final Map<String, Float> mapInicial, final List<String> listadoFinal) {
		Float total = new Float(0);
		for (String valor : listadoFinal) {
			total = total.sum(total, mapInicial.get(valor));
		}
		return total.toString();

	}

	private Map<String, Float> crearMapItemsIniciales(final ItemsDTO items) {
		Map<String, Float> mapitems = new HashMap<>();
		for (String element : items.getItemsId()) {
			Float valor = itemDAO.consultarPrecio(element);
			if (valor != null) {
				mapitems.put(element, itemDAO.consultarPrecio(element));
			}
		}
		return mapitems;
	}

	private List<String> calculate(final Map<String, Float> items, final Float amount) throws RespuestaExcepcion {

		List<String> listaResultante = new ArrayList<>();

		Float monto = 0f;
		for (Map.Entry<String, Float> mapSort : ordenarMapa(items).entrySet()) {
			monto = monto.sum(monto, mapSort.getValue());
			if (monto <= amount) {
				listaResultante.add(mapSort.getKey());
			}
		}

		if (listaResultante.isEmpty()) {
			throw new RespuestaExcepcion("404-NOT_FOUND", "404-NOT_FOUND", HttpStatus.NOT_FOUND);
		}
		return listaResultante;

	}

	private HashMap<String, Float> ordenarMapa(final Map<String, Float> inicial) {
		List<Map.Entry<String, Float>> list = new LinkedList<Map.Entry<String, Float>>(inicial.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
			public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
		for (Map.Entry<String, Float> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

}
