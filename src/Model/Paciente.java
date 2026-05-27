package Model;

public class Paciente {
    private int idade;
    private String tipoSanguineo;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @Override
    public String toString() {
        return String.format("%s | %d anos",
                tipoSanguineo, idade);
    }
}
