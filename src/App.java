import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.Year;
import java.util.regex.Pattern;

public class App {
    private static List<Carro> carros = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static final String ARQUIVO_DADOS = "carros.txt";
    private static final Pattern MARCA_MODELO_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s-]+$");
    private static final int ANO_PRIMEIRO_CARRO = 1886;
    private static final int ANO_ATUAL = Year.now().getValue();

    public static void main(String[] args) {
        carregarDados(); // Carrega os dados do arquivo ao iniciar
        
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    criarCarro();
                    break;
                case 2:
                    listarCarros();
                    break;
                case 3:
                    buscarCarro();
                    break;
                case 4:
                    editarCarro();
                    break;
                case 5:
                    excluirCarro();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            System.out.println();
        } while (opcao != 6);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("=== CONCESSIONÁRIA DE CARROS ===");
        System.out.println("1. Criar novo registro");
        System.out.println("2. Listar todos os registros");
        System.out.println("3. Buscar registro (por identificador)");
        System.out.println("4. Editar registro");
        System.out.println("5. Excluir registro");
        System.out.println("6. Sair");
    }
    
    // Métodos auxiliares para validação
    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido.");
            }
        }
    }
    
    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
    
    private static String lerStringValidada(String mensagem, String campo, boolean permitirNumeros) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            
            if (entrada.isEmpty()) {
                System.out.println(campo + " não pode ser vazio!");
                continue;
            }
            
            if (!permitirNumeros && !entrada.matches("[a-zA-ZÀ-ú\\s]+")) {
                System.out.println(campo + " deve conter apenas letras e espaços!");
                continue;
            }
            
            if (permitirNumeros && !MARCA_MODELO_PATTERN.matcher(entrada).matches()) {
                System.out.println(campo + " contém caracteres inválidos!");
                continue;
            }
            
            return entrada;
        }
    }
    
    private static int lerAno(String mensagem) {
        while (true) {
            int ano = lerInteiro(mensagem);
            if (ano >= ANO_PRIMEIRO_CARRO && ano <= ANO_ATUAL + 1) {
                return ano;
            }
            System.out.println("Ano inválido! Deve estar entre " + ANO_PRIMEIRO_CARRO + " e " + (ANO_ATUAL + 1));
        }
    }
    
    private static double lerPreco(String mensagem) {
        while (true) {
            double preco = lerDouble(mensagem);
            if (preco > 0) {
                return preco;
            }
            System.out.println("O preço deve ser maior que zero!");
        }
    }
    
    // Métodos CRUD com validação
    private static void criarCarro() {
        System.out.println("\n--- NOVO CARRO ---");
        
        String marca = lerStringValidada("Marca: ", "Marca", true);
        String modelo = lerStringValidada("Modelo: ", "Modelo", true);
        int ano = lerAno("Ano: ");
        String cor = lerStringValidada("Cor: ", "Cor", false);
        double preco = lerPreco("Preço: R$");
        
        Carro novoCarro = new Carro(proximoId++, marca, modelo, ano, cor, preco);
        carros.add(novoCarro);
        salvarDados();
        
        System.out.println("Carro cadastrado com sucesso! ID: " + novoCarro.getId());
    }
    
    private static void listarCarros() {
        System.out.println("\n--- LISTA DE CARROS ---");
        
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        }
    }
    
    private static void buscarCarro() {
        System.out.println("\n--- BUSCAR CARRO ---");
        
        int id = lerInteiro("Digite o ID do carro: ");
        
        boolean encontrado = false;
        
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                System.out.println("Carro encontrado:");
                System.out.println(carro);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Carro com ID " + id + " não encontrado.");
        }
    }
    
    private static void editarCarro() {
        System.out.println("\n--- EDITAR CARRO ---");
        
        int id = lerInteiro("Digite o ID do carro que deseja editar: ");
        
        Carro carroParaEditar = null;
        
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                carroParaEditar = carro;
                break;
            }
        }
        
        if (carroParaEditar == null) {
            System.out.println("Carro com ID " + id + " não encontrado.");
            return;
        }
        
        System.out.println("Editando carro:");
        System.out.println(carroParaEditar);
        System.out.println("\nDigite os novos dados (deixe em branco para manter o valor atual):");
        
        System.out.print("Marca (" + carroParaEditar.getMarca() + "): ");
        String marca = scanner.nextLine();
        if (!marca.isEmpty()) {
            if (MARCA_MODELO_PATTERN.matcher(marca).matches()) {
                carroParaEditar.setMarca(marca);
            } else {
                System.out.println("Marca inválida! Não foi alterada.");
            }
        }
        
        System.out.print("Modelo (" + carroParaEditar.getModelo() + "): ");
        String modelo = scanner.nextLine();
        if (!modelo.isEmpty()) {
            if (MARCA_MODELO_PATTERN.matcher(modelo).matches()) {
                carroParaEditar.setModelo(modelo);
            } else {
                System.out.println("Modelo inválido! Não foi alterado.");
            }
        }
        
        System.out.print("Ano (" + carroParaEditar.getAno() + "): ");
        String anoStr = scanner.nextLine();
        if (!anoStr.isEmpty()) {
            try {
                int ano = Integer.parseInt(anoStr);
                if (ano >= ANO_PRIMEIRO_CARRO && ano <= ANO_ATUAL + 1) {
                    carroParaEditar.setAno(ano);
                } else {
                    System.out.println("Ano inválido! Não foi alterado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ano inválido! Não foi alterado.");
            }
        }
        
        System.out.print("Cor (" + carroParaEditar.getCor() + "): ");
        String cor = scanner.nextLine();
        if (!cor.isEmpty()) {
            if (cor.matches("[a-zA-ZÀ-ú\\s]+")) {
                carroParaEditar.setCor(cor);
            } else {
                System.out.println("Cor inválida! Não foi alterada.");
            }
        }
        
        System.out.print("Preço (" + carroParaEditar.getPreco() + "): ");
        String precoStr = scanner.nextLine();
        if (!precoStr.isEmpty()) {
            try {
                double preco = Double.parseDouble(precoStr);
                if (preco > 0) {
                    carroParaEditar.setPreco(preco);
                } else {
                    System.out.println("Preço inválido! Não foi alterado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido! Não foi alterado.");
            }
        }
        
        salvarDados();
        System.out.println("Carro atualizado com sucesso!");
    }
    
    private static void excluirCarro() {
        System.out.println("\n--- EXCLUIR CARRO ---");
        
        int id = lerInteiro("Digite o ID do carro que deseja excluir: ");
        
        Carro carroParaExcluir = null;
        
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                carroParaExcluir = carro;
                break;
            }
        }
        
        if (carroParaExcluir == null) {
            System.out.println("Carro com ID " + id + " não encontrado.");
            return;
        }
        
        System.out.println("Tem certeza que deseja excluir o carro abaixo? (S/N)");
        System.out.println(carroParaExcluir);
        String confirmacao = scanner.nextLine();
        
        if (confirmacao.equalsIgnoreCase("S")) {
            carros.remove(carroParaExcluir);
            salvarDados();
            System.out.println("Carro excluído com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }
    
    // Métodos para persistência em arquivo
    private static void carregarDados() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
            String linha;
            carros.clear();
            int maxId = 0;
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 6) {
                    int id = Integer.parseInt(dados[0]);
                    String marca = dados[1];
                    String modelo = dados[2];
                    int ano = Integer.parseInt(dados[3]);
                    String cor = dados[4];
                    double preco = Double.parseDouble(dados[5]);
                    
                    carros.add(new Carro(id, marca, modelo, ano, cor, preco));
                    
                    if (id > maxId) {
                        maxId = id;
                    }
                }
            }
            
            proximoId = maxId + 1;
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro no formato dos dados: " + e.getMessage());
        }
    }
    
    private static void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (Carro carro : carros) {
                writer.write(carro.getId() + ";" +
                            carro.getMarca() + ";" +
                            carro.getModelo() + ";" +
                            carro.getAno() + ";" +
                            carro.getCor() + ";" +
                            carro.getPreco());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}