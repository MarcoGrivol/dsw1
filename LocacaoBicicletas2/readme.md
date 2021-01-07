# Instrucoes
1. Rodar o arquivo create.sql e iniciar o servidor
2. Executar o spring

# Requisitos
O sistema deve possuir um cadastro de clientes, com os seguintes dados: e-mail, senha, CPF,
nome, telefone, sexo e data de nascimento.

O sistema deve possuir um cadastro de locadoras, com os seguintes dados: e-mail, senha, CNPJ,
nome e cidade.

O sistema deve possuir um cadastro de locações, com os seguintes dados: cliente, locadora e
dia/horário da locação. Assume-se que a duração da locação é de 1 hora e sempre inicia-se em
“hora cheia” (13h 00min etc)

## Requer login de administrador (user_login("admin") + senha("admin))
* ~~R1: CRUD de clientes~~
* ~~R2: CRUD de locadoras~~

## Requer login do cliente (email + senha)
* ~~R5: Locação de uma bicicleta em uma locadora. Depois de fazer login, o cliente pode cadastrar uma locação. Para isso, deve escolher uma locadora (escolhendo a partir de uma lista), uma data, e deve ser gravado a locação na base.~~
de dados.
* ~~R6: Listagem de todas as locações de um cliente. Depois de fazer login, o cliente pode visualizar todas as suas locações gravadas.~~

## Requer login da locadora (email + senha)
* ~~R8: Listagem de todas as locações de uma locadora. Depois de fazer login, a locadora pode visualizar todas as suas locações gravadas.~~

## Nao requer login
* ~~R3: Listagem de todos as locadoras em uma única página~~
* ~~R4: Listagem de todos as locadoras por cidade. Preferencialmente a cidade deveria ser escolhida através de uma lista.~~

## Requisitos funcionais
* ~~R7: O sistema não deve permitir o cadastro de locações de um mesmo cliente ou de um mesma locadora em um mesmo dia/horário.~~
* R9: O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro
de sua escolha.
* ~~R10: O sistema deve validar (tamanho, formato, etc) todas as informações (campos nos formulários) cadastradas e/ou editadas.~~
