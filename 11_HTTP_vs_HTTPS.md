# Qual é a diferença entre HTTP e HTTPS?

Você já deve ter visto websites que possuem em sua URL o símbolo de um cadeado e o nome HTTPS logo ao lado. Para entender essa diferença, vamos considerar a seguinte aplicação web na qual um usuário de uma empresa (vamos chamá-lo de João), está usando apenas o protocolo HTTP, ou seja, o modo “Não seguro”:

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/364760b5-af14-4331-83b2-11e97d80bd82)

Observe que ele coloca seu e-mail e senha, e então, clica no botão Logar. Até o momento não vimos nenhum problema, certo?

## Conhecendo o cenário problemático
Entretanto, esta aplicação se encontra dentro de um ambiente corporativo, portanto, existem vários funcionários. Então um desses outros funcionários, o chamaremos de Pedro, decide fazer alguns testes na rede corporativa.

Nesses testes, o Pedro altera os protocolos de comunicação entre o João que está acessando a aplicação web e o roteador, e então o Pedro acaba ficando no meio dessa comunicação entre o João e o roteador.

Em seguida, o Pedro de curiosidade, acaba instalando em sua máquina um programa capaz de analisar os protocolos que trafegam na comunicação entre o João e o roteador. Então, ele configura o programa para analisar toda comunicação via protocolo HTTP.

Nesse mesmo instante, quando o João tenta acessar novamente o sistema web, aparece o seguinte resultado para o Pedro, nosso funcionário curioso:

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/15852675-1ead-443c-8b73-b70f566a1919)

Veja só o que Pedro obteve. Ele conseguiu ver o usuário e senha que foram digitados pelo João (usuário: joao@gmail.com e senha: 123456). Mas como foi possível conseguir essas informações??

## Entendendo o princípio do protocolo HTTP
As comunicações em uma rede são feitas por um conjunto de regras e procedimentos chamadas de protocolo Link. O protocolo HTTP, Hypertext Transfer Protocol, foi inicialmente desenvolvido para permitir a comunicação com um servidor web, a princípio, o método existente era apenas o de “pegar” (GET) o conteúdo de um servidor.

Com o passar do tempo, surgiu a necessidade de não somente pedir informações do servidor, mas também de passar as informações. Atualmente sabemos que na Web, não apenas pedimos como também mandamos informações, certo? Como é o caso de uma compra na internet. Mas o que acontece se esse for um dado sensível como os dados e senha do cartão de crédito?

Analisando o nome do protocolo HTTP, vemos que se trata de um protocolo para transferência de texto, dessa forma, os dados e senha do cartão de crédito são passados como um texto para o servidor também!

Isso significa que, se caso alguém analisar essas informações será capaz de ver quais são os dados e senha do cartão de crédito. Portanto, quaisquer aplicações web que usam o protocolo HTTP e precisam passar dados sensíveis, possuem uma vulnerabilidade para o cliente final.

Tendo ciência de todo esse problema, todo o site que opera no protocolo HTTP, precisa, de alguma forma, encontrar algum meio de se proteger, certo? É nesse momento que o HTTPS entra como um grande aliado! Mas o que o protocolo HTTPS faz para resolver essa vulnerabilidade?

## Conhecendo o protocolo HTTPS
Agora, ao invés de analisar um site “Não seguro”, isto é com o protocolo HTTP, faremos a análise em um site “Seguro” que trabalha com o HTTPS.

Nesse nosso exemplo, consideraremos a página de login abaixo usando os mesmos dados que usamos na aplicação que estava usando o HTTP. Vejamos o resultado:

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/11dd808a-ba36-4feb-9c56-856cb7657c15)

Perceba que a informação não faz sentido algum para nós humanos. O que aconteceu dessa vez?

O HTTPS fez uma transformação nesses dados que foi enviado pelo cliente e com isso não foi possível descobrir os dados enviados pela vítima. Essa tranformação de um dado que acaba por ser incompreensível por nós humanos caracterizamos como um processo de criptografia.

Agora, como será que esse processo de criptografia do HTTPS é realizado?

## Compreendendo o processo do HTTPS
Vamos analisar o seguinte caso, imagine que duas pessoas, Roberto e Luísa queiram enviar uma carta, o Roberto inicia o processo de comunicação enviando essa carta para a Luísa, porém essa carta é confidencial e não deve ser lida por outra pessoa que não seja a Luísa.

### Processo de chaves simétricas
A fim de evitar que outra pessoa leia o conteúdo dessa carta, o Roberto decide colocá-la em uma caixa com um cadeado, ele a tranca com uma chave e posteriormente vai até o correio enviar a carta.

A Luísa recebe a caixa e utiliza uma cópia da chave idêntica a do Roberto para abrir a caixa e ler o conteúdo da carta. Para responder a mensagem recebida, a Luísa coloca de volta o cadeado e usa a mesma chave para trancar a caixa e enviar a caixa pelos correios.

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/fe01a682-cac6-4509-ba31-77a43a8a923b)

Perceba que só temos uma chave nesse processo, a mesma chave é usada para trancar a caixa (criptografar) e destrancar a caixa (descriptografar). Quando temos a mesma chave utilizada para criptografar e descriptografar um dado, chamamos esse processo de criptografia de chave simétrica. Exemplos de alguns algoritmos que utilizam esse sistema de chave simétrica:

* DES (Data Encryption Standard)
* AES (Advanced Encryption Standard)

