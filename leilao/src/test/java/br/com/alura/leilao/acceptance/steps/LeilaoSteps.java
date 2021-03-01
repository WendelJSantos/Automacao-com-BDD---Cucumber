package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {

	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@Dado("um usuario logado")
	public void um_usuario_logado() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}

	@Quando("prenche o formulario com dados validos")
	public void prenche_o_formulario_com_dados_validos() {
		leiloesPage.setNome("Leilao teste");
		leiloesPage.setValorInicial("150.50");
		leiloesPage.setDataAbertura("14/12/1995");
		leiloesPage.clicarSalvar();
	}

	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
	Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());	
	
	}

	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
		Assert.assertEquals("Leilão salvo com sucesso", leiloesPage.mensagemSucesso());
		
		this.leiloesPage.existe("Leilao teste", "150.50", "14/12/1995");
		this.browser.clean();
	}

}
