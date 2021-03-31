# SpringClient 
  
  
O seguinte repositório visa demonstrar o funcionamento de uma API criada com Java/Spring Boot.
A API permite ao usuário cadastrar clientes e ordens de serviço, além de comentários relacionados às ordens de serviço.
  
A enidade **cliente** possui como atributos um **Nome**, um **E-mail** e um **Telefone**.   
Já a **Ordem de serviço** possui uma **Descrição**, um **Preço**, um ***Status* (aberta, cancelada ou finalizada)**, uma **Data de abertura**, uma **Data de finalização**, além do **relacionamento obrigatório com um cliente**.  
Por fim, a entidade **Comentário** possui uma **Descrição**, uma **Data de criação**, além do **relacionamento obrigatório com uma ordem de serviço**.  

  
---
  
### Tecnologias Utilizadas:
* Linguagem de Programação: 
  - Java
* Framework:
  - Spring Boot (Spring Boot Web)
* Bibliotecas:
  - Flyway;
  - Spring Data JPA;
  - Jakarta Persistence;
  - Jakarta Bean Validation;
  - ModelMapper;
---

### EndPoints
