# Jokenpo gRPC: Java Edition

##### Bem-vindo ao Jokenpo gRPC, um projeto em Java que implementa o clássico jogo de "Pedra, Papel e Tesoura" com as regras estendidas do Jokenpo Lagarto Spock. Este projeto utiliza gRPC para comunicação entre um servidor central e os clientes (hosts) que realizam as jogadas.

## 📋 Visão Geral

#### O sistema é composto por dois aplicativos:

### JokenpoServer:

- Atua como o servidor central do jogo.
- Deve ser iniciado na porta 8080.
- Recebe as jogadas dos jogadores e processa o resultado.

### JokenpoHost:

- Representa os jogadores.
- Deve se conectar ao servidor.
- Permite que cada jogador informe o seu ID e sua jogada.
- Necessário iniciar dois hosts, um para cada jogador.
- Após ambos os jogadores realizarem suas jogadas, o servidor avalia e informa o resultado: quem venceu, perdeu ou se houve empate.

## 🚀 Funcionalidades
1. Suporte ao Jokenpo tradicional:
2. Pedra, Papel e Tesoura.
3. Regras estendidas do Lagarto Spock: Lagarto e Spock adicionam mais possibilidades ao jogo.
4. Comunicação via gRPC:
Cliente-servidor com alta performance e baixa latência.

## ⚙️ Requisitos
- Java 11 ou superior.
- gRPC e Protobuf configurados no projeto.
- Maven ou Gradle para gerenciar dependências

## 📦 Instalação

1. Clone o repositório:
```
git clone https://github.com/sapoNinja27/jokenpo-java

cd jokenpo-java
```
2. Compile o projeto:

```
mvn clean install
```

3. Inicie o servidor:

- Basta rodar o compound Host

## 🎮 Como Jogar
- Inicie o servidor (JokenpoServer) na porta 8080.
- Abra dois terminais e inicie dois clientes (JokenpoHost).
- Cada jogador deve informar:
  - ID do jogador. 
  - Sua jogada: Pedra, Papel, Tesoura, Lagarto ou Spock.
- Após ambos jogarem, o servidor determinará o resultado e notificará os clientes.

## 🌟 Regras do Jokenpo Lagarto Spock
| Jogada	 | Vence Contra	     | Perde Para       |
|---------|-------------------|------------------|
| Pedra   | 	Tesoura, Lagarto | 	Papel, Spock    |
| Papel   | 	Pedra, Spock	    | Tesoura, Lagarto |
| Tesoura | 	Papel, Lagarto   | 	Pedra, Spock    |
| Lagarto | 	Spock, Papel     | 	Pedra, Tesoura  |
| Spock	  | Tesoura, Pedra    | 	Papel, Lagarto  |


### Divirta-se jogando Jokenpo com estilo! 🎲
































