# Inova Asset Management


A **Inova Asset Management** é uma Gestora de fundos de investimento que deseja se posicionar no
mercado de Investimentos. Para auxiliar a empresa no atingimento deste objetivo foi solicitado a você
que crie um projeto web onde será exibido o portfólio da Empresa, que atualmente administra 5 fundos
de investimento. Como forma de ampliar sua base de clientes, deve ser criada uma página no projeto
que dê sugestões de fundos de investimento mais adequados aos clientes, levando-se em conta o perfil
de investidor que pode ser conservador, moderado ou arrojado. Esta página deve exibir as três opções
de perfil de investidor do cliente e após selecionar uma das opções o sistema deve exibir até 3 (três)
fundos mais adequados àquele perfil definido.

Como premissa, consideramos que os clientes são classificados em:
- a. Conservador – Não quer correr nenhum ou poucos riscos;
- b. Moderado – Aceita correr um certo risco nas aplicações;
- c. Arrojado – Aceita correr mais riscos para ter mais rentabilidade.

Para subsidiar a criação do projeto disponibilizamos o arquivo fundos.csv contendo os dados cadastrais
dos fundos de investimento da Inova Asset Management e outro arquivo cotas.csv contendo
respectivamente os valores das cotas destes fundos nos últimos 12 meses.

Como regra de recomendação de 3 fundos para cada perfil, primeiro o fundos foram ordenados por nivel de risco, do baixo até alto, e em seguida ordenados pelo desvio padrão historico do fundo. Com os fundo ordenados a pagina recomenda os 3 primeiros fundos para o perfil Conservador, os 3 fundos mais proximos a mediana para o perfil Moderado e os 3 últimos fundos para o perfil Arrojado.

---
## Frontend 

### Tela Inicial

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-inicial.PNG)


### Tela Conservador

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-conservador.PNG)

### Tela Moderado

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-moderado.PNG)

### Tela Arrojado

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-arrojado.PNG)
