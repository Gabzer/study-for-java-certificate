Curso Java na Udemy
===================

**Configuração**

-JDK 8

-Eclipse

**Vantagens da OO**

1.Projetar

2.Manutenção

3.Reutilização

**VARARGS - Variable-Length Arguments**

É possível declarar um método sem especificar a quantidade de parâmetros exata, pode ser de 0 à N parâmetros.

```java
public static void somar (double ...numeros) {
    double soma = 0;
    for (double num: numeros)
        soma += num;
    System.out.println(soma);
}
```

Exemplo inválido:

```java
public static void somar (int a, int b, int ...n, int c) {
    //intructions
}
```

Exemplo válido:

```java
public static void somar (int a, int b, int ...n) {
    //intructions
}
```

**Membros de Classe**

Uma classe é composta, como todos nós sabemos, de atributos e métodos = membros de classe.

Esses membros (Estáticos = static) são aqueles utilizados para fazer refer~encia a uma determindada classe, sem haver qualquer relação com os objetos que serão criados da mesma. Neste caso, não se replicam quando novos objetos são criados.

O atributo passa a ser único e não existir em cada objeto.

Existe o procedimento de inicialização estático que é executado uma única vez no momento em que a classe é carregada (não é muito recomendado).

Exemplo:

```java
public class Exemplo {
    static {
        //instructions
    }
}
```

**Atributos Constantes, Enumerações e Métodos Constantes**

Uma **constante** é declarada com o uso da palavra reservada _final_. Normalmente o nome dela é todo em maiúsculo.

_Desvantagens_

1.Não é typesafe

2.Não tem namespace, então mistura-se com outras constantes existentes na classe.

3.reuqer recompilação do código, se novas constantes forem adicionadas.

_Solução_

Enumerations: são classes Java que definem constates; não podem ser instânciadas usando a palavra _new_; os únicos valores aceitos por um tipo _enum_ são os valores previamente definidos.

```java
public enum Onceito {
    RUIM, REGULAR, BOM, EXCELENTE
}
```

```java
Conceito c = Conceito.EXCELENTE;
... 
```

Métodos constantes não podem ser modificados pela herança.

```java
class Teste {
    //mét. constante
    private final static void main (String[] args) {
        ...
    }
}
```

**Pilares da Orientação a Objetos**

1.**Encapsulamento**: serve para controlar o acesso aos atributos e métodos de uma classe, tendo por objetivo criar um software mais flexível, fácil de modificar e de criar novas implementações;

-Public, private, protected, package.

-Reuso: é o processo de criação de sistemas a partir de softwares existentes ao invés de construí-los do zero. 4 tipos: composição, agregação, associação e herança.

---------------------------------------------------------------------------------

2.**Herança**: permite a criação de novas classes (subclasses) com as mesmas características (atributos) e os mesmos comportamentos (métodos) de uma classe já existente (superclasse);

-é marcado pela palavra reservada _extends_. Só pode haver uma classe pai.

-o construtor não é passado para o filho (para isso usar _super()_).

-pode-se usar métodos do pai: _super.metodo()_.

-_super_serve para usar atributos e métodos; _super()_ serve para o construtor.

-**sobrecarga**= ocorre quando uma subclasse define um método com o mesmo nome do método herdado da superclasse, contudo com a sua assinatura diferente.

-**anulação** ou **sobreposição**= ocorre quando uma subclasse define um método com o mesmo nome e a mesma assinatura do método herdado (mét. constantes/final não podem ser).

-**extensão**= ocorre quando uma subclasse define novos métodos, sem qualquer relaçao com os métodos herdados da superclasse.

-um construtor chamando outro:

```java
Ponto(){
    this(0,0);
}
Ponto(int x, int y){
    this.x = x;
    this.y = y;
}
```

---------------------------------------------------------------------------------

3.**Polimorfismo**: é o princípio pelo qual um objeto pode ser referenciado de várias formas.

-vantagens: 1.trazer clareza ao código; 2.diminuir as linhas de programação; 3.desenvolver aplicações flexíveis.

-Exemplo, onde o atributo 'departamento' é visível apenas na classe 'Diretor', sendo que o objeto 'jose' é do tipo 'Funcionario':

