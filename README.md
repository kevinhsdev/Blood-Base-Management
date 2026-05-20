<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&height=200&color=gradient&customColorList=6,11,20&text=Sistema%20Hemocentro&fontColor=fff&fontSize=36&fontAlignY=35&desc=Gerenciamento%20de%20doadores%2C%20doa%C3%A7%C3%B5es%20e%20estoque%20sangu%C3%ADneo&descAlignY=55&descSize=16"/>
<br/>

<img src="https://skillicons.dev/icons?i=html,css,javascript,java,mysql,git,figma" />
  
[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)]()
 
<br/>

> Projeto acadêmico desenvolvido para a disciplina de **Programação Orientada a Objetos com JDBC**
> Universidade de Mogi das Cruzes — UMC, 2026
 
</div>

---
 
## 📌 Sobre o projeto
 
O **Sistema Hemocentro** é uma aplicação desktop em Java que simula o gerenciamento interno de um banco de sangue. O sistema permite controlar o cadastro de doadores, registrar doações e monitorar o estoque sanguíneo em tempo real — com atualização automática via trigger no banco de dados.
 
O projeto aplica na prática os conceitos de **Orientação a Objetos**, **padrão DAO**, **JDBC** e **interface gráfica com Swing**, organizados em uma arquitetura em camadas limpa e extensível.
 
---
 
## ✨ Funcionalidades
 
- ✅ Cadastro, consulta, edição e exclusão de doadores
- ✅ Registro de doações com data e quantidade coletada
- ✅ Atualização automática do estoque via trigger MySQL
- ✅ Visualização do estoque por tipo sanguíneo com indicador de nível
- ✅ Interface gráfica intuitiva com Swing

---
 
## 🛠️ Tecnologias
 
<div align="center">
  
[![My Skills](https://skillicons.dev/icons?i=java,mysql,github&theme=dark)](https://skillicons.dev)

| Tecnologia | Uso |
|---|---|
| Java 17+ | Lógica de negócio e interface gráfica |
| Swing | Interface desktop |
| MySQL 8.0 | Persistência de dados |
| JDBC | Conexão Java ↔ MySQL |
| Padrão DAO | Separação entre acesso a dados e regras de negócio |
| NetBeans & IntelliJ IDE | Ambiente de desenvolvimento  Back-End |

</div>
 
---
 
## 🗂️ Estrutura do projeto
 
```
hemocentro/
├── database/
│   └── hemocentro.sql          # Script de criação do banco + trigger
└── src/
    ├── connection/
    │   └── ConnectionFactory.java
    ├── model/
    │   ├── Doador.java
    │   ├── Doacao.java
    │   └── EstoqueSangue.java
    ├── dao/
    │   ├── IDao.java
    │   ├── DoadorDAO.java
    │   ├── DoacaoDAO.java
    │   └── EstoqueDAO.java
    └── view/
        ├── TelaPrincipal.java
        ├── TelaDoadores.java
        ├── TelaDoacoes.java
        └── TelaEstoque.java
```
 
---
 
## ▶️ Como executar
 
```bash
# 1. Clone o repositório
git clone https://github.com/kevinhsdev/hemocentro.git
 
# 2. Crie o banco de dados
mysql -u root -p < database/hemocentro.sql
 
# 3. Configure sua senha em ConnectionFactory.java
# Linha: private static final String PASSWORD = "sua_senha_aqui";
 
# 4. Adicione o MySQL Connector/J ao classpath
# Download: https://dev.mysql.com/downloads/connector/j/
 
# 5. Execute a classe principal
view/TelaPrincipal.java
```
 
> 💡 Recomendado importar o projeto pelo **NetBeans IDE** e adicionar o conector via *Properties > Libraries*.
 
---
 
## ⚡ Diferencial técnico
 
Ao registrar uma doação, um **trigger no MySQL** identifica automaticamente o tipo sanguíneo do doador e incrementa o saldo correspondente no estoque — sem nenhuma lógica extra no código Java. Essa integração é o núcleo do sistema e demonstra a comunicação real entre aplicação e banco de dados.
 
---
 
## 👥 Equipe

<div align="center">

| | | |
|:---:|:---:|:---:|
| <img src="https://avatars.githubusercontent.com/kevinhsdev" width="80" style="border-radius:50%"/> | <img src="https://avatars.githubusercontent.com/JuliaRosa07" width="80" style="border-radius:50%"/> | <img src="https://avatars.githubusercontent.com/Biancabarsil" width="80" style="border-radius:50%"/> |
| **Kevin Henrique da Silva** | **Julia Cavalcante da Rosa** | **Bianca Barbosa Silva** |
| Desenvolvimento Java · Github | Documentação UML · HTML · CSS · JavaScript | Database MySQL · Figma |

</div>

---
 
<div align="center">

© 2026 **CHAPS** — Todos os direitos reservados.

</div>
