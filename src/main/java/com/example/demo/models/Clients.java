package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.interfaces.ValidationGroups;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Entity
public class Clients {

	//por padrão, ele já entende que tais atributos são colunas,
	//mas caso queira mudar a relação, basta por um nome diferente do atributo NA CLASSE. O atributo name da anotação deve 
	//ser igual ao da coluna no banco (VER EXEMPO TELEFONE, QUE NA CLASSE TEM O ATRIBUTO COM NOME FONE)
	
	@NotNull(groups = ValidationGroups.ClientId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //pega o padrão do banco de dados para a criação dos IDs
	private Long id;
	
	@Size(max=200) 
	@NotBlank(groups = Default.class)
	private String nome;
	
	@Size(max=200) 
	@NotBlank(groups = Default.class)
	@Email
	private String email;
	
	@Size(max=200)
	@NotBlank(groups = Default.class)
	@Column(name="telefone")
	private String fone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String telefone) {
		this.fone = telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}