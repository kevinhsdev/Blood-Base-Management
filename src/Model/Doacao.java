package Model;

public class Doacao extends Doador{

    private int id;
    private double quantidadeSangue;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantidadeSangue() {
        return quantidadeSangue;
    }

    public void setQuantidadeSangue(double quantidadeSangue) {
        this.quantidadeSangue = quantidadeSangue;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("[%d] Doador ID: %d | %.0f ml | %s",
                id, quantidadeSangue, data);
    }
}
