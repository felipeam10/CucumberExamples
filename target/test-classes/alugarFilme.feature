Feature: Alugar filme
  Como um usuario
  Eu quero cadatrar alugueis de filmes
  Para controlar precos e datas de entregas

  Scenario: Deve alugar filme com sucesso
    Given um filme com estoque de 2 unidades
    And que o preco do aluguel seja R$ 3
    When alugar
    Then o preco do aluguel sera R$ 3
    And a data entrega sera no dia seguinte
    And o estoque do filme sera 1 unidade


  Scenario: Nao deve alugar filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then nao sera possivel por falta de estoque
    And o estoque do filme sera 0 unidade

  Scenario: Deve dar condicoes especiais para categoria extendida
    Given um filme com estoque de 2 unidades
    And o preco de aluguel seja R$ 4
    And o tipo de aluguel seja extendido
    When alugar
    Then o preco do aluguel sera R$ 8
    And a data de entrega sera em 3 dias
    And a pontuacao recebida sera de 2 pontos