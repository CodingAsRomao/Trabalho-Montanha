# Classe `Carro` - Diagrama UML

## 📌 Descrição

A classe `Carro` representa um veículo com informações básicas como marca, modelo, ano e cor, além de comportamentos que simulam ações reais, como ligar, desligar, acelerar e frear.


## 🧩 Atributos

| Nome             | Tipo    | Visibilidade | Descrição                          |
|------------------|---------|--------------|------------------------------------|
| Marca            | String  | privada (-)  | Fabricante do carro                |
| Modelo           | String  | privada (-)  | Modelo do carro                    |
| Ano              | int     | privada (-)  | Ano de fabricação                  |
| Cor              | String  | privada (-)  | Cor do veículo                     |
| VelocidadeAtual  | double  | privada (-)  | Velocidade atual do carro          |
| Ligado           | boolean | privada (-)  | Indica se o carro está ligado      |

---

## 🏗️ Construtor

```java
public Carro(String marca, String modelo, int ano, String cor)
