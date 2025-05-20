public class Carro {
    // Atributos (características do carro)
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double velocidadeAtual;
    private boolean ligado;
    
    // Construtor (método especial para criar objetos Carro)
    // this.ligado (disligado kkkkkkkk)
    public Carro(String marca, String modelo, int ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.velocidadeAtual = 0;
        this.ligado = false;
    }
    
    // Métodos (comportamentos do carro)
    
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("O carro foi ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }
    
    public void desligar() {
        if (ligado && velocidadeAtual == 0) {
            ligado = false;
            System.out.println("O carro foi desligado.");
        } else if (velocidadeAtual > 0) {
            System.out.println("Não é possível desligar o carro em movimento.");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }
    
    public void acelerar(double quantidade) {
        if (ligado) {
            velocidadeAtual += quantidade;
            System.out.println("Acelerando para " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Não é possível acelerar com o carro desligado.");
        }
    }
    
    public void frear(double quantidade) {
        if (ligado && velocidadeAtual > 0) {
            velocidadeAtual = Math.max(0, velocidadeAtual - quantidade);
            System.out.println("Freando para " + velocidadeAtual + " km/h");
        } else if (velocidadeAtual == 0) {
            System.out.println("O carro já está parado.");
        } else {
            System.out.println("Não é possível frear com o carro desligado.");
        }
    }
    
    // Métodos getters para acessar os atributos privados
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    public String getCor() {
        return cor;
    }
    
    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }
    
    public boolean isLigado() {
        return ligado;
    }
    
    // Método para exibir informações do carro
    public void exibirInformacoes() {
        System.out.println("Informações do Carro:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Cor: " + cor);
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
        System.out.println("Status: " + (ligado ? "Ligado" : "Desligado"));
    }
}