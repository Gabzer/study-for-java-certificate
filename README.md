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
