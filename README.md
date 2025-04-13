# 📚 Mentoria Java

![Java](https://img.shields.io/badge/Java-17+-red?logo=java&logoColor=white)
![Status](https://img.shields.io/badge/build-passing-brightgreen)
![Platform](https://img.shields.io/badge/platform-desktop-blue)

Este projeto foi desenvolvido como parte de uma **mentoria Java** para um grupo de 5 alunos, com o objetivo de proporcionar uma formação completa e prática em desenvolvimento de software. Ao longo da jornada, os participantes aprendem desde os fundamentos de **lógica de programação** e **Programação Orientada a Objetos (POO)**, até a criação de interfaces gráficas com **JavaFX** para aplicações desktop. Também exploramos o uso de **bancos de dados relacionais**, construção de **APIs RESTful** com Java, e princípios essenciais de desenvolvimento backend. O foco é aplicar os conceitos de forma progressiva, integrando teoria e prática em um ambiente de aprendizado colaborativo e guiado.

---

## 🚀 Fluxo de Trabalho com Git

> ⚠️ **Nunca use `git checkout` e `git push origin` no mesmo comando!**

### 📌 Criando uma nova branch de tarefa

```bash
# 1. Ir para a main
git checkout main

# 2. Atualizar a main com últimas alterações do repositório remoto
git pull origin main

# 3. Criar uma nova branch baseada na main
git checkout -b feat/nome-da-tarefa

# 4. Adicionar arquivos modificados
git add NomeDoArquivo.java

# 5. Criar o commit
git commit -m "feat: descrição da atividade realizada"

# 6. Enviar para o GitHub
git push origin feat/nome-da-tarefa
```

---

### 🔄 Atualizando todas as branches locais

```bash
git fetch --prune
```

---

### 🔃 Atualizando a branch `main`

```bash
git checkout main
git pull origin main
```

---

### 📝 Convenção de Commits

Use prefixos para indicar o tipo de alteração:

| Tipo      | Descrição                                 |
|-----------|-------------------------------------------|
| feat      | Nova funcionalidade                       |
| fix       | Correção de bug                           |
| refactor  | Refatoração de código (sem alterar comportamento) |
| chore     | Tarefas administrativas ou ajustes menores |
| docs      | Alterações na documentação                |

**Exemplo:**

```bash
git commit -m "feat: adiciona tela de cadastro de pets"
```

---

## 🖥️ Como rodar o projeto localmente

> Pré-requisitos: Java 17+, Maven, JavaFX

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/mentoria-java.git
cd mentoria-java

# 2. Compile o projeto com Maven
mvn clean install

# 3. Execute a aplicação
mvn javafx:run
```
