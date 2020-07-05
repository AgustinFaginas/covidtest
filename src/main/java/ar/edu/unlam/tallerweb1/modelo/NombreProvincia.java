package ar.edu.unlam.tallerweb1.modelo;

public enum NombreProvincia {

	BUENOS_AIRES ("Buenos Aires"), CORDOBA ("Córdoba"), SANTA_FE ("Santa Fe");
	
	 private final String valor;

	 private NombreProvincia(String valor) {
	        this.valor = valor;
	 }

	public String getValor() {
		return valor;
	} 
}
