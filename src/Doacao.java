public class Doacao {

    private int id;
    private double quantidadeSangue;
    private String data;
    private int idDoador;

    public Doacao() {};

    public Doacao(double quantidadeSangue, String data, int idDoador) {
        this.quantidadeSangue = quantidadeSangue;
        this.data = data;
        this.idDoador = idDoador;
    }

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

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    @Override
    public String toString() {
        return String.format("[%d] Doador ID: %d | %.0f ml | %s",
                id, idDoador, quantidadeSangue, data);
    }
}
