# encoding: UTF-8
# language: pt

Funcionalidade: Validação pré-cadastro de eleitores

	Cenario: Pre-cadastro dentro do voto obrigatorio
		Dado que eu estou na pagina de pre-cadastro
		Quando eu informar o nome "Elias Nogueira"
			E quando eu informar o ano de nascimento "1982"
		Entao meu voto e "obrigatorio"	