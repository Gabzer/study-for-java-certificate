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

Questões para estudo
====================

**Uma classe pode ter mais de um _implements_ ?**

http://www.guj.com.br/t/uma-pode-classe-implementar-mais-de-uma-interaface/81486

**O que é _TreeSet_ ?**

http://www.linhadecodigo.com.br/artigo/3669/trabalhando-com-a-interface-set-no-java.aspx

**O que é _.getClass()_ ?**

http://www.guj.com.br/t/basico-usando-o-metodo-getclass-de-object/73311

**O que é _.iterator()_ ?**

https://www.devmedia.com.br/java-collections-set-list-e-iterator/29637

--------------------------------------------------------------------------------------------------------------