```java
public class Funcionario {}

public class Diretor extends Funcionario {
    String departamento;
}

//código

Funcionario jose = new Diretor();
jose.departamento = "Financeiro"; //erro
```

-como verificar qual a instancia de um objeto:

```java
if (objeto instanceof Funcionario) {
    ...
}
```

-**casting**= existem 3 tipos: entre tipos primitivos; de objetos; e de tipos primitivos para objetos e vice-versa:

```java
int a; byte b;
b = (byte) a;
```

```java
Veiculo v = new Carro();

Carro c = (Carro) v;
```

```java
//Antes
Integer iob = new Integer(100);
//com autoboxing
Integer iob = 100;

//antes
int i = iob.intValue();
//com autounboxing
int i = iob;
```

-o filho não pode receber o pai.

**Classes Abstratas**

Ao se criar uma classe para ser estendida, é muito comum não se ter a ideia de como codificar os seus métodos, isto é, somente as suas subclasses saberão implementá-los.

Uma classe deste tipo não pode ser instanciada pois sua funcionalidade está incompleta.

= abstrata (abstract)

**Interfaces**

No Java existe o conceito de interface que define uma série de métodos, sem conter as suas implementações. A interface só expõe o que o objeto deve fazer, e não como ele faz, nem o que ele tem. Como ele faz vai ser definido em uma implemetação dessa interface.

--------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------

**Pacotes Java**

É um conjunto de classes e interfaces relacionadas e outros pacotes que provê _acesso protegido_ e _gerenciamento de espaço de nomes (namespaces)_.

- _Stativ Import_: estende as funcionalidades do comando import, possibilitando que membros de classe sejam chamados.

**Formato _J_ava _AR_chive**

.JAR = possui um conjunto de classes e arquivos de configurações compactados, no estilo de um arquivo zip.

-é necessária a config de um arquivo CLASSPATH = é uma var de ambiente que informa onde os arquivos .jar utilizados estão armazenados.

-uma saída é colocar na pasta %JAVA_HOME%/jre/lub/ext os arquivos .jar.

**Erros e Exceções**

-2 tipos principais de erros:

1.Erros de compilação=

Problemas de sintaxe.

2.Erros em Tempo de Execução=

Problemas na lógica de programação e no ambiente de execução.

-_Exception_: classe utilizada para Erro em Tempo de Execução.

-Dois tipos de exceções:

1._Unchecked Exceptions (UE) = grupo que não obrigam o programador a fazer o tratamento prévio delas com uso de _try/catch_ ou _throws_.

2._Checked Exception (CE) = grupo que obrigam o programador a fazer o tratamento prévio delas com o uso de _try/catch_ ou _throws_.

-classe _Error_ que define as condições consideradas muito graves, que tem pouca possibilidade de serem recuperadas.

_Novidade do Java 7_: **Multicatch** = evita repetição de código:

```java
try {
    //...
} catch (Exceção1 | Exceção2 | ... | ExceçãoN) {
    //...
} finally {
    //...
}
```

_Outra Novidade_: Gerenciamento Automático de recursos:

```java
try (MyBufferedReader br = new MyBufferedReader(new FileReader("classes.txt"))) {
    String line;
    while ((line = br.readLine()) != null)
        instantiate(line);
}
```

**Throws e Throw**

throws = é obrigatório em métodos e construtores que deixam de capturar uma ou mais exceções (do tipo CE) que ocorrem em seu interior.

```java
public void m() throws Excecao1, Excecao2 {...}
```

-throw = é utilizado para 'lançar' uma exceção especifica ou a sua própria exceção no meio do código.

**JavaDoc**

Para o correto uso da ferramenta, torna-se necessário a inclusão de comentários na linha anterior à definição de classe, interface, construtor, método e atributo.

Sintaxe padrão:

```java
/**
*Classe
*@author Gabzer
*/

/**
*Método
*@param valor
*/
```

No Eclipse, clique direito sobre o projeto, 'Export' e 'Javadoc', informar onde se encontra o seu javadoc no jdk.

**Socket**

