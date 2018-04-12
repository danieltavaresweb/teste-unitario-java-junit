# Teste unitário - junit-java
  Testes automatizados em java
  
## Etapas do teste
  - Parte 1: Criar o cenário de teste (inicializa os objetos)
  - Parte 2: Realiza a ação (invoca os metodos)
  - Parte 3: Realiza a validação (compara o retorno)


## Vantagem de Testes Automatizados
   - Executa muito rápido se comparado a um humano.
   - Evita testes incorretos por humanos. 
   - Ajudar a encontrar erros em funcionalidades relacionadas 
   
## Padrões e melhores práticas
  - A classe de teste deve ter o nome da classe a ser testada seguida da palavra "Test". (NomeDaClasseTest)
  - Colocamos a classe de teste no mesmo pacote da classe de produção. (br.com.aplicacao.service => EmissaoServiceTest)
  - Escreva um teste por ordem de equivalência. Evite testes repetidos.
  - User import static para a classe Assert, evitando assim, o seu uso repetitivo e deixando o código mais limpo.  
    Por exemplo (import static org.junit.Assert.assertEquals;)
  - Quando lidamos com listas, por exemplo, é sempre interessante tratarmos o caso da lista cheia, 
    da lista com apenas um elemento, da lista vazia.
  - Se estamos lidando com algoritmos cuja ordem é importante, precisamos testar ordem crescente, decrescente, randômica.
  - Teste todos os caminhos possíveis de um determinado código.
  - Comece sempre pelo teste mais simples. Se você está trabalhando em um trecho de código e está bastante 
    confiante sobre ele, você pode dar passos um pouco maiores. Mas cuidado, passos grandes não 
    devem ser a regra, mas sim a exceção.
  - Utilize o padrão Test Data Builder para a criação de objetos em testes com Junit.



## Comandos
  - **Assert.assertEquals(valorEsperado, valorReal, delta)** : compara se dois valores são iguais. *delta-> é uma diferença de valor que deve ser ignorado pelo junit na comparação. Como double tem problemas de arredondamento, a versão mais nova do JUnit pede para você passar o "tamanho do erro aceitável".
No caso, estamos passando 0.00001. Ou seja, a diferença entre o esperado e o calculado pode ser de até 0.00001, que o JUnit entenderá como erro normal de arredondamento.
  - **Assert.assertTrue(resultado);**: espera-se que o resultado seja verdadeiro(true).
  - **Assert.assertFalse(resultado);**: espera-se que o resultado seja falso(false).

## Anotações

  **@Test:** Utlizado para identificar um metodo que contém um teste específico.
  
  
  **@Before:** Utilizado no metodo que será executado antes da execução do método se teste. Geralmente utilizado 
                para instanciar objetos. O metodo anotado com @Before será executado
                sempre antes de cada teste. Por padrão o nome deste método á **setUp()** 
  
  **@After:** Métodos anotados com @After são executados após a execução do método de teste. Muito utilizado em teste de
              integração. (acessam banco de dados, abrem arquivos, abrem sockets, e etc.)
  
  **@BeforeClass:**  São executados apenas uma vez, antes de todos os métodos de teste. Eles podem ser bastante úteis 
                     quando temos algum recurso que precisa ser inicializado apenas uma vez e que pode ser 
                     consumido por todos os métodos de teste sem a necessidade de ser reinicializado.
  
  **@AfterClass:** é executado uma vez, após a execução do último método de teste da classe.
  
  
### Atributos
    - De @Test
      - @Test(expected=RuntimeException.class): utilizado para testar uma exception especifica. Também podemos utilizar o
        Assert.fail().
      -   
    
    
## Pacotes (versao 4)
- org.junit: @Test, Assert


## TDD (Test Driven Development)
- É uma tecnica para teste que visa escrever primeiramente os testes para depois escrever o código a ser testado.
- O código já nasce testado
- Facilita a refatoração.
- Ciclo: Escreve teste -> ver falhar -> escreve codigo mais simples de sucesso -> refatora código (volta para o inicio) 

### Baby Step
  - Serve justamente para que o programador consiga dar passos pequenos o suficiente para que ele não se perca, mantenha foco,
  e produza código de qualidade.
  * Ao tomar passos realmente tão pequenos O TEMPO TODO, o programador acaba por diminuir sua produtividade.

#### HANCREST: API de Teste
      Api utilizada para melhorar a legibilidade dos seus testes. Esta Api faz uso do metodo 
      equals que deve ser sobrescrito.
  
  - Importanções:
    - import static org.hamcrest.MatcherAssert.assertThat
    - import static org.hamcrest.Matchers.*

##### Comandos
       - assertThat(ValorReal, equalTo(ValorComparado))
       - assertThat(maiores,hasItems(
                   new Lancer('Maria', 100),
                   new Lancer('Felipe', 200),
                   new Lancer('Ricardo', 300)
       ));
      
    


##Considerações
- Para uma lista de objetos, o juint realiza 1+N comparações (1 - para verificar o tamanho da lista; n - para verificar cada item - conteudo - da lista) 
- Documentação do Hancrest: https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki
- https://github.com/sergsoares/teste-de-unidade-alura

