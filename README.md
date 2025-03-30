# mentoria-java

>> Checkout e origin nunca no mesmo comando <<

> Criando nova demanda/branch

	- Para criar new branch - git checkout -b feat/nomeDaTarefa
	- Demandas...
	- Adicionar arquivos criados/alterados - git add nomeDoArquivo
	- Criar commit - git commit -m "feat: descriação da atividade realizada"
	- Enviar mudanças para o GitHub - git push origin nomeDaBranch

> Criação de nova branch

	- Ir para main - git checkout main
	- Atualizar branch main - git pull origin main
	- Criar branch a partir da main - git checkout -b feat/nomeDaTarefa

> Atualizar Branch's

	- Atualiza todas as branchs para sua máquina e apaga as locais não mergiadas - git fetch --prune
    - Atualiza todas as branchs para sua máquina e mantem as locais - git fetch
    - Atualizar branch main - git pull origin main

> Atualizar main após requests aprovadas

	- Vai para branch main - git checkout main
	- Atualiza a main com as novas atualizações mergiadas - git pull origin main