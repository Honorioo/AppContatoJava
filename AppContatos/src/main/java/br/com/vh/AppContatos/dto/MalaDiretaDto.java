package br.com.vh.AppContatos.dto;

import br.com.vh.AppContatos.model.Pessoa;

public record MalaDiretaDto(Long id, String name, String enderecoCompleto) {
    public static MalaDiretaDto fromEntity(Pessoa pessoa) {
        String enderecoCompleto = pessoa.getEndereco() + ", " 
                                + pessoa.getCidade() + " - " 
                                + pessoa.getUf() + ", CEP: " 
                                + pessoa.getCep();

        return new MalaDiretaDto(
            pessoa.getId(),
            pessoa.getNome(),
            enderecoCompleto
        );
    }	
}
