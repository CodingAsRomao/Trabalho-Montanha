# Classe `Carro` - Diagrama UML

## 📌 Descrição

A classe `Carro` representa um veículo com informações básicas como marca, modelo, ano e cor, além de comportamentos que simulam ações reais, como ligar, desligar, acelerar e frear.


## 🧩 Atributos

| Nome             | Tipo    | Visibilidade | Descrição                          |
|------------------|---------|--------------|------------------------------------|
| marca            | String  | privada (-)  | Fabricante do carro                |
| modelo           | String  | privada (-)  | Modelo do carro                    |
| ano              | int     | privada (-)  | Ano de fabricação                  |
| cor              | String  | privada (-)  | Cor do veículo                     |
| velocidadeAtual  | double  | privada (-)  | Velocidade atual do carro          |
| ligado           | boolean | privada (-)  | Indica se o carro está ligado      |

---

## 🏗️ Construtor

```java
public Carro(String marca, String modelo, int ano, String cor)