package br.com.caelum.leilao.systemtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class UsuariosPage {

	private WebDriver driver;

	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(new URLDaAplicacao().getUrlBase() +  "/usuarios");
	}

	public NovoUsuarioPage novo() {
		// clica no link de novo usuario
		driver.findElement(By.linkText("Novo Usu�rio")).click();
		// retorna a classe que representa a nova pagina
		return new NovoUsuarioPage(driver);
	}

	public boolean existeNaListagem(String nome, String email) {
		// verifica se ambos existem na listagem
		return driver.getPageSource().contains(nome)
				&& driver.getPageSource().contains(email);
	}

	public boolean usuarioObrigatorio() {
		// verifica se ambos existem na listagem
		return driver.getPageSource().contains("Nome obrigatorio!");
	}

	public boolean emailObrigatorio() {
		// verifica se ambos existem na listagem
		return driver.getPageSource().contains("E-mail obrigatorio!");
	}

	public void deletaUsuarioNaPosicao(int posicao) {
		driver.findElements(By.tagName("button")).get(posicao - 1).click();
		// pega o alert que est� aberto
		Alert alert = driver.switchTo().alert();
		// confirma
		alert.accept();
	}
	
	public AlteraUsuarioPage alteraUsuarioNaPosicao(int posicao) {
		// clica no link de editar usuario
		driver.findElements(By.linkText("editar")).get(posicao-1).click();		
		// retorna a classe que representa a nova pagina
		return new AlteraUsuarioPage(driver);
	}
}
