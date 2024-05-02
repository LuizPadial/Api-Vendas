## Api Vendas:

**Premissas:**

### Criar uma API usando Spring Boot<br>
### Utilizar um banco de dados em memória (HSQLDB ou H2)<br>
### Não é necessário desenvolver frontend, apenas o backend.<br>

## Teste:

Desenvolver um serviço que seja capaz de gerar uma venda.<br>
Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.<br>

**Sua tarefa é desenvolver os serviços REST abaixo:**<br>
Criar uma nova venda<br>
Retornar a lista de vendedores com os campos: nome, total de vendas do vendedor e média de vendas diária, conforme o período informado por paramêtro.<br>


1-Criado repósitorio privado e importado para o desktop

2-Criado a aplicação com spring Initialazer Maven spring3.2.4 Java 17.
depencias, jpa, springweb, hibernate.

3-Criado um package entities com as classes Order e Seller
feito o mapeamento para criação de duas tabelas uma para o pedido e outra para o vendedor
adicionado todos os metodos, adicionado composições entre pedido e vendedor.

4-Criado as interfaces repositories extendendo jpaRepository para poder ter acesso aos metodos
do crud e poder manipular o banco de dados.

5-Criado as classes OrderServices e SellerService no pacote Services para ter as lógicas e regras de negócio

6-Criado as classes OrderController e SellerController no pacote Controller para criar os endpoints necessários

7-Criado a classe SalesService no pacote Services para buscar as vendas por periodo do vendedor de acordo
com as regras de negócio.

8-Criado alguns testes unitários utilizando Junit e Mockito

**Primeiro devemos adicionar um vendedor usando método Post na endpoint abaixo***

modelo de Json para adicionar um Seller via Post
localhost:8080/sellers
```
{
  "name": "Fulano"
}

```
**Depois basta passar o Json com os parametros da venda na endpoint abaixo**
modelo de Json e end point para adicionar Orders
localhost:8080/orders
```
{
  "date": "2024-04-02T12:00:00Z",
  "price": 100.0,
  "seller": {
    "id": 1,
    "name": ""
  }
}
```
**Busca a média de venda diária de cada vendedor por período:**
```
http://localhost:8080/orders/sales?startDate=2024-04-01&endDate=2024-04-01
```
GET: localhost:8080/sellers
Busca todos os Vendedores

GET: localhost:8080/orders
Busca todos as vendas







