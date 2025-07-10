# 🚀 Evolução Tecnológica com StackSpot AI

## Migração Automatizada e Inteligente

Todo o processo de migração deste projeto — de uma API Node.js (Express) para uma arquitetura robusta em Java com Spring Boot e Spring Data JPA — foi **100% conduzido e automatizado pela StackSpot AI**. Foi utilizado recursos avançados de automação, centralização de conhecimento e integração contínua, promovendo uma verdadeira evolução tecnológica e de maturidade do sistema.

### Como a StackSpot AI foi protagonista

- **[Agente "migrated"](https://ai.stackspot.com/agents/01JZKSXH6HNFF9312RBDWNARXB?tabIndex=0):** Orquestrou e automatizou todas as tarefas de migração, centralizando conhecimento e decisões técnicas.
- **[Knowledge Source "Guia Descritivo de Migração"](https://ai.stackspot.com/knowledge-sources/c92ccd-guia-descritivo-de-migracao?tabIndex=0):** Fonte de referência técnica e de boas práticas, garantindo qualidade e padronização em cada etapa.
- **[Quick Command "Migra de Node.Js para Java"](https://ai.stackspot.com/quick-command/migrar-de-nodejs-para-java?tabIndex=0):** Comando rápido que executou a migração de forma automatizada, integrando agente e base de conhecimento.
- **[Spot Integrado "Language-Migrator"](https://ai.stackspot.com/spots/01JZP9H7GJKY4Z8JW2X9YB9KGN):** Centralizou todos os componentes acima, promovendo colaboração, rastreabilidade e reuso.
- **[Stack AI "Language-Migrator-Stack"](https://ai.stackspot.com/stacks-ai/01JZTJBJDNS40WS6X9AK3HK3TQ?tabIndex=0):** Conecta você ao ecossistema de StackSpot e à nossa stack especializada para migração de linguagens.


#### Benefícios concretos do uso da StackSpot AI

- **Automação total:** Eliminação de tarefas manuais e repetitivas, acelerando a entrega e reduzindo erros.
- **Padronização e qualidade:** Garantia de melhores práticas, arquitetura moderna e código limpo.
- **Documentação centralizada:** Todo o histórico, decisões e conhecimento ficam registrados e acessíveis.
- **Colaboração e reuso:** Integração facilitada entre membros da equipe e reaproveitamento de componentes e fluxos.

---

# CRUD Migrated – Uma Nova Era

Este projeto representa a **evolução de uma API de cadastro e consulta de produtos**, originalmente em Node.js, para uma solução moderna, escalável e alinhada com padrões corporativos, utilizando Java, Spring Boot e Spring Data JPA. A migração não apenas traduziu código, mas **elevou o nível de maturidade, segurança, performance e governança** do sistema.

## Funcionalidades

- **Health Check:** Verifica a saúde da aplicação.
- **Cadastro de Produto:** Permite cadastrar novos produtos.
- **Consulta de Produto por ID:** Busca produtos de forma individualizada.
- **Listagem de Produtos:** Retorna todos os produtos cadastrados.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (banco em memória para testes)
- Jakarta Validation
- Lombok
- Maven

## Estrutura das Classes

- `HealthController`: Endpoint `/health` para health check.
- `ProdutoController`: Endpoints REST para cadastro e consulta de produtos.
- `ProdutoService` e `ProdutoServiceImpl`: Camada de serviço para regras de negócio.
- `ProdutoRepository`: Interface JPA para persistência.
- `Produto`: Entidade JPA que representa o produto.
- `GlobalExceptionHandler`: Handler global para exceções.

## Endpoints

| Método | Endpoint              | Descrição                    |
|--------|-----------------------|------------------------------|
| GET    | `/health`             | Health check da aplicação    |
| POST   | `/api/produtos`       | Cadastra um novo produto     |
| GET    | `/api/produtos/{id}`  | Busca produto por ID         |
| GET    | `/api/produtos`       | Lista todos os produtos      |

### Exemplo de JSON para cadastro de produto

## Json
{
  "nome": "Produto Exemplo",
  "dataCriacao": "2025-07-08",
  "quantidadeDisponivel": 10
}

# Como rodar o projeto
Siga o passo a passo abaixo para rodar o projeto localmente na sua máquina.


## 1. Clone o repositório.
* Abra o terminal de sua preferência (Git Bash,Prompt de Comando, PowerShell ou Terminal do VSCode) e execute:

* git clone https://github.com/LuizMoura-03/migrator.git
* cd migrator


## 2. Compile e execute
* Certifique-se de ter o Java 17+ e o Maven instalados.
* No terminal, execute os comandos abaixo para compilar e iniciar a aplicação:

bash:
* mvn clean install
* mvn spring-boot:run

Aguarde até aparecer a mensagem indicando que a aplicação está rodando (por padrão, na porta 8080).

## 3. Acesse os endpoints
* Health: http://localhost:8080/health
* Produtos: http://localhost:8080/api/produtos

Caso receba erro de “conexão recusada”, verifique se a aplicação foi iniciada corretamente e se a porta 8080 está disponível.

## 4. Acesse o console do H2 (opcional)

   Se quiser visualizar o banco de dados em memória, acesse:

* http://localhost:8080/h2-console

Preencha o campo JDBC URL com:
* JDBC URL: jdbc:h2:file:~/migration
* User Name:(deixe em branco)
* Password: (deixe em branco)
* Clique em Connect.

Importante: Após conectar ao H2 Console, para listar os produtos cadastrados, você pode executar a seguinte query:

SELECT * FROM produtos;

Essa instrução SQL retornará todos os registros da tabela de produtos.

## Observações
* O projeto utiliza banco H2 em arquivo (jdbc:h2:file:~/migration). Isso garante que os dados cadastrados permaneçam salvos mesmo após reiniciar ou fechar a aplicação.
* Caso queira utilizar o banco em memória (H2) para facilitar testes e desenvolvimento, basta alterar ou adicionar no arquivo application.properties a seguinte configuração: spring.datasource.url=jdbc:h2:mem:testdb

Atenção: No modo memória (mem), o banco de dados existe apenas enquanto a aplicação está em execução. Ao fechar o programa, todos os dados cadastrados serão perdidos, pois não ficam salvos em disco. Esse modo é útil para testes rápidos e desenvolvimento temporário.

* As validações de campos obrigatórios são feitas via anotações do Jakarta Validation.
* O tratamento de erros é centralizado via GlobalExceptionHandler.

## Testes Automatizados e Cobertura
* Os testes automatizados foram implementados utilizando JUnit 5 e Mockito. Para garantir a qualidade do código, foi utilizada a ferramenta Jacoco para análise de cobertura de testes.

* Cobertura de testes: 96%
* ![Relatório Jacoco](./docs/Jacoco.png)

## Referências StackSpot AI
* Agente "migrated"
* Knowledge Source "Guia Descritivo de Migração"
* Quick Command "Migra de Node.Js para Java (remote)"
* Spot Integrado.
* Stacks AI "Language-Migrator-Stack"

# StackSpot AI foi a base de toda a transformação deste projeto, promovendo automação, qualidade e evolução tecnológica.