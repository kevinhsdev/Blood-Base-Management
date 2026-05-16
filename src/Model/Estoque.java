public class Estoque {

    private String tipoSanguineo;
    private double quantidadeSangue;

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

    @Override
    public String toString() {
        return String.format("Sangue %s: %.0f ml", tipoSanguineo, quantidadeSangue);
    }
}