Classe que implementa clientes sockets. Um socket é um endpoint para a comunicação entre duas máquinas.

O trabalho atual do socket é desempenhado por uma instancia da classe SocketImpl. Uma aplicação, mudando o socket factory que cria a implementação do socket, pode se configurar para criar sockets apropriados para o firewall local.

**ServerSocket**

Classe que implementa o serviço sockets. Um serviço (server) socket espera por requests para entrar pela rede. Ele realiza alguma operação com base nessa solicitação (request) e, possivelmente, retorna um resultado para o solicitante (requester).

O trabalho atual do socket é desempenhado por uma instancia da classe SocketImpl. Uma aplicação, mudando o socket factory que cria a implementação do socket, pode se configurar para criar sockets apropriados para o firewall local.

**Thread**

Pense numa Thread como uma sequência de comandos sendo executados em um programa. Se você tiver duas threads, terá duas sequências de comandos executando ao mesmo tempo no mesmo programa ou processo.

Existem dois meios para se criar Threads:

```java
/* -----------------------------------*/
class PrimeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
        this. minPrime = minPrime;
    }

    public void run() {
        //calcule primos maiores que minPrime
        //....
    }
}
/* -----------------------------------*/

//...

PrimeThread p = new PrimeThread(143);
p.start();
```

ou:

```java
/* -----------------------------------*/
class PrimeRun implements Runnable {
    long minPrime;
    PrimeRun(long minPrime) {
        this. minPrime = minPrime;
    }

    public void run() {
        //calcule primos maiores que minPrime
        //....
    }
}
/* -----------------------------------*/

//...

PrimeRun p = new PrimeRun(143);
new Thread(p).start();
```

Applets Java
=============

Uma aplicação gráfica Java que é executada em um _browser_.

É também uma aplicação gráfica Java que não declara o método _public static void main(...)_. No seu caso, o método principal será o **public void paint(Graphics g)**.

```java
public class AloMundo extends JApplet {	
	public void paint(Graphics g) { }
}
```

Métodos herdados:

1. _init()_ - inicializa os componentes do applet.

2. _start()_ - o que fazer quando applet iniciar.

3. _stop()_ - o que fazer antes do applet parar.

4. _destroy()_ - o que fazer quando applet terminar.

5. _paint()_ - o que desenhar no contexto gráfico.

Um desses deve ser anulado para o applet funcionar.

Passando parâmetros:

```html
<applet code="Sound.class" height=50 width=50>
    <param name="sound.au">
<applet>
```

```java
String sound = getParameter("sound");
```

Java Web Start (JAWS)
=====================

Alternativa ao applets. Criado no Java 2.

O JAWS permite:

1-Ativar aplicações facilmente, com apenas um clique;

2-Oferecer a garantia de que sempre esteja sendo executada a versão mais recente da aplicação;

3-Eliminar procedimentos complexos de instalação ou atualização.

Pode ser executado via:

1-Browser;

2-Gerenciador de aplicações JAWS;

3-Ícone na área de trabalho.

Como criar uma app JAWS:

1-Criar uma classe normalmente em java;

2-Criar o arquivo de manifesto (manifest.mf) no subdiretório (Meta-inf);

3-Compactar os dois arquivos anteriores em um JAR (jaws.jar);

4-Criar uma chave-pública pelo Windows;

5-Assinar o arquivo JAR com a chave-pública criada anteriormente;

6-Criar o arquivo .jnlp que é o protocolo padrão (Java Network Launching Protocol) para executar aplicações JAWS.

Necessário adicionar o caminho do arquivo jaws.jnlp na _Lista de Exceções_.


Anotações
=========

É o recurso que possibilita escrever metadados (dados sobre outros dados) no código fonte de uma aplicação Java. essas anotações não afetam o funcionamento do código onde foram declaradas, pois são ignoradas pelo compilador.

```java
@anotação("parâmetro")
```

Minimiza a utilização de arquivos de configuração.

Existem 3 **categorias** de anotações:

1-marcadoras = são aquelas que não possuem membros.

```java
@Test
```

2-de valor único = são aquelas que possuem um único membro.

