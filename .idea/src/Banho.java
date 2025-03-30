import java.util.Objects;

public class Banho extends ServicoPetshop {
    private TamPelo tamPelo;

    public Banho(int codigo, TamanhoAnimal tamAnimal, TamPelo tamPelo) {
        super(codigo, tamAnimal);
        this.tamPelo = tamPelo;
    }

    public TamPelo getTamPelo() {
        return tamPelo;
    }

    @Override
    public double calcularPreco() {
        double precoBase;
        switch(getTamAnimal()) {
            case PEQUENO: precoBase = 50.0; break;
            case MEDIO: precoBase = 60.0; break;
            case GRANDE: precoBase = 70.0; break;
            default: precoBase = 0.0;
        }

        switch(tamPelo) {
            case MEDIO: precoBase += 15.0; break;
            case LONGO: precoBase += 25.0; break;
            case CURTO: break;

        }

        return precoBase;
    }

    @Override
    public String descricao() {
        return "Banho para animal " + getTamAnimal() + " com pelo " + tamPelo + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Banho banho = (Banho) o;
        return tamPelo == banho.tamPelo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamPelo);
    }

    @Override
    public String toString() {
        return "Banho{" +
                "data=" + getData() +
                ", codigo=" + getCodigo() +
                ", tamAnimal=" + getTamAnimal() +
                ", tamPelo=" + tamPelo +
                '}';
    }
}