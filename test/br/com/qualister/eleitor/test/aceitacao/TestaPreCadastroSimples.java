package br.com.qualister.eleitor.test.aceitacao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestaPreCadastroSimples {

	WebDriver driver = null;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://eliasnogueira.com/arquivos_blog/geral/eleitor/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testaPodeVotar() {
		driver.findElement(By.id("nome")).sendKeys("Elias Nogueira");
		driver.findElement(By.id("nascimento")).sendKeys("1982");
		driver.findElement(By.id("enviar")).click();
		
		assertEquals("Elias Nogueira", driver.findElement(By.name("nome_eleitor")).getText());
		assertEquals("32", driver.findElement(By.name("idade_eleitor")).getText());
		
		driver.findElement(By.id("sim")).click();
		
		assertEquals("Seu recibo", driver.findElement(By.tagName("h4")).getText());
		assertFalse(driver.findElement(By.cssSelector("p.center")).getText().isEmpty());
	}
	
	@Test
	public void naoPodeVotar() {
		driver.findElement(By.id("nome")).sendKeys("Bart Simpson");
		driver.findElement(By.id("nascimento")).sendKeys("2000");
		driver.findElement(By.id("enviar")).click();
		
		assertEquals("Bart Simpson", driver.findElement(By.name("nome_eleitor")).getText());
		assertEquals("14", driver.findElement(By.name("idade_eleitor")).getText());
		
		assertEquals("Atenção\nVocê não pode votar!", driver.findElement(By.cssSelector(".alert.alert-danger")).getText());
	}

	@Test
	public void votoFacultativo() {
		driver.findElement(By.id("nome")).sendKeys("Vovó Gertrudes");
		driver.findElement(By.id("nascimento")).sendKeys("1944");
		driver.findElement(By.id("enviar")).click();
		
		assertEquals("Vovó Gertrudes", driver.findElement(By.name("nome_eleitor")).getText());
		assertEquals("70", driver.findElement(By.name("idade_eleitor")).getText());
		
		assertEquals("Atenção\nSeu voto é facultativo!", driver.findElement(By.cssSelector(".alert.alert-warning")).getText());
	}	
	
}
