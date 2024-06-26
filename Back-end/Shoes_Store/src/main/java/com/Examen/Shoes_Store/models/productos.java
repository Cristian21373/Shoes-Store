package com.Examen.Shoes_Store.models;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class productos {
	
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_prodcuto", nullable=false, length = 36)
	private String id_producto;
	
	@Column(name="nombre_producto", nullable=false, length = 45)
	private String nombre_producto;
	
	@Column(name="descripcion", nullable=false, length = 45)
	private String descripcion;
		
	@Column(name="cantidad", nullable=false)
	private int cantidad;

	@Column(name = "precio", nullable = false, length = 9)
	private String precio;
	
	@Column(name="porcentaje_iva", nullable=false, length = 2)
	private int porcentaje_iva;
	    
	@Column(name="porcentaje_descuento", nullable=false, length = 2)
	private int porcentaje_descuento;


	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length = 10)
	private estado estado;
	

    


	public String getId_producto() {
		return id_producto;
	}


	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public int getPorcentaje_iva() {
		return porcentaje_iva;
	}


	public void setPorcentaje_iva(int porcentaje_iva) {
		this.porcentaje_iva = porcentaje_iva;
	}


	public int getPorcentaje_descuento() {
		return porcentaje_descuento;
	}


	public void setPorcentaje_descuento(int porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}


	public estado getEstado() {
		return estado;
	}


	public void setEstado(estado estado) {
		this.estado = estado;
	}


	public productos() {
		super();
	}


	public enum estado {
        ACTIVO,
        INACTIVO
        
    }


	public String getId() {
		return id_producto;
	}
    
} 