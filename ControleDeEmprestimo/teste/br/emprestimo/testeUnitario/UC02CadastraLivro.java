package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Livro;

public class UC02CadastraLivro {
	public static Livro livro;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		livro = new Livro();
		livro.setIsbn("111111");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//Classes para testar o isbn
	@Test(expected=RuntimeException.class)
	public void CT01UC02CadastraLivro_com_isbn_invalido_branco() {
		livro.setIsbn("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT01UC02CadastraLivro_com_isbn_invalido_nulo() {
		livro.setIsbn(null);
	}
	
	@Test
	public void CT01UC02CadastraLivro_com_isbn_valido() {
		assertEquals("111111", livro.getIsbn());
	}
	
	//Classes Para testar o titulo
	@Test(expected=RuntimeException.class)
	public void CT02UC02CadastraLivro_com_titulo_invalido_branco() {
		livro.setTitulo("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT02UC02CadastraLivro_com_titulo_invalido_nulo() {
		livro.setTitulo(null);
	}
	
	@Test
	public void CT02UC02CadastraLivro_com_titulo_valido() {
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	//Classes de teste do Autor
	@Test(expected=RuntimeException.class)
	public void CT03UC02CadastraLivro_com_autor_invalido_branco() {
		livro.setAutor("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT03UC02CadastraLivro_com_autor_invalido_nulo() {
		livro.setAutor(null);
	}
	
	@Test
	public void CT03UC02CadastraLivro_com_autor_valido() {
		assertEquals("Pressman", livro.getAutor());
	}
	
	
	

}

