Feature: Cadastro de contas
  Como um usuario
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Scenario: Deve inserir uma conta com sucesso
    Given que estou acessando a aplicacao
    When informo o usuario "felipeam10@hotmail.com"
    And a senha "123456"
    And seleciono entrar
    Then visualizo a pagina inicial
    When seleciono Contas
    And seleciono Adicionar
    And informo a conta "Conta de Teste"
    And seleciono Salvar
    When a conta eh inserida com sucesso

  @ignore
  Scenario: Não deve inserir uma conta sem nome
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And seleciono Salvar
    Then sou notificar que o nome da conta é obrigatório

  @ignore
  Scenario: Não deve inserir uma conta com nome já existente
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And informo a conta "Conta de Teste"
    And seleciono Salvar
    Then sou notificado que já existe uma conta com esse nome