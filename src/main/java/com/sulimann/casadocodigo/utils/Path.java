package com.sulimann.casadocodigo.utils;

public final class Path {

    public static final String AUTOR = "/autores";
    public static final String CATEGORIA = "/categorias";
    public static final String LIVRO = "/livros";
    public static final String PAIS = "/paises";
    public static final String ESTADO = "/estados";
    public static final String COMPRA = "/compras";

    private Path() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }
    
}
