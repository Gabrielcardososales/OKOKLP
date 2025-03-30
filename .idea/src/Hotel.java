public class Hotel extends ServicoPetshop {
    private int qtdHoras;

    public Hotel(int codigo, TamanhoAnimal tamAnimal, int qtdHoras) {
        super(codigo, tamAnimal);
        this.qtdHoras = qtdHoras;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    @Override
    public double calcularPreco() {
        double precoPorHora;
        switch (getTamAnimal()) {
            case PEQUENO:
                precoPorHora = 12.0;
                break;
            case MEDIO:
                precoPorHora = 18.0;
                break;
            case GRANDE:
                precoPorHora = 25.0;
                break;
            default:
                precoPorHora = 0.0;
        }
        return precoPorHora * qtdHoras;
    }

    @Override
    public String descricao() {
        return String.format("Hotel para animal %s por %d horas \n", getTamAnimal(), qtdHoras);
    }

}