# Como o Backend Funciona

* O desenvolvimento *web* é composto por duas partes principais: o **frontend** e o **backend**. 
* O frontend se preocupa com a apresentação visual da aplicação e costuma ser fácil de entender, pois é com ele que interagimos diariamente na *web*. 
* O backend, por outro lado, são todas as partes da *web* com as quais os usuários não interagem diretamente. 
* Nesta aula, vamos discutir o básico de como funciona o backend de um *site*, rastreando todas as etapas pelas quais o backend deve passar desde o momento em que recebe uma **requisição** até o ponto em que envia uma **resposta** de volta ao cliente.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193266975-d248162a-b128-41f8-ba03-a90a1ac47910.png" alt="Frontend vs. Backend" width="75%" align="center" />
</div>
</br>

## Requisição (*Request*)

* A princípio, o servidor recebe uma requisição de um cliente na forma de uma **URL**.
* A partir dessa URL, o servidor pode obter quase todas as informações necessárias para processar a solicitação. 
* Vamos separar uma URL típica:

  ```
  http://example.com/path?query=value
  ```

## Protocolo HTTP vs. HTTPS

* No início, temos o protocolo para a solicitação `http://`.
* A única coisa que o protocolo faz é informar ao servidor se a requisição está criptografada. 
* **HTTP** é para solicitações não criptografadas padrão e **HTTPS** é para solicitações criptografadas. 
* Além de informar ao servidor se a resposta é criptografada ou não, o protocolo não afeta a maneira como o servidor trata as solicitações e pode ser ignorado.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193267113-a362ed57-c022-4f56-a55e-958b41e1005e.png" alt="HTTP vs. HTTPS" width="75%" align="center" />
</div>
</br>

## Servidor 

* Em seguida, temos o *host* `example.com`, conhecido como nome de **domínio**. Novamente, não é importante se preocupar com os detalhes disso, pois tudo o que ele faz é informar à Internet para qual servidor enviar a resposta. 
* Cada servidor tem seu próprio *host* específico, portanto, uma vez que a requisição realmente chega ao servidor, o *host* não importa, pois todas as requisições para o servidor terão o mesmo *host*.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193267209-7e1f70a1-813c-466f-8960-77a5d3f3fc2c.png" alt="Servidor" width="75%" align="center" />
</div>
</br>

* Por exemplo, `youtube.com` é o *host* do servidor do YouTube, portanto, o servidor do YouTube já sabe que todas as requisições que receber terão o *host* `youtube.com`.
* Isso significa que podemos ignorar com segurança a primeira metade da URL, o que nos deixa com as duas últimas seções da URL: o ***path*** (caminho) e ***query string*** (string de consulta).
  * O caminho `/path` (ou rota) informa ao servidor o que o cliente deseja e define qual **seção** de código no servidor deve ser executada para obter a resposta correta. Essencialmente, o servidor é dividido em várias seções diferentes que correspondem a um caminho específico.
  * Por último, a *query string* `?query=value` é usada pela seção específica do servidor para alterar a resposta.

## Parâmetros da Requisição

* A string de consulta é dividida em **parâmetros** de consulta específicos que podem aumentar a maneira como o servidor responde a uma solicitação de um caminho específico.

  ```
    https://www.youtube.com/results?search_query=cats
  ```

* Por exemplo, o YouTube usa o mesmo caminho `/results` quando você pesquisa um vídeo, mas a string de consulta contém um parâmetro *search_query* `?search_query=cats` que informa ao servidor o que você pesquisou para que ele possa responder com o que você deseja.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193267396-1e83cf47-3982-40d8-9841-bb4342aa3920.png" alt="Parâmetro search_query" width="75%" align="center" />
</div>
</br>

## Métodos HTTP

* A URL por si só não é suficiente para dizer ao servidor exatamente o que ele precisa fazer. 
* Ela pode dizer ao servidor qual seção procurar e como alterar essa seção com base nos parâmetros de consulta, mas essa seção do servidor é dividida ainda mais em várias partes diferentes. 
* Para determinar qual parte dessa seção o servidor deve executar, ele precisa usar uma **ação** (ou **método**) que é passada junto com a URL. 
* Essa ação pode ser **GET**, **POST**, **PUT** ou **DELETE**.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193267447-9e4847c8-97d8-42ea-adc6-20fa885ca37a.png" alt="Métodos HTTP" width="75%" align="center" />
</div>

## Resposta (*Response*)

* Ao combinar o método HTTP e o caminho, o servidor pode encontrar a parte correta da seção correta que precisa ser executada. Ele pode então usar os parâmetros de consulta para alterar a resposta dessa parte e seção específica.
* A resposta do servidor poderá ser uma página HTML que é gerada dinamicamente com base na solicitação do cliente. Outros arquivos podem ser retornados, como [JSON](https://www.json.org/json-pt.html) e [XML](https://pt.wikipedia.org/wiki/XML), por exemplo.
* É por isso que quando você acessa a página de pesquisa do YouTube, ela sempre mostra a mesma página, pois possui o mesmo caminho e ação, mas os vídeos retornados da sua pesquisa são diferentes com base no parâmetro de consulta da sua pesquisa.

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/193267519-279b5f05-0dd8-48fb-b833-d3ade78a6274.png" alt="Resposta" width="75%" align="center" />
</div>
</br>

* Outra coisa importante a ser observada sobre um servidor é que ele só é acessível ao mundo exterior através das seções que ele define. 
* Isso significa que você pode armazenar qualquer informação segura no servidor e ela estará segura desde que não seja exposta por meio de um caminho específico. 
* É por isso que é seguro ter um **banco de dados** e um *site* rodando no mesmo servidor, já que o servidor escolhe apenas expor o *site* e não o banco de dados. 
* Essencialmente, o servidor atua como uma barreira entre o mundo exterior e todas as partes de um *site*.