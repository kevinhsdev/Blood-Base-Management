/**
 * Verifica a compatibilidade entre o tipo sanguíneo de um doador
 * e o tipo necessário para um paciente receptor.
 *
 * Regras de compatibilidade simplificadas:
 *   O- → doa para todos
 *   O+ → doa para todos Rh+
 *   A- → doa para A- e A+
 *   A+ → doa para A+ e AB+
 *   B- → doa para B- e B+
 *   B+ → doa para B+ e AB+
 *   AB- → doa para AB- e AB+
 *   AB+ → doa apenas para AB+
 *
 */

package Model;

public class Compatibilidade {

    public Boolean verificarCompatibilidade(Doador doador, String tipoPaciente) {
        String tipoDoador = doador.getTipoSanguineo();

        return switch (tipoDoador) {
            case "O-" -> true;
            case "O+" -> tipoPaciente.endsWith("+");
            case "A-"  -> tipoPaciente.equals("A-")  || tipoPaciente.equals("A+")
                    || tipoPaciente.equals("AB-") || tipoPaciente.equals("AB+");
            case "A+"  -> tipoPaciente.equals("A+")  || tipoPaciente.equals("AB+");
            case "B-"  -> tipoPaciente.equals("B-")  || tipoPaciente.equals("B+")
                    || tipoPaciente.equals("AB-") || tipoPaciente.equals("AB+");
            case "B+"  -> tipoPaciente.equals("B+")  || tipoPaciente.equals("AB+");
            case "AB-" -> tipoPaciente.equals("AB-") || tipoPaciente.equals("AB+");
            case "AB+" -> tipoPaciente.equals("AB+");
            default    -> false;
        };
    }
}
