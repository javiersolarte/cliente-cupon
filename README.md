# CUPON

## Arquitectura 
El proyecto está estructurado en tres capas 
Rest web:  donde se construye y  expone el servicio beneficio/coupon

Ejb: dónde está implementado la lógica de negocio correspondiente a dicho servicio 
 
Dao: dónde están el acceso a datos en este caso la invocación  al servicio externo 
https://api.mercadolibre.com/items/$ITEM_ID1 para consultar el precio de los ítems
enviados 


## Despliege local

```
./mvnw install 
java -jar target/cupon-0.0.1-SNAPSHOT.jar

curl -x POST http://54.91.4.150:8080/beneficio/coupon/
```

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


