import java.util.ArrayList;
import java.util.List;

public class InventarioPetshop {
    private List<ServicoPetshop> servicos = new ArrayList<>();

    // Adiciona um serviço ao inventário
    public void adicionar(ServicoPetshop servico) {
        servicos.add(servico);
    }

    // Calcula o valor total de todos os serviços
    public double calcularValorServico() {
        double total = 0;
        for (ServicoPetshop servico : servicos) {
            total += servico.calcularPreco();
        }
        return total;
    }

    // Lista resumida de todos os serviços
    public void listarServicos() {
        System.out.println("\n--- Relatório de Serviços ---");
        for (ServicoPetshop servico : servicos) {
            System.out.printf("%s - R$ %.2f%n",
                    servico.descricao(),
                    servico.calcularPreco());
        }
        System.out.printf("Total: R$ %.2f%n", calcularValorServico());
    }

    // Retorna a lista de serviços (apenas leitura)
    public List<ServicoPetshop> getServicos() {
        return new ArrayList<>(servicos);
    }
}