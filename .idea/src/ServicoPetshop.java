import java.time.LocalDate;
import java.util.Objects;

public abstract class ServicoPetshop implements ServicoPetshopIF {
    protected LocalDate data;
    protected int codigo;
    protected TamanhoAnimal tamAnimal;

    public ServicoPetshop(int codigo, TamanhoAnimal tamAnimal) {
        this.codigo = codigo;
        this.tamAnimal = tamAnimal;
        this.data = LocalDate.now();
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public int getCodigo() {
        return codigo;
    }

    public TamanhoAnimal getTamAnimal() {
        return tamAnimal;
    }

    @Override
    public abstract double calcularPreco();


    @Override
    public abstract String descricao();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoPetshop that = (ServicoPetshop) o;
        return codigo == that.codigo &&
                Objects.equals(data, that.data) &&
                tamAnimal == that.tamAnimal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, codigo, tamAnimal);
    }

    @Override
    public String toString() {
        return "ServicoPetshop{" +
                "data=" + data +
                ", codigo=" + codigo +
                ", tamAnimal=" + tamAnimal +
                '}';
    }
}