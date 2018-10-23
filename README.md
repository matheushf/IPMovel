Mensagem - correspondente - agente home -> (verificar tabela roteamento ) - agente movel - agente estrangeiro - no movel

1 - Quatro servers vão ficar ligados, 2 NoMovel, 1 Home Agent e 1 Foreign Agent

2 - Ao enviar uma mensagem, já está definido para qual IP e CoA (inicialmente HomeAgent) que ela será direcionada

3 - Verificar na tabela de roteamento do Home Agent para ver a qual CoA o ip pertence

4 - Caso seja o mesmo do Home Agent, entregar a mensagem

4.5 - Caso não esteja, identificar qual é seu CoA

5 - Conectar ao Foreign Agent com seu CoA

6 - Entregar a mensagem para o IP dentro do Foreign Agent