Uma vez que a mesma chave é usada para realizar a criptografia e a descriptografia, é necessário encontrar uma forma de enviar essa chave ao destinatário (caso ele ainda não tenha) para que ele possa assim destrancar a caixa e ler o conteúdo da carta (descriptografar).

Mas veja só o que temos, se a mesma chave é usada para trancar (criptografar) e destrancar (descriptografar), o que aconteceria se alguém conseguisse interceptar essa chave? Essa pessoa conseguiria utilizá-la para poder ver as informações passadas e continuaríamos tendo o mesmo problema não é mesmo? E agora?

Desse modo, somente a utilização desse processo de chaves simétricas durante as etapas de comunicação pode não resolver completamente o problema e por isso uma nova forma de criptografia também foi desenvolvida para complementar a utilização das chaves simétricas. Vamos voltar ao exemplo anterior.

### Processo de chaves assimétricas
Nós temos o Roberto e a Luísa, o Roberto deseja enviar uma carta com conteúdo confidencial para a Luísa. A ideia agora é que o Roberto utilizará um cadeado especial e tal cadeado terá 3 posições:

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/8a221118-84e1-4491-9de3-d720c9def606)

Além disso, o Roberto terá agora duas chaves, a primeira chave só poderá ser utilizada na ordem crescente (posição 1, 2 e 3) e a outra chave só poderá ser usada na posição decrescente (posição 3, 2 e 1).

O Roberto decide trancar a caixa com a primeira chave, a que consegue operar o cadeado na ordem crescente. Dessa forma, para poder trancar a caixa, ela estará agora na posição 3. Essa chave o Roberto não enviará para ninguém, é a chave exclusiva dele, chamaremos essa chave de chave privada.

A segunda chave que opera na ordem decrescente (posição 3, 2 e 1), será usada para enviar para a Luísa, como estamos enviando essa segunda chave para outra pessoa, a chamaremos de chave pública.

Quando a caixa chegar até a Luísa, ela estará trancada na posição 3. Com a chave pública que a Luísa recebeu, ela consegue operar na ordem decrescente e voltar o cadeado para a posição 2 (posição destrancada) e abrir a caixa, lendo assim o conteúdo da carta.

A Luísa ao responder a mensagem irá trancar com a chave pública. Lembre-se que a chave pública só funciona no sentido decrescente, dessa forma, como ela está na posição 2 (destrancada), ela só poderá ir para a posição 1 para trancá-la novamente. Uma vez que o Roberto receber a caixa, ele poderá usar sua chave privada (aquela que ele guardou para si e não distribui para ninguém e só funciona na ordem crescente) para voltar o cadeado para a posição 2 (destrancada) e poder assim abrir o conteúdo da mensagem.

![image](https://github.com/alexandresjunior/java-web-spring-boot/assets/83607914/74f4c25c-4159-4bb7-bff2-929a8fc7715e)

Perceba que agora temos duas chaves, uma chave privada e uma chave pública, sendo que quando uma chave é usada para trancar a caixa (criptografar) a outra chave é usada para destrancar a caixa (descriptografar). Quando temos duas chaves, chamamos esse processo de criptografia de chave assimétrica. Exemplos de alguns algoritmos que utilizam esse sistema de chave assimétrica:

* RSA (Sendo as iniciais dos sobrenomes de seus desenvolvedores: Ron Rivest, Adi Shamir, e Leonard Adleman)
* DSA (Digital Signature Algorithm)

## Implementação do protocolo de segurança do HTTPS
Os princípios de chaves simétricas e assimétricas serão usados pelo HTTPS durante o processo de comunicação. Dentro do HTTPS existe um protocolo responsável por inserir essa camada de criptografia, vamos conhecer algum deles:

### SSL
O primeiro protocolo desenvolvido para esse fim foi de autoria da empresa Netscape e recebeu o nome de Secure Sockets Layer 1.0, ou mais popularmente conhecido como SSL v1.0. O protocolo SSL sofreu modificações e melhorias até chegar na sua última versão, SSL v3.0.

Porém ao longo dos anos foram descobertas algumas vulnerabilidades nesse protocolo, uma dessas vulnerabilidades poderia expor informações criptografadas e acabou sendo chamada de Poodle (Padding Oracle on Downgraded Legacy Encryption) , para mais detalhes segue link do governo norte-americano alertando sobre tal vulnerabilidade descoberta no protocolo SSL.

### TLS
Uma vez que o protocolo SSL v3.0 apresentou essas vulnerabilidades foi necessário o desenvolvimento de um novo tipo de protocolo para atribuir essa camada de criptografia de uma maneira mais segura.

Esse novo protocolo recebeu o nome de Transport Layer Security, TLS 1.0 sofrendo adaptações e melhorias ao passar do tempo chegando na versão mais atual até o momento de escrita desse post, a versão TLS 1.2

O principio de utilização do TLS é unir as forças das chaves assimétricas e simétricas durante o processo de comunicação. Uma vez que as chaves assimétricas possuem um processo de criptografia envolvendo duas chaves distintas, consequentemente há um maior tempo de processamento. Por isso o TLS utiliza esse processo na fase de autenticação entre o cliente e o servidor.

Em seguida, ele faz uso das chaves simétricas que possuem um processo de criptografia com apenas uma chave, logo, necessita de menos tempo para seu processamento.

Uma vez que podemos ter uma grande quantidade de dados sendo transmitidos, as chaves simétricas serão mais rápidas para processar toda essa informação e será utilizado na fase de transporte dos dados, também conhecido como bulk.
1 - trancado 2 - destrancado 3 - trancado
