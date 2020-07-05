package ar.edu.unlam.tallerweb1.modelo;

	public enum NombreLocalidad {

		SARANDI("Sarandí"), WILDE("Wilde"), CASTELAR ("Castelar"),
		CIUDADELA ("Ciudadela"), SAN_JUSTO("San Justo"), MONSERRAT("Monserrat"),
		MORON ("Morón");

		private final String valor;

		private NombreLocalidad(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		} 

}
