package es.indra.demomysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.demomysql.model.Categoria;

@Service
public interface CategoriaService {

	public List<Categoria> getAllCategoria();

	public Categoria getCategoriaById(int id);

	public Categoria updateCategoria(Categoria categoria);

	public Categoria saveCategoria(Categoria categoria);

	public void removeCategoria(Categoria categoria);

}
