# Roteiro de execução

    Para criar e popular o banco de dados deve se executar o comando abaixo dentro da pasta db/Derby:  

    'java Dderby.system.home=<Local_do_banco_de_dados_no_projeto> -Dij.protocol=jdbc:derby: -jar <local_de-instalação_do_Derby>/lib/derbyrun.jar ij'

    E então exeutar o comando abaixo para criar e polular o banco:

    'run 'create.sql';'

    Após isso no terminal executar o servidor tomcat e Derby.

    Realizar o deploy do sistema.

# Usuarios
    Admin:
            Login: a1
            Senha: senha1
    
    Usuarios:
            Login: b2
            Senha: senha2
            
            Login: c3
            Senha: senha3
            
    Locadoras:
            Login: dd@d.com
            Senha: senha4
            
            Login: ee@e.com
            Senha: senha5
            
    Esses cadastros são criados por padrao com nosso create.sql, é possivel criar novos alterando esse arquivo ou adicionar/remover quando estiver logado como Admin
    


# Divisão de requisitos

    Todos os requisitos foram implementados. 

    Não foi possivel realizar a separação da contribuição de cada membro,
    tivemos muitos bugs e não necessariamente quem arrumou foi quem iniciou o requisito,
    sendo assim fica muito difícil quantificar a contribuição de cada um, mas todos se dedicaram 
    no projeto e conhecem todas as partes.



 
