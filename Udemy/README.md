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
