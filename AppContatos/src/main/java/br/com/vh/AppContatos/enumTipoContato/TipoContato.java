package br.com.vh.AppContatos.enumTipoContato;

public enum TipoContato {
	
	TELEFONE(0), CELULAR(1), EMAIL(2), REDE_SOCIAL(3);

	
	private int tipo;
	
	TipoContato(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}
	
	
}
