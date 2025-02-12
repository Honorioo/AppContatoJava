package br.com.vh.AppContatos.enumTipoContato;

public enum TipoContato {
	
	TELEFONE(0), CELULAR(1);

	
	private int tipo;
	
	TipoContato(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}
	
	
}
