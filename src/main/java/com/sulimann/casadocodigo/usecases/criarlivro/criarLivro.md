# 1 - NECESSIDADES

- É necessário cadastrar uma nova categoria no sistema.
- Toda categoria tem:
    - Um título
    - Um resumo do que vai ser encontrado no livro
    - Um sumário de tamanho livre. O texto deve entrar no formato markdown, que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
    - Preço do livro
    - Número de páginas
    - Isbn(identificador do livro)
    - Data que ele deve entrar no ar(de publicação)
    - Um livro pertence a uma categoria
    - Um livro é de um autor

# 2 - VALIDAÇÕES

- Título é obrigatório
- Título é único
- Resumo é obrigatório e tem no máximo 500 caracteres
- Sumário é de tamanho livre.
- Preço é obrigatório e o mínimo é de 20
- Número de páginas é obrigatória e o mínimo é de 100
- Isbn é obrigatório, formato livre
- Isbn é único
- Data que vai entrar no ar precisa ser no futuro
- A categoria não pode ser nula
- O autor não pode ser nulo

# 3 - RESULTADO ESPERADO

- Um novo livro criado e status 201 retornado
- Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação