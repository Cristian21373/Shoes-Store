package com.Examen.Shoes_Store.models;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ventas {
	
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_venta", nullable=false, length = 36,columnDefinition = "char(36)")
	private String id_venta;
	
	@ManyToOne
	@JoinColumn(name="cliente_id_cliente", nullable=false)
	private clientes cliente_id_cliente;


	@Column(name="total", nullable=false, length = 45)
	private String total;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado", nullable=false, length = 10)
	private estado estado;
	
	@Column(name="fecha_venta", nullable=false)
	private Date fecha_venta;
	








	public String getId_venta() {
		return id_venta;
	}





	public void setId_venta(String id_venta) {
		this.id_venta = id_venta;
	}





	public clientes getCliente_id_cliente() {
		return cliente_id_cliente;
	}





	public void setCliente_id_cliente(clientes cliente_id_cliente) {
		this.cliente_id_cliente = cliente_id_cliente;
	}





	public String getTotal() {
		return total;
	}





	public void setTotal(String total) {
		this.total = total;
	}





	public estado getEstado() {
		return estado;
	}





	public void setEstado(estado estado) {
		this.estado = estado;
	}





	public Date getFecha_venta() {
		return fecha_venta;
	}





	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}





	public ventas(String id_venta, clientes cliente_id_cliente, String total,
			com.Examen.Shoes_Store.models.ventas.estado estado, Date fecha_venta) {
		super();
		this.id_venta = id_venta;
		this.cliente_id_cliente = cliente_id_cliente;
		this.total = total;
		this.estado = estado;
		this.fecha_venta = fecha_venta;
	}





	public ventas() {
		super();
	}





	public enum estado {
	    ACTIVO,
	    INACTIVO
	    
	}





	public String getId() {
		
		return id_venta;
	}





	
}


