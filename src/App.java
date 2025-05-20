public class App {
    // Criando uma main para testar a classe
    public static void main(String[] args) {
        // Criando um objeto Carro
        Carro meuCarro = new Carro("Toyota", "Corolla", 2022, "Prata");
        
        // Testando os métodos
        meuCarro.exibirInformacoes();
        meuCarro.ligar();
        meuCarro.acelerar(50);
        meuCarro.frear(20);
        meuCarro.desligar();
        meuCarro.frear(30);
        meuCarro.desligar();
        meuCarro.exibirInformacoes();
    }
}