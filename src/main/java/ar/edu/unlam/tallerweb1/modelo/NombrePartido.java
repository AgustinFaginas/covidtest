package ar.edu.unlam.tallerweb1.modelo;

public enum NombrePartido {
	
	AVELLANEDA ("Avellaneda"), EZEIZA("Ezeiza"), MORON("Morón"),
	TRES_DE_FEBRERO ("Tres de Febrero"), SAN_JUSTO("San Justo"), MONSERRAT("Monserrat"),
	CASTELAR ("Castelar");
	
	 private final String valor;

	 private NombrePartido(String valor) {
	        this.valor = valor;
	 }

	public String getValor() {
		return valor;
	} 

}