```java
@MinhaAnotacao("valor")
```

3-completas = são aquelas que possuem múltiplos membros

```java
@Version(major=1, minor=0)
```

Existem 2 **tipos** de anotações:

1-simples: utilizadas para acrescentar siginificado ao código (@Override, @Suppresswarnings, @Deprecated, @SafeVarargs, @FunctionalInterface).

2-meta-anotações: utilizadas para a criação de anotações (@Retention, @Documented, @Target, @Inherited, @Repeatable)

@Deprecated = diz que um método não é mais utilizado.

@Suppresswarnings = tira algumas mensagens de warning (@Suppresswarnings(value={"unchecked","rawtypes"})).

@FunctionalInterface = informa que uma interface é explicitamente funcional, quer dizer que ela possui apenas um método abstrato. Interfaces funcionais são o coração do recurso de Lambda. O Lambda por si só não existe, e sim expressões lambda, quando atribuídas/inferidas a uma interface funcioanl.

@Retention = as anotações podem estar presentes apenas no código fonte ou no binário de classes ou interfaces. Essa anotação é usada para escolher entre essas possibilidades.

```java
@Retention(RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)
```

**Criar uma nova anotação**

```java
public @interface ITabela {
    String[] colunas();
}
```

Streams de Entrada e Saída
==========================

-stream = sequência de dados transmitidos de uma fonte de entrada para um destino de saída e vice-verça.

-_InputStream_ e _OutputStream_ são as classes abstratas definidas no pacote java.io que representam um Stream de Entrada e um Stream de Saída, respectivamente. Principais Streams: Byte Stream, Character Stream, Buffered Stream (memória auxiliar), Data Stream (boolean, char, byte, short, int, long, float e double) e Object Stream (necessita de Serializable).

Scanner e Formatter
===================

Scanner = implementa as operações de entrada de dados pelo teclado.

Formatter = implementa as operações de saídad dos dados gerados pela aplicação.

```java
Fomatter fmt = new Formatter(System.out);
Scanner scn = new Scanner(System.in);
int n1 = scn.nextInt();
fmt.format("n1: %d", n1);
```

|----|------------------|
|    |caracteres de formatação|
|----|------------------|
| %c | caractere simples|
| %d | decimal          |
| %e |notação científica|
| %f | ponto flutuante  |
| %o | octal            |
| %s |cadeia de caracteres|
| %u | decimal sem sinal|
| %x | hexadecimal      |
|----|------------------|

Se a string não puder ser interpretada com o tipo especificado, a exceção _inputMismatchException_ é anunciada.

**Classes Path e Files**

A classe _Path_ permite manipular o caminho em um determinado sistema de arquivos.

```java
//Sintaxe Microsoft Windows
Path path = Path.get("C:\\home\\user\\foo");
```

A classe _Files_ é composta por vários métodos para manipulação de arquivos (criação, cópia e exclusão).

Genéricos
=========

São tipos parametrizados que possibilitam a criação de classes, interfaces e métodos que funcionam automaticamente com tipos diferentes de dados.

Com genéricos todos os _casts_ são automáticos e implícitos, bem como a checagem de tipo é mais robusta em tempo de compilação.

Código **sem** o uso de Genéricos:

```java
Lista myIntList = new LinkedList();
myIntList.add(new Integer(0));
Integer x = (Integer) myIntList.iterator().next();
```

Código **com** o uso de Genéricos

```java
Lista<Integer> myIntList = new LinkedList<Integer>();
myIntList.add(new Integer(0));
Integer x = myIntList.iterator().next();
```

**vantagem:** com o uso de Genéricos há maior 'estabilidade' no código escrito, fazendo com que mais erros sejam detectados em tempo de compilação, solução menos pior do que ser detectado em tempo de execução.

No Java 7, no _new Class<>()_ não é necessário repetir o tipo Genérico.

**Anatomia dos Genéricos**

_RAW TYPE:_ sem argumento

```java
ExemploGenerics ex = new ExemploGenerics();
```

_BOUNDED TYPES:_ define a qual superclasse o tipo genérico estende.

