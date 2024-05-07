package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public interface clientes {

    @Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id", nullable=false, length = 36)
	private String id;
	
	@Column(name="primer_name", nullable=false, length = 20)
	private String primer_name;
	
	@Column(name="primer_apellido", nullable=false, length = 20)
	private String primer_apellido;
		
	@Column(name="email", nullable=false, length = 200)
	private String email;
	
	@Column(name="password", nullable=false, length = 25)
	private String password;
	
	@Column(name="confirm_password", nullable=false, length = 25)
	private String confirm_password;
	
	@Column(name="number_phone", nullable=false, length = 15)
	private String number_phone;
	
	
	@Column(name="rol", nullable=false, length = 10)
	private rol rol;

}
