package models;

import utils.FormatadorUtil;

import java.time.LocalDate;

abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;


    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Nascimento: %s", nome, FormatadorUtil.formatarData(dataNascimento));
    }
}