```java
public class Stats<T extends Number> {
    T[] num;
    Stats(T[] num) {
        this.num = num;
    }

    double media() {
        double soma = 0;
        int i;
        for(i = 0; i < num.length; i++) {
            soma = soma + num[i].doubleValue();
        }
        return (soma / i);
    }
}
```

**Métodos Genéricos**

```java
//definição
<G extends Number>int intmedia (G num) {
    return (num.intValue());
}
//chamada
Classe.<Integer>intmedia(5);
```

**Construtores Genéricos**

```java
public class NotaAluno {
    double valor;
    <T extends Number> NotaAluno (T obj) {
        valor = obj.doubleValue();
    }
}
```

**Interface Genérica**

```java
interface MinMax<T extends Comparable> {
    T min();
    T max();
}
```

**Hierarquia de Classes**

A única diferença é que na hierarquia de Genéricos qualquer tipo de argumento da superclasse deverá ser passado por todas as subclasses existentes.

```java
//superclasse genérica
class Gen<T> {...}
//subclasse genérica
class Gen2<T> extends Gen<T> {...}
```

_curingas (Wildcards)_

a superclasse de qualquer Genérico é representada por <?>

_bounded wildcards_

pode-se impor limites aos curingas:

1. limites superiores <? extends T> = aceita T e todos os seus descendentes.

2. limites inferiores <? super T> = aceita T e todos os seus ascendentes.

**Restrições no Uso de Genéricos**

- _instanceof_ ou _cast_ não fazem sentido quando se usa Genéricos.

- _vetores_ não podem ser utilizados com Genéricos. Melhor usar o <?>.

- Genéricos não trabalham com tipos primitivos.

- Não é possível a criação de objetos dos tipos parametrizados.

- Não é possível usar _catch_ e _throw_ para objetos de tipos parametrizados.

Framework Collections
=====================

É uma arquitetura unificada para a representação e a manipulação de coleções. Uma coleção é uma estrutura de dados que possibilita agrupar outros objetos, tendo por objeto: adicionar, remover e pesquisar um determinado objeto dentro da coleção.

**Lista, Pilha e Fila**

Lista - é uma estrutura de dados que consiste em uma coleção de nós dispostos linearmente, onde cada elemento tem um antece.

- principais implementações de lista:

1. Pilha: adota a política _last-in-first-out_. Realiza as operações de Adição e Remoção no início da Lista.

```java
public class Stack<E> extends Vector<E>
```

2. Fila simplesmente encadeada: política _first-in-first-out_. Operações de Adição no fim da Lista e de remoção no início da Lista.

```java
public interface Queue<T>
```

3. Fila duplamente encadeada: política _first-in-first-out_. Operações de Adição no fim da Lista e de Remoção no início da Lista.

```java
public interface Deque<T>
```

**Interface Set**

É a interface que define uma coleção que não contém objetos duplicados. Também é conhecido como _Conjunto_. Não é garantida a ordenação dos objetos.

- 3 implementações da Interface Set:

1. HashSet: utiliza uma tabela _hash_ para guardar os seus elementos, sem garantir a ordem de iteração, nem que a mesma permanecerá constante com o tempo. Por utilizar o algoritmo de tabela hash, o acesso é rápido, tanto para leitura quanto para modificação.

2. LinkedHashSet: subclasse de HashSet que adiciona previsibilidade à ordem de iteração sobre os elementos, isto é, garante a ordem com que os elementos presentes no conjunto são recuperados.

3. TreeSet: oferece um conjunto ordenado de elementos por intermédio de árvore balanceada _red-black_.

```java
Collection semDeuplicacao = new HashSet(comDuplicacao);

Collection semDeuplicacao = new LinkedHashSet(comDuplicacao);

Collection semDeuplicacao = new TreeSet(comDuplicacao);
```

**Interface List**

Ela define uma coleção de elementos ordenados (que podem estar duplicados) e cujo acesso é reaçizado por meio de um índice numérico que representa a posição de cada elemento.

- 2 implementações do List:

1. ArrayList: utiliza internamente um vetor de objetos, cujo tamanho inicial é de 10 posições. É preferível esta implementação quando o tamanho da lista é previsívele as operações de inserção e remoção são feitas, em sua maioria, no fim da lista (evitando deslocamento), ou quando a lista é mais lida do que modificada (otimizado para leitura aleatória).

