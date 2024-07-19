package br.com.brenoborges.course_company.exceptions;

public class IdNotFoundException extends RuntimeException {
    /*
     * Construtor que exibirá a mensagem de tratativa após verificar se o Id é
     * invalido e/ou inexistente
     */
    public IdNotFoundException() {
        super("Id inválido/inexistente!");
    }
}
