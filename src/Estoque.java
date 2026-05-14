public class Estoque {

    private String tipoSanguineo;
    private double quantidadeSangue;

    public Estoque() {};

    public Estoque(String tipoSanguineo, double quantidadeSangue) {
        this.tipoSanguineo = tipoSanguineo;
        this.quantidadeSangue = quantidadeSangue;
    }

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
}
