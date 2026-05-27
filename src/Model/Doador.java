package Model;

public class Doador {

    private int idDoador;
    private String nome;
    private int idade;
    private String telefone;
    private String tipoSanguineo;
    private double peso;

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {this.idDoador = idDoador;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %d anos | %.1f kg | %s",
                idDoador, nome, tipoSanguineo, idade, peso, telefone);
    }
}