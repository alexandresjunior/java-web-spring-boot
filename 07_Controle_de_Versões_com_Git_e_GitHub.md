# Controle de Versões com Git and GitHub

## Introdução

Bem-vindxs! Nesta aula, aprenderemos a usar o Git e o GitHub para nos ajudar no desenvolvimento de aplicações web.

## Git

* [Git](https://git-scm.com/) é uma ferramenta de linha de comando que nos ajudará no controle de versão de várias maneiras:
  * Permitindo-nos acompanhar as alterações que fazemos em nosso código, salvando *snapshots* de nosso código em um determinado momento.  
    </br>
    <div align="center">
      <img src="https://user-images.githubusercontent.com/83607914/185609775-dd02827b-1c4d-4c44-a376-33d38f41c4b5.png" alt="Changing File" width="75%" align="center"/>
    </div>
    </br>
  * Permitindo-nos sincronizar facilmente o código entre diferentes pessoas que trabalham no mesmo projeto, permitindo que várias pessoas extraiam informações e enviem informações para um repositório armazenado na web.    
    </br>
    <div align="center">
      <img src="https://user-images.githubusercontent.com/83607914/185609839-405ffc54-59df-4355-8e57-f34a7a7e76f9.png" alt="Multiple Users" width="75%" align="center"/>
    </div>
    </br>
  * Permitindo-nos fazer alterações e testar o código em uma *branch* diferente sem alterar nossa base de código principal e, em seguida, mesclar os dois.
  * Permitindo-nos reverter para versões anteriores do nosso código se percebermos que cometemos um erro.
* Nas explicações acima, usamos a palavra **repositório**, que ainda não explicamos. Um repositório Git é um local de arquivo onde armazenaremos todos os arquivos relacionados a um determinado projeto. Eles podem ser **remotos** (armazenados *online*) ou **locais** (armazenados em seu computador).

## GitHub

* [GitHub](https://www.github.com/) é um site que nos permite armazenar repositórios Git remotamente na web.
* Vamos começar criando um novo repositório online:
   1. Verifique se você tem uma conta do GitHub configurada. Se você ainda não tem uma, pode criar uma [aqui](https://github.com/join?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home).
   2. Clique no **+** no canto superior direito e clique em "Novo repositório"
   3. Defina um nome para o repositório que descreva seu projeto
   4. (Opcional) Forneça uma descrição para seu repositório
   5. Escolha se o repositório deve ser público (visível para qualquer pessoa na web) ou privado (visível apenas para você e outras pessoas a quem você concede acesso especificamente)
   6. (Opcional) Decida se deseja adicionar um README, que é um arquivo que descreve seu novo repositório.
    </br>
    <div align="center">
      <img src="https://user-images.githubusercontent.com/83607914/185610289-deb4cdc3-f474-42af-805d-f1d7ca9fe2fa.png" alt="Create New Repository" align="center"/>
    </div>
    </br>
* Com o repositório criado, provavelmente vamos querer adicionar alguns arquivos a ele. Para fazer isso, pegaremos nosso repositório *remoto* recém-criado e criaremos uma cópia, ou "clone", dele como um repositório *local* em nosso computador.
   1. Certifique-se de ter o git instalado em seu computador digitando `git` no seu terminal. Se não estiver instalado, você pode baixá-lo [aqui](https://git-scm.com/downloads).
   2. Clique no botão verde “Clone or Download” na página do seu repositório e copie o URL que aparece. Se você não criou um README, este link aparecerá próximo ao topo da página na seção “Configuração Rápida”.  
      </br>
      <div align="center">
        <img src="https://user-images.githubusercontent.com/83607914/185610899-3b2bfa8a-53c4-4f2a-a529-5aedbde52726.png" alt="git clone" width="75%" align="center"/>
      </div>
      </br>
  3. No seu terminal, execute `git clone <repository url>`. Isso fará o download do repositório para o seu computador. Se você não criou um README, você receberá o aviso: `You appear to have cloned into an empty repository`. Isso é normal e não há necessidade de se preocupar com isso.   
      ```
      $ git clone https://github.com/alexandresjunior/git-samples.git
      Cloning into 'git-samples'...
      remote: Enumerating objects: 3, done.
      remote: Counting objects: 100% (3/3), done.
      remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
      Receiving objects: 100% (3/3), done. 
      ```
   4. Execute `ls`, que é um comando que lista todos os arquivos e pastas em seu diretório atual. Você deve ver o nome do repositório que acabou de clonar.
   5. Execute `cd <nome do repositório>` para mudar o diretório para essa pasta.
   6. Execute `touch <new file name>` para criar um novo arquivo nessa pasta. Agora você pode fazer edições nesse arquivo. Como alternativa, você pode abrir a pasta em seu editor de texto preferido e adicionar manualmente novos arquivos.
   7. Agora, para que o Git saiba que ele deve rastrear o novo arquivo que você criou, execute `git add <new file name>` para rastrear esse arquivo específico, ou `git add .` para rastrear todos os arquivos dentro desse diretório.   
      ```
      $ ls
      hello.html  README.md
      ```

## Commits

* Agora, vamos começar a entender para que o Git pode ser realmente útil. Depois de fazer algumas alterações em um arquivo, podemos *commitar* essas alterações, tirando um *snpshot* do estado atual do nosso código. Para fazer isso, executamos: `git commit -m "algyma mensagem"` onde a mensagem descreve as alterações que você acabou de fazer.
* Após essa alteração, podemos executar o `git status` para ver como nosso código se compara ao código no repositório remoto.
* Quando estivermos prontos para publicar nossos commits locais no Github, podemos executar o `git push`. Agora, quando formos ao GitHub em nosso navegador da web, nossas alterações serão refletidas.
* Se você alterou apenas os arquivos existentes e não criou novos, em vez de usar `git add .` e depois `git commit...`, podemos condensar isso em um comando: `git commit -am "some message" `. Este comando confirmará todas as alterações que você fez.
* Às vezes, o repositório remoto no GitHub estará mais atualizado do que a versão local. Nesse caso, você deseja primeiro confirmar as alterações e, em seguida, executar o `git pull` para puxar as alterações remotas para o seu repositório.

## Resolvendo Conflitos

* Um problema que pode surgir ao trabalhar com o Git, especialmente quando você está colaborando com outras pessoas, é algo chamado de **conflitos** ao mesclar duas ou mais *branches*. Um conflito ocorre quando duas pessoas tentam alterar um arquivo de maneira conflitante entre si.
* Isso normalmente ocorrerá quando você executar `git push` ou `git pull`. Quando isso acontecer, o Git mudará automaticamente o arquivo para um formato que descreva claramente qual é o conflito. Aqui está um exemplo em que a mesma linha foi adicionada de duas maneiras diferentes:
  ```
  a = 1
  <<<<< HEAD
  b = 2
  =====
  b = 3
  >>>>> 56782736387980937883
  c = 3
  d = 4
  e = 5
  ```
* No exemplo acima, você adicionou a linha `b = 2` e outra pessoa escreveu `b = 3`, e agora devemos escolher uma delas para manter. O número `56782736387980937883` é um *hash* que representa o *commit* que está em conflito com suas edições. Muitos editores de texto também fornecem destaque e opções simples, como “aceitar atual” ou “aceitar mudança”, que economizam o tempo de exclusão das linhas adicionadas acima.
* Outro comando git potencialmente útil é o `git log`, que fornece um histórico de todos os seus commits nesse repositório.
  ```
  $ git log
  commit e37edec6d3ad39657aadd51284add976ec01797f (HEAD -> main)
  Author: Alexandre de Souza Jr <83607914+alexandresjunior@users.noreply.github.com>
  Date:   Fri Aug 19 08:55:30 2022 -0300

      Add message to hello.html file

  commit dae29e8c34095a7cbdb1067904b5bc242dad7f0c
  Author: Alexandre de Souza Jr <83607914+alexandresjunior@users.noreply.github.com>
  Date:   Fri Aug 19 08:55:05 2022 -0300

      Create hello.html file

  commit eb3260efc7c1477bec79f8756fcceb4ffe74d580 (origin/main, origin/HEAD)
  Author: Alexandre de Souza Jr <83607914+alexandresjunior@users.noreply.github.com>
  Date:   Fri Aug 19 08:40:45 2022 -0300

      Initial commit
  ```
* Potencialmente ainda mais útil, se você perceber que cometeu um erro, poderá reverter para um *commit* anterior usando o comando `git reset` de duas maneiras:
   * `git reset --hard <commit>` reverte seu código exatamente como estava após o *commit* especificado. Para especificar o *commit*, use o *hash commit* associado a um *commit* que pode ser encontrado usando `git log` como mostrado acima.
   * `git reset --hard origin/master` reverte seu código para a versão atualmente armazenada online no Github.

## Trabalhando com Branches

Depois de trabalhar em um projeto por algum tempo, você pode desejar adicionar um recurso adicional. Podemos então *commitar* alterações referentes a esse novo recurso, conforme mostrado no gráfico abaixo:
    </br>
    <div align="center">
      <img src="https://user-images.githubusercontent.com/83607914/185611863-6247da99-e05c-47b4-94fd-9d2fd5119bd2.png" alt="No Branch" width="75%" align="center"/>
    </div>
    </br>
Mas isso pode se tornar problemático se descobrirmos um *bug* em nosso código original e quisermos reverter sem alterar o novo recurso. É aqui que o uso de `branches` (ramificações) pode se tornar realmente útil.
* `Branch` é um método de se mover para uma nova direção ao criar um novo recurso e só combinar esse novo recurso com a parte principal do seu código, ou a ramificação principal (*branch main*), quando terminar. Este fluxo de trabalho será mais parecido com o gráfico abaixo:

<div align="center">
  <img src="https://user-images.githubusercontent.com/83607914/185612001-9afa3ae7-32e4-4319-b001-647e474ec37b.png" alt="Branch" width="75%" align="center"/>
</div>
</br>

* A *branch* que você está olhando no momento é determinada pelo `HEAD`, que aponta para uma das duas *branches*. Por padrão, o `HEAD` é apontado para a *branch main* (ou *master*), mas também podemos fazê-lo apontar para outras *branches* também.
* Agora, vamos ver como realmente implementamos a *branch* em nossos repositórios git:
   1. Execute `git branch` para ver em qual *branch* você está trabalhando no momento, que terá um asterisco à esquerda do nome.
    ```
    $ git branch
    * main
    ```
  2. Para criar uma nova *branch*, vamos executar `git checkout -b <noma-da-nova-branch>`
    ```
    $ git checkout -b novo_recurso
    Switched to a new branch 'novo_recurso'
    ```
    ```
    $ git branch
      main
    * novo_recurso
    ```
  3. Alterne entre as *branches* usando o comando `git checkout <nome-da-branch>` e confirme as alterações em cada *branch*.
  4. Quando estivermos prontos para mesclar nossas duas *branches*, executamos o `git checkout` para a *branch* que desejamos manter (quase sempre a *branch main* e então executamos o comando `git merge <nome-da-outra-branch>`. Isso será tratado de forma semelhante a um `push` ou `pull`, e podem aparecer conflitos durante o *merge*.

## Mais recursos do GitHub

Existem alguns recursos úteis específicos do GitHub que podem ajudar quando você estiver trabalhando em um projeto:

* **Fork**: como usuário do GitHub, você pode criar um *fork* de qualquer repositório ao qual tenha acesso, o que cria uma cópia do repositório do qual você é proprietário. Fazemos isso clicando no botão “Fork” no canto superior direito.
* **Pull Requests**: depois de criar uma *branch* em um repositório e fazer algumas alterações nessa *branch*, você pode solicitar que essas alterações sejam adicionadas à *branch* principal (*main*) do repositório. Por exemplo, se você quiser adicionar um novo recurso ao Bootstrap, você pode criar uma *branch* a partir do repositório, fazer algumas alterações e enviar um *pull request*. Esse *pull request* pode ser avaliado e possivelmente aceito pelas pessoas que gerenciam o repositório do Bootsrap. Esse processo de pessoas fazendo algumas edições e depois solicitando que elas sejam mescladas em um repositório principal é vital para o que é conhecido como *software de código aberto* (open-source), ou software criado por contribuições de vários desenvolvedores.
* **GitHub Pages**: o GitHub Pages é uma maneira simples de publicar um site estático na web. Para fazer isso:
  1. Crie um novo repositório no GitHub.
  2. Clone o repositório e faça as alterações localmente, certificando-se de incluir um arquivo `index.html` que será a página inicial do seu site.
  3. Envie essas alterações para o GitHub.
  4. Navegue até a página "Configurações" do seu repositório, role para baixo até GitHub Pages e escolha a *branch main* no menu suspenso.
  5. Role de volta para a parte GitHub Pages da página de configurações e, após alguns minutos, você verá uma notificação de que “Seu site está publicado em: …” incluindo um URL onde você pode encontrar seu site!
 
## Comandos Git mais utilizados

* git clone <url-do-repositorio>
* git add .
* git status
* git add <nome-do-arquivo>
* git commit -m "Mensagem"
* git log
* git log -n 3
* git log --oneline
* git push origin main
* git push origin +main (git push origin main --force)
* git fetch origin main
* git pull origin main
* git pull --rebase origin main
* git cherry-pick <id-do-commit>
* git branch -a
* git checkout -b <nome-da-nova-branch>
* git checkout <nome-da-branch>
* git merge <nome-da-branch-a-ser-mergeada>
* git diff <nome-do-arquivo>
