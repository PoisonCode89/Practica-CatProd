package es.indra.demomysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.demomysql.model.Categoria;
import es.indra.demomysql.service.CategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getAllCategoria() {
		List<Categoria> todosLosBlogs = this.categoriaService.getAllCategoria();

		ResponseEntity<List<Categoria>> response = new ResponseEntity<List<Categoria>>(todosLosBlogs, HttpStatus.OK);

		return response;
	}

	@RequestMapping(value = "/categora/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> getToDoById(@PathVariable("id") int id) {
		Categoria c = this.categoriaService.getCategoriaById(id);
		if (c == null) {
			return new ResponseEntity<Categoria>(c, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Categoria>(c, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/categoria", method = RequestMethod.POST)
	public ResponseEntity<Void> crearCategoria(@RequestBody Categoria c) {
		Categoria categoria = this.categoriaService.saveCategoria(c);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/categoria", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> updateToDo(@RequestBody Categoria c) {

		Categoria categoria = this.categoriaService.updateCategoria(c);

		if (categoria == null) {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeToDOById(@PathVariable("id") int id) {
		Categoria categoria = categoriaService.getCategoriaById(id);
		categoriaService.removeCategoria(categoria);
		return new ResponseEntity<String>("Categoria eliminada", HttpStatus.OK);

	}

}