2. LinkedList: utiliza internamente uma lista duplamente encadeada e a busca pelos seus elementos é feita de forma sequencial (via padrão Iterator) ou nas extremidades, e não de forma aleatória (por índices).


**Interfaces Queue e Dequeue**

_Queue_: a interface que define uma coleção de elementos cujo acesso se dá por meio de uma Lista Simplesmente Encadeada.

- principais métodos: add(e), remove(), element(), offer(e), poll(), peek().

_Dequeue_: a interface que define uma coleção de elementos cujo acesso se dá por meio de uma Lista Duplamente Encadeada.


**Interface Map**

É a interface base para todos os tipos de coleções baseados em Mapa. Um Mapa (também chamados de vetores associativos) é utilizado para organizar coleções de objetos, cujos índices de acesso não precisam necessariamente ser valores inteiros positivos sequenciais. (Tipo o dicionário em Python [chave, valor]).

**Interfaces Auxiliares e Classes Utilitárias**

_Interfaces Auxiliares:_ o framework Collections também define uma série de interfaces auxiliares que definem operações sobre os objetos retornados de uma coleção: Iterator, ListIterator, Comparable, Comparator, Enumeration e RandomAccess.

_Classes Utilitárias:_ são aquelas que possuem apenas métodos estáticos e são utilizadas pelas classes definidas no framework Collections (ex.:Collections, Arrays, Properties).

OBS.: Programe voltado à interface e não à implementação:

```java
//não fazer assim
ArrayList lista = new ArrayList();
//o correto é
List lista = new ArrayList();
```

Novidades Java 8
================

**Expressões Lambdas**

Antes tinha que ser um método dentro de um objeto, agora uma classe pode ser uma função (paradigma funcional).

_Expressões Lambda_ são um novo recurso da linguagem Java para implementar de maneira simples o cálculo lambda. Lambda repressenta uma função anônima.

_Classes anônimas_ são aquelas que não possuem nome, não tem construtor e só são utilizadas dentro de um bloco de código para oferecer alguma funcionalidade.

A lambda evita a utilização de classes anônimas:

```java
//anônima
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        ...
    }
});
//lambda
btnNewButton.addActionListener(event -> {...});
```

**Sintaxe Lambda**

```java
() -> System.out.println(this)
```

```java
(String str) -> System.out.println(str)
str -> System.out.println(str)
```

```java
(String s1, String s2) -> {return s2.length() - s1.length();}
(s1, s2) -> s2.length() - s1.length()
```

```java
public class Calculadorav2 {
    public static void main(String[ args]) {
        Exemplov2 ex = new Exemplov2();
        IMath somar = (a,b) -> a+b;
        IMath subtrair =  (a,b) -> a-b;
        IMath multiplicar  = (a,b) -> a*b;
        IMath dividir  = (a,b) -> a/b;

        System.out.println(ex.execOperacao(5,5,somar));
        System.out.println(ex.execOperacao(6,4,subtrair));
        System.out.println(ex.execOperacao(3,4,multiplicar));
        System.out.println(ex.execOperacao(10,2,dividir));
    }
    public int execOperacao (int a, int b, IMath op) {
        return op.operacao(a,b);
    }
}
```

**Interfaces Funcionais**

São o 'coração' do recurso de lambda. O Lambda por si só não existe, mas sim as _expressões lambda_ quando associadas a uma interface funcional.

```java
@FunctionalInterface
interface Name_Interface {
    /*...*/
}
```

**Principais utilizações da Expressão Lambda**

1. Substituição das Classes Anônimas utilizadas com muita frequência para ativação de eventos em Interfaces Gráficas com Java.

2. Realização de operações em objetos do Framework Collections de forma mais objetiva e concisa.

**Referência de Métodos**

É usada para fazer uso de uma função já existente. Utilizar com *class_object::name_function*

**Métodos Default**

