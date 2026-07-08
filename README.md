# Codigo-Morse-AVL

Decodificador de codigo Morse em Java usando uma arvore binaria para mapear
pontos e tracos ate as letras correspondentes.

## O que o projeto demonstra

- Representacao de codigo Morse em arvore binaria.
- Navegacao por pontos (`.`) e tracos (`-`) para encontrar letras.
- Entrada de texto pelo terminal.
- Separacao entre estrutura de arvore e fluxo principal da aplicacao.

## Como funciona

- `.` percorre a arvore para a esquerda.
- `-` percorre a arvore para a direita.
- `/` representa espaco entre palavras.

Exemplo de entrada:

```text
.... . .-.. .-.. --- / .-- --- .-. .-.. -..
```

Saida esperada:

```text
HELLO WORLD
```

## Estrutura

```text
src/Main.java                  Entrada da aplicacao
arvoreBinaria/ArvoreMorse.java  Arvore e decodificacao
fila/Fila.java                 Estrutura auxiliar
```

## Como executar

Compile:

```powershell
javac src/Main.java arvoreBinaria/ArvoreMorse.java fila/Fila.java
```

Execute:

```powershell
java src.Main
```

## Status

Projeto academico para praticar estruturas de dados e traducao de simbolos. Um
proximo passo util seria adicionar validacao para sequencias Morse invalidas e
testes automatizados para frases conhecidas.

