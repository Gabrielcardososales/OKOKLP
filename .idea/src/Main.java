import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static int proximoCodigo = 1;  // Contador para gerar códigos automaticamente

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarioPetshop inventario = new InventarioPetshop();

        System.out.println("🐾 *Bem-vindo ao Petshop Bot* 🐾");
        System.out.println("Sistema de fechamento diário\n");
        System.out.println("📅 Hoje é: "
                + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        boolean continuar = true;
        while(continuar) {
            System.out.println("\n📝 *Menu Principal*");
            System.out.println("1. Registrar Banho");
            System.out.println("2. Registrar Tosa");
            System.out.println("3. Registrar Hospedagem");
            System.out.println("4. Fechar o Dia e Gerar Relatório");
            System.out.print("➡️ Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    registrarServico(new String[]{"Banho", "tipo de pelo (1-Curto, 2-Médio, 3-Longo)"},
                            scanner, inventario);
                    break;
                case 2:
                    registrarServico(new String[]{"Tosa", ""},
                            scanner, inventario);
                    break;
                case 3:
                    registrarServico(new String[]{"Hospedagem", "quantidade de horas"},
                            scanner, inventario);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\n🏪 *Fechamento do Dia* 🏪");
                    gerarRelatorio(inventario);
                    break;
                default:
                    System.out.println("⚠️ Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void registrarServico(String[] dadosServico, Scanner scanner, InventarioPetshop inventario) {
        System.out.println("\n✨ Registrando " + dadosServico[0]);

        System.out.println("Tamanho do animal (1-Pequeno, 2-Médio, 3-Grande):");
        TamanhoAnimal tamanho = getTamanhoAnimal(scanner.nextInt());

        ServicoPetshop servico = null;
        int codigo = proximoCodigo++;

        switch(dadosServico[0]) {
            case "Banho":
                System.out.println(dadosServico[1] + ":");
                TamPelo pelo = getTamPelo(scanner.nextInt());
                servico = new Banho(codigo, tamanho, pelo);
                break;

            case "Tosa":
                servico = new Tosa(codigo, tamanho);
                break;

            case "Hospedagem":
                System.out.print(dadosServico[1] + ": ");
                int horas = scanner.nextInt();
                servico = new Hotel(codigo, tamanho, horas);
                break;
        }

        inventario.adicionar(servico);
        System.out.println("✅ " + dadosServico[0] + " registrado! Código: " + codigo);
    }

    private static void gerarRelatorio(InventarioPetshop inventario) {
        System.out.println("\n📊 *Relatório Final*");
        System.out.println("----------------------------------");
        inventario.listarServicos();
        System.out.println("----------------------------------");
        System.out.println("🐶 Total de serviços: " + inventario.getServicos().size());
        System.out.println("💰 Total arrecadado: R$ " + String.format("%.2f", inventario.calcularValorServico()));
        System.out.println("\n🏪 *Petshop fechado com sucesso!* 🏪");
    }

    private static TamanhoAnimal getTamanhoAnimal(int opcao) {
        switch(opcao) {
            case 1: return TamanhoAnimal.PEQUENO;
            case 2: return TamanhoAnimal.MEDIO;
            case 3: return TamanhoAnimal.GRANDE;
            default: return TamanhoAnimal.PEQUENO;
        }
    }

    private static TamPelo getTamPelo(int opcao) {
        switch(opcao) {
            case 1: return TamPelo.CURTO;
            case 2: return TamPelo.MEDIO;
            case 3: return TamPelo.LONGO;
            default: return TamPelo.CURTO;
        }
    }
}