package br.emprestimo.testeUnitario;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Usuario;

public class UC03CadastraUsuario {
	public static Usuario usuario;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//Classes para testar o nome
	@Test(expected=RuntimeException.class)
	public void CT01UC03CadastraUsuario_com_nome_invalido_branco() {
		usuario.setNome("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT01UC03CadastraUsuario_com_nome_invalido_nulo() {
		usuario.setNome(null);
	}
	
	@Test
	public void CT01UC03CadastraUsuario_com_nome_valido() {
		assertEquals("Jose da Silva", usuario.getNome());
	}
	
	//Classes para testar o ra	
	@Test(expected=RuntimeException.class)
	public void CT02UC03CadastraUsuario_com_ra_invalido_branco() {
		usuario.setRa("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT02UC03CadastrarUsuario_com_ra_invalido_nulo() {
		usuario.setRa(null);
	}
	
	@Test
	public void CT02UC03CadastraUsuario_com_ra_valido() {
		assertEquals("11111", usuario.getRa());
	}
	
	//Classes para testar o 
	
	/*
	@Test(expected=RuntimeException.class)
	public void CT03UC06CadastraLivro_com_autor_invalido_branco() {
		livro.setAutor("");
	}
	
	@Test(expected=RuntimeException.class)
	public void CT03UC06CadastraLivro_com_autor_invalido_nulo() {
		livro.setAutor(null);
	}
	
	@Test
	public void CT03UC06CadastraLivro_com_autor_valido() {
		assertEquals("Pressman", livro.getAutor());
	}
	*/
	
	

}

