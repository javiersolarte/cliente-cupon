# CUPON
# /beneficio/coupon


### POST /beneficio/coupon

Esta solicitud se encarga de  maximisar el beneficio para un usuario retornando la mayor
cantidad de items que puede recibir como beneficio en determinado cupon y que
no superan el valor indicado respondiendo de la siguiente manera
```json
[
   {
	"item_ids": ["MLA811601010", "MLA2"],
	"total":5003
   }
]
```
En caso de que el monto no sea suficiente como para comprar
mínimamente un item devolver un error 404-NOT_FOUND.

```
Si no encunetra resultados retorna una lista vacía

#### Códigos de campo, códigos de error y códigos de estado
|Código de estado|Código de campo|Código de error|Descripción|
|---|---|---|---|
|`200`|||Exitoso|
|`404`|||Error no encontro items para retornar|


