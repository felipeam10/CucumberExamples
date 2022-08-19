@unitarios
Feature: Alugar filme
  Como um usuario
  Eu quero cadatrar alugueis de filmes
  Para controlar precos e datas de entregas

  Scenario: Deve alugar filme com sucesso
    Given um filme
        | estoque | 2     |
        | preco   | 3     |
        | tipo    | comum |
    When alugar
    Then o preco do aluguel sera R$ 3
    And a data de entrega sera em 1 dia
    And o estoque do filme sera 1 unidade

  Scenario: Nao deve alugar filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then nao sera possivel por falta de estoque
    And o estoque do filme sera 0 unidade

  Scenario Outline: Deve dar condições conforme tipo de aluguel
    Given um filme com estoque de 2 unidades
    And o preco de aluguel seja R$ <preco>
    And o tipo de aluguel seja <tipo_aluguel>
    When alugar
    Then o preco do aluguel sera R$ <valor>
    And a data de entrega sera em <qtdDias> dias
    And a pontuacao recebida sera de <pontuacao> pontos

  Examples:
    | preco | tipo_aluguel | valor | qtdDias | pontuacao |
    |  4    |  extendido   |   8   |   3     |    2      |
    |  4    |  comum       |   4   |   1     |    1      |
    |  10   |  extendido   |   20  |   3     |    2      |
    |  5    |  semanal     |   15  |   7     |    3      |

#  Scenario: Deve dar condicoes especiais para categoria extendida
#    Given um filme com estoque de 2 unidades
#    And o preco de aluguel seja R$ 4
#    And o tipo de aluguel seja extendido
#    When alugar
#    Then o preco do aluguel sera R$ 8
#    And a data de entrega sera em 3 dias
#    And a pontuacao recebida sera de 2 pontos
#
#  Scenario: Deve alugar para categoria comum
#    Given um filme com estoque de 2 unidades
#    And o preco de aluguel seja R$ 4
#    And o tipo de aluguel seja comum
#    When alugar
#    Then o preco do aluguel sera R$ 4
#    And a data de entrega sera em 1 dia
#    And a pontuacao recebida sera de 1 pontos