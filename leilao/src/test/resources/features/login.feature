#language: pt

Funcionalidade: Apenas usuarios cadastrados podem se logar

	Cenario: Um usuario valido consegue se logar
	Dado o usuario valido
	Quando realiza login
	Entao é direcionado para a pagina de leiloes
	
	Cenario: Um usuario invalido nao consegue logar
	Dado um usuario invalido
	Quando tenta se logar
	Entao continua na pagina de login