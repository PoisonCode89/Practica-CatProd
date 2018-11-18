package es.indra.demomysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements java.io.Serializable {

	@Id
	@GeneratedValue
	int id;
	String nombre;
	String descripcion;
	double precio;
	int cantidad;
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Producto() {

	}

	public Producto(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categorias [id=" + id + ", nombre=" + nombre + "]";
	}

}
