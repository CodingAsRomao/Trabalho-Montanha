# 🚗 Trabalho Final A3 – Concessionária de Carros

**Disciplina:** Programação de Soluções Computacionais  
**Professor:** Alexandre de Oliveira (Montanha)  
**Grupo:**   
Henrique Romão de Oliveira RA: 124220073     
Henrique Paulino Dayrell Capanema RA: 125111381313     

---

## Descrição do Projeto

Este projeto é uma aplicação de console em Java que simula o gerenciamento de uma **concessionária de carros**. Ele permite realizar operações de CRUD (Criar, Listar, Buscar, Editar e Remover registros), com validações e persistência dos dados em arquivo `.txt`.

---

##  Funcionalidades

Menu principal:  

=== CONCESSIONÁRIA DE CARROS ===

Criar novo registro

Listar todos os registros

Buscar registro (por identificador)

Editar registro

Excluir registro

Sair

A aplicação permite:
- ✅ Cadastrar um novo carro
- ✅ Listar todos os carros cadastrados
- ✅ Buscar um carro pela placa
- ✅ Editar qualquer campo de um carro
- ✅ Remover um carro
- ✅ Salvar tudo automaticamente em arquivo

---

##  Entidade: Carro

A entidade escolhida representa um **carro disponível na concessionária**.

### Atributos:
- `modelo`: String
- `marca`: String
- `ano`: int
- `cor`: String
- `placa`: String (identificador único)
- `valor`: double

> Justificativa: A entidade `Carro` representa um objeto de domínio comum em revendas, oficinas e locadoras. Facilita o entendimento da programação orientada a objetos com um exemplo próximo da realidade.

---

##  Validações Implementadas

- A **placa** não pode ser vazia
- O **ano** deve ser maior que zero
- O sistema lança exceções com mensagens personalizadas (`DadoInvalidoException`)

---

##  Persistência

- Os dados são armazenados no arquivo `carros.txt`
- O formato utilizado é **CSV simples**
- Os dados são carregados na inicialização e salvos automaticamente após qualquer modificação

---

### Como Executar

### Requisitos
- Java JDK 8 ou superior

### Compilação e execução
```bash
# Compilar os arquivos
javac src/*.java

# Executar
java -cp src Main
```

---
