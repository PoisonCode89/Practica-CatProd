package es.indra.demomysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.indra.demomysql.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
