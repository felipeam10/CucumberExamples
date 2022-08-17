Feature: Cadastro de contas
  Como um usuario
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Background:
    Given que estou acessando a aplicacao
    When informo o usuario "felipeam10@hotmail.com"
    And a senha "123456"
    And seleciono entrar
    Then visualizo a pagina inicial
    When seleciono Contas
    And seleciono Adicionar


  Scenario Outline: Deve validar regras cadastro contas
    When informo a conta "<conta>"
    And seleciono Salvar
    Then recebo a mensagem "<mensagem>"

  Examples:
    | conta             | mensagem                            |
    | Conta de Teste    | Conta adicionada com sucesso!       |
    |                   | Informe o nome da conta             |
    | Conta mesmo nome  | Já existe uma conta com esse nome!  |


#  #@ignore
#  Scenario: Deve inserir uma conta com sucesso
#    And informo a conta "Conta de Teste"
#    And seleciono Salvar
#    When a conta eh inserida com sucesso
#
#  #@ignore
#  Scenario: Nao deve inserir uma conta sem nome
#    And seleciono Salvar
#    Then sou notificado que o nome da conta eh obrigatorio
#
#  #@ignore
#  Scenario: Nao deve inserir uma conta com nome ja existente
#    And informo a conta "Conta de Teste"
#    And seleciono Salvar
#    Then sou notificado que ja existe uma conta com esse nome