package es.indra.demomysql.service;

import java.util.List;

import es.indra.demomysql.model.Categoria;
import es.indra.demomysql.model.Producto;

public interface ProductoService {

	public List<Producto> getAllProducto();

	public Producto getProductoById(int id);

	public Producto saveProducto(Producto producto);

	public void removeProducto(Producto producto);

	public Producto updateProducto(Producto producto);

	public List<Producto> getAllProductoCat(Categoria c);
}