No Java 8, as interfaces já podem possuir implementação de métodos. A esses métodos é dado o nome de default e são identificados pelo uso da palavra reservada _default_. Eles permitem evoluir uma API antiga de maneira não disruptiva, sem romper com o passado.

**Streams**

O Stream  traz para o Java uma forma mais funcional de se trabalhar com coleções, usando uma interface específica para isso. Um Stream representa uma abstração de um 'fluxo de dados'.

A interface _Stream<T>_ representa uma sequencia de elementos nos quais uma ou mais operações (filter, sorted, map, match, count, reduce) poderão ser executadas. Essas oper poderão ser **intermediárias** ou **terminais**. A primeira retorna um Stream para ser utilizado em uma outra operação. A segunda já retorna o resultado esperado.

**Parallel Streams**

A principal diferença é que no primeiro utiliza-se apenas uma thread, enquanto que no segundo são utilizadas várias threads. Assim sendo, o segundo tipo de Stream é muito mais 'performático' que o primeiro.

Aplicações Gráficas em Java
===========================

**SWING**

Está organizado em:

1. Container (JFrame, JDialog, JApplet) é o local onde são adicionados os componentes e outros containers

2. Componentes (JButton, JLabel, JScrollBar, JOptionPane, etc) são os elementos gráficos adicionados a um Container.

3. Gerenciadores de Layout (FlowLayout, BorderLayout, etc) são os elementos responsáveis pelo posicionamento dos componentes adicionados a um determinado Container.

**Look and Feel (L&F)**

_Look_ se refere à aparência dos componentes gráficos e _Feel_ ao comportamento destes na ocorrência de eventos.

```java
UIManager.setLookAndFell("Windows");
```

**Java FX**

É o próximo passo na evolução do Java como plataforma de desenvolvimento de aplicações cliente ricas. Pode ser usado para web e mobile. No eclipse isntalar o e(fx)clipse para ele funcionar.

Como criar um projeto em JavaFX:

1. No eclipse, File > New Project > Other > JavaFxProject > Next

2. Na caixa de diálogo 'Application Type' > Manter 'Desktop' > Finish

3. application.css

```css
.root {
    -fx-background-image: url("background.png");
}
```

4. Main.java

```java
public void start (Stage primaryStage) {
    try {
        StackPane root = new StackPane();
        primaryStage.setTitle("Aplicação JavaFx");
        Button btn = new Button();
        btn.setText("Say Hello World!");
        Label lb = new Label();
        btn.setOnAction(ev -> lb.setText("\n\n\n Alo Pessoal"));
        root.getChildren().add(btn);
        root.getChildren().add(lb);
        Scene scene = new Scene(root,400,400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

Unidade 1: Arquitetura JEE
==========================

Java Enterprise Edition - Persistência de Dados com JDBC e Hibernate

**Arquitetura JEE**

O JEE acrescenta ao JSE vários recursos específicos (APIs) para a construção de serviços de software que rodam em servidores de aplicação disponíveis na 'Nuvem'.

Modelo de Aplicação JEE: database(data storage), web server(business logic, data access) e browser(GUI).

O modelo de aplicação JEE divide as aplicações corporativas em 3 partes:

1. _Componente_ é uma unidade de software funcional independente que é montada em uma aplicação JEE com seus arquivos e classes relacionados e que se comunica com outros componentes.

2. _Containers_ ficam localizados entre os componentes e os clientes, provendo serviços transparentes para ambos, incluindo serviços transacionais, pooling de recursos, gerenciamento de ciclo de vida, segurança e transação.

3. _Conectores_ são utilizados para uniformizar os métodos de acesso/comunicação aos Sistemas de Informação Empresarial (EIS) em Java.


















--------------------------------------------------------------------------------------------------------------

Questões para estudo
====================

**Uma classe pode ter mais de um _implements_ ?**

http://www.guj.com.br/t/uma-pode-classe-implementar-mais-de-uma-interaface/81486

**O que é _.getClass()_ ?**

http://www.guj.com.br/t/basico-usando-o-metodo-getclass-de-object/73311

**O que é _.iterator()_ ?**

https://www.devmedia.com.br/java-collections-set-list-e-iterator/29637

--------------------------------------------------------------------------------------------------------------
