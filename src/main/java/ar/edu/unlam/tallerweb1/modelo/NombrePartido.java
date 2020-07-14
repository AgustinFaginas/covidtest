package ar.edu.unlam.tallerweb1.modelo;

public enum NombrePartido {

    AVELLANEDA("Avellaneda"), EZEIZA("Ezeiza"), MORON("Morón"), LA_MATANZA("La Matanza"),
    TRES_DE_FEBRERO("Tres de Febrero"), MONSERRAT("Monserrat"),
    CASTELAR("Castelar");

    private final String valor;

    private NombrePartido(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
