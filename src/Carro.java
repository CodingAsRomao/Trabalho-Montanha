public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double preco;

    // Construtor
    public Carro(int id, String marca, String modelo, int ano, String cor, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
               ", Marca: " + marca + 
               ", Modelo: " + modelo + 
               ", Ano: " + ano + 
               ", Cor: " + cor + 
               ", Preço: R$" + String.format("%.2f", preco);
    }
}