package com.sulimann.casadocodigo.utils;

public final class TableName {

    public static final String AUTOR = "tb_autores";
    public static final String CATEGORIA = "tb_categorias";
    public static final String LIVRO = "tb_livros";
    public static final String PAIS = "tb_paises";
    public static final String ESTADO = "tb_estados";
    public static final String COMPRA = "tb_compras";
    public static final String PEDIDO = "tb_pedidos";

    private TableName() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }
    
}
