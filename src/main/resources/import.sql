INSERT INTO tb_categorias (nome) VALUES ('Dev')
INSERT INTO tb_categorias (nome) VALUES ('Prod')

INSERT INTO tb_autores (nome, email, descricao, data_criacao) VALUES ('Rafael Sulimann', 'rafael@gmail.com', 'teste', TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z')
INSERT INTO tb_autores (nome, email, descricao, data_criacao) VALUES ('Henrique Sulimann', 'henrique@gmail.com', 'teste', TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z')
INSERT INTO tb_autores (nome, email, descricao, data_criacao) VALUES ('Luana Eloi', 'luana@gmail.com', 'teste', TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z')

INSERT INTO tb_livros (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('O Rafael é o melhor', 'Livro que fala como o Rafael é o melhor', 'teste', 150.00, 999, 123456798, TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z', 1, 1)
INSERT INTO tb_livros (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Dev de todos', 'Porque sim', 'teste', 520.55, 753, 987654321, TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z', 2, 2)
INSERT INTO tb_livros (titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Rick Noob', 'Noob dms', 'teste', 299.00, 250, 456789123, TIMESTAMP WITH TIME ZONE '2023-11-23T13:00:00Z', 2, 3)

INSERT INTO tb_paises (nome) VALUES ('Brasil')
INSERT INTO tb_paises (nome) VALUES ('Estados Unidos')

INSERT INTO tb_cupons_descontos (codigo, percentual, validade) VALUES ('TESTE20', 20, TIMESTAMP WITH TIME ZONE '2024-01-15')

INSERT INTO tb_estados (nome, pais_id) VALUES ('Rio Grande do Sul', 1)
INSERT INTO tb_estados (nome, pais_id) VALUES ('Santa Catarina', 1)
INSERT INTO tb_estados (nome, pais_id) VALUES ('Sao Paulo', 1)
INSERT INTO tb_estados (nome, pais_id) VALUES ('Paraná', 1)
INSERT INTO tb_estados (nome, pais_id) VALUES ('Miami', 2)


