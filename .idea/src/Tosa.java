public class Tosa extends ServicoPetshop {
    public Tosa(int codigo, TamanhoAnimal tamAnimal) {
        super(codigo, tamAnimal);
    }

    @Override
    public double calcularPreco() {
        switch(getTamAnimal()) {
            case PEQUENO: return 30.0;
            case MEDIO: return 40.0;
            case GRANDE: return 50.0;
            default: return 0.0;
        }
    }

    @Override
    public String descricao() {
        return String.format("Tosa para animal %s \n", getTamAnimal());
    }

    // ... (restante dos métodos permanecem iguais)
}