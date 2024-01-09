# 1 - NECESSIDADES

- É necessário cadastrar um novo autor no sistema.
- Todo autor tem:
    - nome
    - email
    - descrição
    - data criação

# 2 - VALIDAÇÕES

- O instante não pode ser nulo
- O email é obrigatório
- O email tem que ter formato válido
- O email é único
- O nome é obrigatório
- O nome é único
- A descrição é obrigatória e não pode passar de 400 caracteres resultado esperado

# 3 - RESULTADO ESPERADO

- Um novo autor criado e status 201 retornado
- Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação