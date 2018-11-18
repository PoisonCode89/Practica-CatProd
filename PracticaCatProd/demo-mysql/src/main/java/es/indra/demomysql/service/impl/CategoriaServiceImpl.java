package es.indra.demomysql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.demomysql.aspects.anotaciones.MedidorDeTiempo;
import es.indra.demomysql.model.Categoria;
import es.indra.demomysql.repository.CategoriaRepository;
import es.indra.demomysql.service.CategoriaService;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	@MedidorDeTiempo
	public List<Categoria> getAllCategoria() {
		return this.categoriaRepository.findAll();
	}

	@Override
	public Categoria getCategoriaById(int id) {
		Optional<Categoria> cat1 = this.categoriaRepository.findById(id);
		if (cat1.isPresent()) {
			return cat1.get();
		} else {
			return null;
		}

	}

	@Override
	public Categoria saveCategoria(Categoria categoria) {

		return this.categoriaRepository.save(categoria);
	}

	@Override
	public void removeCategoria(Categoria categoria) {
		this.categoriaRepository.delete(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		if (this.getCategoriaById(categoria.getId()) != null) {
			return this.categoriaRepository.save(categoria);
		}
		return null;
	}

}
