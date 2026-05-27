package Model;

public class Estoque {

    private String tipoSanguineo;
    private double quantidadeSangue;
    private double quantidadeSangueTotal;

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getQuantidadeSangue() {
        return quantidadeSangue;
    }

    public void setQuantidadeSangue(double quantidadeSangue) {
        this.quantidadeSangue = quantidadeSangue;
    }

    public double getQuantidadeSangueTotal() {
        return quantidadeSangueTotal;
    }

    @Override
    public String toString() {
        return String.format("Sangue %s: %.0f ml", tipoSanguineo, quantidadeSangue);
    }
}
