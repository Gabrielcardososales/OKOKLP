public class Main {
    public static void main(String[] args) {
        InventarioPetshop inventario = new InventarioPetshop();

        // Adicionando serviços
        inventario.adicionar(new Banho(1, TamanhoAnimal.PEQUENO, TamPelo.LONGO));
        inventario.adicionar(new Hotel(2, TamanhoAnimal.MEDIO, 5));
        inventario.adicionar(new Tosa(3, TamanhoAnimal.GRANDE));

        // Listando serviços
        inventario.listarServicos();
    }
}