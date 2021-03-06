Study-for-Java-Certificate
==========================

Todo nome de classe começa com letra maiúscula. E cada palava adicional tem q ter a letra maiúscula também.

Para compilar:

```bash
javac NomeClasse.java
```

E para executar:


```bash
java NomeClasse
```

Componentes de uma classe:

1.Declaração da classe: _class_

2.Nome da classe: _HelloWorld_

3.Método: _public static ... (...) { ... }_

4.Modificadores de acesso do método: _public static_

5.Tipo do retorno do método: _void_

6.Nome do método: _main_

7.Parâmetros/Argumentos do método: _(String[] args)_

8.O código em si

9.Blocos estão entre {}

Para passar parâmetros para a sua classe é só utilizar o args[?] no seu código e na hora de executar o .class, colocar o argumento depois do nome da classe.

**Tipos de Erros**

1.Erros de Sintaxe

2.Erros de Semântica

3.Erros em Tempo de Execução

**Herança**

Uma classe herda atributos de outra

**Polimorfismo**

Relacionado aos métodos

**Pacotes**

Forma de organizar as classes. Convenção: domínioEmpresa + projeto + pasta

**Variáveis**

área de memória associada a um nome, que pode armazenar valores de um determinado tipo.

Convenção de nomenclatura (camel case): 1ª letra = a-z A-Z _ &; 2ª a-z A-Z _ & 0-9;

_Tipos Primitivos_

Tipos Inteiros:

*byte = 8 bits
*short = 16 bits
*int = 32 bits
*long = 64 bits

Tipos de Ponto Flutuante:

*float = 32 bits (ex.: 100.30f)
*double = 64 bits

Tipo Caractere:

*char - pode ser um inteiro (tabela ASCII)

Tipo booleano:

*boolean (true ou false)


**Curiosidade**

os valores limite de variáveis int são:

-2147483648 à 2147483647

mas é tipo uma roleta: quando você está em um dos limites e soma algum valor, ele passa automaticamente para o outro limite e não dá erro!!!

_Tipos Literais_

o double aceita notação científica:

```java
double d1 = 123.4;

double d2 = 1.234e2;

// d1 = d2
```

-Hexadecimais, Octais, Binários:

```java
int decVal = 26;
int hexVal = 0x1a; //0x indica que é hexadecimal
int octVal = 032; //0 indica que é octal
int binVal = 0b11010; //0b indica que é binário
//decVal = hexVal = octVal = binVal
```

-Pode e não pode:

Pode:

```java
long creditCardNumber = 1234_5678_9012_3456L;
float pi = 3.14_15F;
long hexBytes = 0xFF_EC_DE_5E;
byte nybbles = 0b0010_0101;
```

Não pode:

```java
float pi1 = 3_.1415F;
int x1 = _52;
int x5 = 0_x52;
```

Escape char:

```java
System.out.println("\"Hello, World!\"\n\r");
System.out.println("1\\4");
```

**Lendo entradas**

Primeiro temos que importar a biblioteca:

```java
import java.util.Scanner;
```

Depois, por esse método se lê o que for posto e transforma em string:

```java
Scanner scan = new Scanner(System.in);
```

Lendo a próxima linha:

```java
String nome = scan.nextLine();
```

Lê e transforma em int:

```java
int idade = scan.nextInt();
```

Lê e transforma em double:

```java
double altura = scan.nextDouble();
```

etc....

**Operadores Aritméticos**

```java
+ - * / % ++ --
```

**Operadores relacionais**

```java
== != > < >= <=
```

**Operadores Lógicos**

```java
& | ^ (=XOR) || && !
```

O '^' só vai dar falso quando os dois forem iguais.

**Tipos de loop for**

Normal:

```java
for (int i = 0; i < 5; i++){
      ...
}
```

Com mais de uma variável:

```java
for (int i = 0, j = 10; i < j; i++, j--){
      ...
}
```

Partes ausentes:

```java
int i = 0;
for (; i < 5; ){
      ...
}
```

Loop infinito:

```java
for (; ; );
```

Loop melhorado, muito utilizado com Arrays:

```java
```

**Comando break**

Usado para saída de loops.

Pode ser usado juntamente com um rótulo (label).

```java
int max = scan.nextInt();
for (int i = 0; i <= max; i++) {
      if (i % 7 == 0) {
            System.out.println("O valor de i é: " + i);
            break;
      }
}
```

break com rótulos - goto

```java
for (int i = 0; i <= 4; i++) {
      rotulo1: {
            rotulo2: {
                  rotulo3: {
                        if (i == 1) {
                              break rotulo1;
                        }
                        if (i == 2) {
                              break rotulo2;
                        }
                        if (i == 3) {
                              break rotulo3;
                        }
                        System.out.println("rotulo3");
                  }
                  System.out.println("rotulo2");
            }
            System.out.println("rotulo1");
      }
      System.out.println("i");
}
```

**Comando continue**

Complemento do break.

Continue o loop na próxima iteração.

**Arrays**

Estrutura de dados mais simples existente na maioria das linguagens de programação.

Lista ordenada de dados.

```java
double[] temp = new double[30]; //qtde de linhas
temp[0] = 31.2;
```

**Matriz**

Array de arrays.

```java
double[][] nomeMatriz = new double[n][m];
double[][] nomeMatriz = {{...}, {...}};
```

Matriz multidimensional.

Matriz irregular.

**For each**

Normalmente para outputs

```java
int[] numeros = {...};
for (int num : numeros){
      ...
}
```

Para matriz

```java
int[][] numeros = {...};
for (int[] num : numeros){
      for (int num : numeros){
            ...
      }
}
```

**Orientação a Objetos**

_Classe_

```java
class Carro {
      String marca;
      ...
}

Carro van = new Carro();
van.marca = "jac";
```

_Métodos_

o nome normalmente começa com um verbo.

```java
void exibirAutonomia() {
      ....
}
```