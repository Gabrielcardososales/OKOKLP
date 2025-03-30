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
    public String listarServicos() {
        String descricaoGeral = "\n--- Relatório de Serviços --- \n";
        for (ServicoPetshop servico : servicos) {
            descricaoGeral += servico.descricao();
        }
        return descricaoGeral;
    }

    // Retorna a lista de serviços (apenas leitura)
    public List<ServicoPetshop> getServicos() {
        return new ArrayList<>(servicos);
    }
}