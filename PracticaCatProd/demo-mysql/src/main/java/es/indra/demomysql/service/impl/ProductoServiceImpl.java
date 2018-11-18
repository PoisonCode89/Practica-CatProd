package es.indra.demomysql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.demomysql.aspects.anotaciones.MedidorDeTiempo;
import es.indra.demomysql.model.Categoria;
import es.indra.demomysql.model.Producto;
import es.indra.demomysql.repository.ProductoRepository;
import es.indra.demomysql.service.ProductoService;

@Component
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	@MedidorDeTiempo
	public List<Producto> getAllProducto() {
		return this.productoRepository.findAll();
	}

	@Override
	public Producto getProductoById(int id) {
		Optional<Producto> prod = this.productoRepository.findById(id);
		if (prod.isPresent()) {
			return prod.get();
		} else {
			return null;
		}

	}

	@Override
	public Producto saveProducto(Producto producto) {

		return this.productoRepository.save(producto);
	}

	@Override
	public void removeProducto(Producto producto) {
		this.productoRepository.delete(producto);
	}

	@Override
	public Producto updateProducto(Producto producto) {
		if (this.getProductoById(producto.getId()) != null) {
			return this.productoRepository.save(producto);
		}
		return null;
	}

	@Override
	public List<Producto> getAllProductoCat(Categoria c) {
		List<Producto> listaCat;

		productoRepository.findAll();
		return null;
	}
}
