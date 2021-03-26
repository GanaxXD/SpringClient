package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Clients;

//Cria uma interface herdando de JpaRepository <Classe, tipo_id_da_classe> para pegar os diversos métodos
//já implementados pelo spring para interação com banco de dados (findAll, count, delete, etc). Ela
//será usada no controller para trazer os dados do banco.

/*implementando métodos próprios:
 * o Spring Data JPa cria os métodos 
 * automaticamente, caso deseje criar um método que não exista 
 * na lista disponível.
 * Para tanto, basta criar a assinatura do método sem o modificador (private, public, etc).
 * O método precisa ter o nome do atributo IGUAL AO QUE ESTÁ NA CLASSE. Se colocar findAllByName vai dar errado,
 * porque na classe client não existe o atributo name, e sim, nome.
 * Ex: método findAllByNome(String nome)
 * A palavra Containing tem sentido de palavra reservada, e é igual ao "like" nas pesquisas sql. 
 * Ex: findAllByNomeContaining(String nome)
*/

@Repository
public interface ClientsInterface extends JpaRepository<Clients, Long>{
	
	List<Clients> findAllByNome(String nome);
	Clients findByEmail(String email);
}
