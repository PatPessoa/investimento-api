
# Painel de Investimentos - Desafio Caixa Verso

API REST desenvolvida em Java 21 e Spring Boot para simulação de investimentos e análise de perfil de risco.

## Tecnologias Usadas
- Java 21
- Spring Boot 3
- SQLite (Banco de Dados em arquivo)
- Docker
- Lombok

## Como Rodar o Projeto

### Opção 1: Via Maven (Terminal)
Na raiz do projeto, execute:
```bash
mvn spring-boot:run
````

O servidor iniciará na porta **8081**.

### Opção 2: Via Docker

```bash
docker build -t investimento-api .
docker run -p 8081:8081 investimento-api
```

-----

## Endpoints Principais

### 1\. Simular Investimento

**POST** `http://localhost:8081/simular-investimento`

**Body (JSON):**

```json
{
  "clienteId": 123,
  "valor": 10000.00,
  "prazoMeses": 12,
  "tipoProduto": "CDB"
}
```

### 2\. Consultar Histórico

**GET** `http://localhost:8081/simulacoes`

### 3\. Descobrir Perfil de Risco (Suitability)
**POST** `http://localhost:8081/perfil-risco`

**Body (JSON) - Pontuação de 0 a 20:**
```json
{
  "clienteId": 123,
  "toleranciaRisco": 10,
  "horizonte": 10,
  "conhecimentoFinanceiro": 10,
  "objetivo": 10,
  "situacaoFinanceira": 10
}
```
### 4\. Recomendação de Produtos

**GET** `http://localhost:8081/produtos-recomendados/{perfil}`

* Exemplo: `http://localhost:8081/produtos-recomendados/Conservador`

### 5\. Telemetria

**GET** `http://localhost:8081/telemetria`

-----

Desenvolvido por Patrícia Nunes Pessoa.

```
