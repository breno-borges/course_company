package br.com.brenoborges.course_company.exceptions;

public class NameAndCategoryFoundException extends RuntimeException {

    /*
     * Construtor que exibirá a mensagem de tratativa após verificar o curso e a
     * categoria
     */
    public NameAndCategoryFoundException() {
        super("Categoria ativa já existente!");
    }
}
