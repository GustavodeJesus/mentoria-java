# 📚 Mentoria Java

![Java](https://img.shields.io/badge/Java-23+-brightgreen?logo=java&logoColor=white)
![Status](https://img.shields.io/badge/build-passing-brightgreen)
![Platform](https://img.shields.io/badge/platform-desktop-blue)

Este projeto foi desenvolvido como parte de uma **mentoria Java** para um grupo de 5 alunos, com o objetivo de proporcionar uma formação completa e prática em desenvolvimento de software. Ao longo da jornada, os participantes aprendem desde os fundamentos de **lógica de programação** e **Programação Orientada a Objetos (POO)**, até a criação de interfaces gráficas com **JavaFX** para aplicações desktop. Também exploramos o uso de **bancos de dados relacionais**, construção de **APIs RESTful** com Java, e princípios essenciais de desenvolvimento backend. O foco é aplicar os conceitos de forma progressiva, integrando teoria e prática em um ambiente de aprendizado colaborativo e guiado.

---

## 🚀 Fluxo de Trabalho com Git

⚠️ **Nunca use `git checkout` e `git push origin` no mesmo comando!**

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

> Pré-requisitos: Java 23+, Maven 3+, JavaFX

### 📦 Clone o repositório

```bash
git clone https://github.com/seu-usuario/mentoria-java.git
cd mentoria-java
```

---

### 🪟 Windows (PowerShell)

```bash
# Executar o script para configurar o JavaFX
./scripts/install-openjfx.ps1

# Compilar o projeto com Maven
mvn clean install
```

---

### 🐧 MacOS / Linux

```bash
# Executar o script para configurar o JavaFX
chmod +x scripts/install-openjfx.sh
./scripts/install-openjfx.sh

# Compilar o projeto com Maven
mvn clean install
```

## 🛠️ Configure o IntelliJ

### 📍 Etapas para rodar o projeto no IntelliJ:

1. **Abra a classe `HomeApp`**
2. Clique no botão de execução (▶️) à esquerda da assinatura da classe
3. Selecione a opção **Modify Run Configuration**

![Imagem ilustrativa: Editar configuração](/docs/edit_configurations.png)

4. Na tela de configurações, clique em **"Add VM Options"**

![Imagem ilustrativa: VM Options](/docs/edit_vm_options.png)

5. No campo **VM Options**, insira o seguinte comando:

```bash
--module-path tools/javafx-sdk-24/lib --add-modules javafx.controls,javafx.fxml
```

6. Clique em **OK** ou **Apply** para salvar a configuração

7. Pressione ▶️ para rodar sua aplicação com JavaFX!

