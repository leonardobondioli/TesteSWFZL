package br.emprestimo.testeUnitario;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UC01RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		emprestimo = new Emprestimo();
		servico = new ServicoEmprestimo();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//Registro de Empréstimo
	@Test
	public void CT01UC01FB_registrar_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_livro_invalidos() {
		assertNotNull(servico.empresta(null, usuario));
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_usuario_invalidos() {
		assertNotNull(servico.empresta(livro, null));
	}
	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos(){
		try{
			servico.empresta(null, usuario);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}
	@Test
	public void CT04UC01FB_registrar_emprestimo_com_sucesso_validacao_da_data() {
		//acao
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		//verificacao
	    assertTrue(dataEsperada.equals(dataObtida));
	}
	@Test
	public void CT05UC01FB_registrar_emprestimo_com_data_invalida() {
		assertTrue(emprestimo.validaData("29-03-2000"));
	}
	@Test
	public void CT05UC01FB_registrar_emprestimo_com_dados_invalida() {
		assertTrue(emprestimo.validaData("29/03/2000"));
	}
	//Serviço Empresitimo
	
	//Cadastros de livros
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
	//fim teste livros
	
	//Test Emprestimo
	@Test
	public void CT03UC02CadastraEmprestimo_com_livro_valido() {
		assertEquals(livro, emprestimo.getLivro());
	}
	@Test
	public void CT03UC02CadastraEmprestimo_com_usuario_valido() {
		assertEquals(usuario, emprestimo.getUsuario());
	}
	
	//Test Com usuário
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
	@Test(expected=RuntimeException.class)
	public void CT02UC03CadastrarUsuario_com_ra_invalido_branco() {
		usuario.setRa("");
	}
	
	@Test
	public void CT02UC03CadastraUsuario_com_ra_valido() {
		assertEquals("11111", usuario.getRa());
	}
	@Test
	public void CT03UC06CadastraUsuario_com_nome_valido() {
		assertEquals("Jose da Silva", usuario.getNome());
	}
	@Test
	public void CT03UC06CadastraUsuario_com_nome_invalido() {
		assertEquals("Presman", usuario.getNome());
	}
	
	
	@Test
	public void CT04UC06CadastraUsuario_com_obj_invalido() {
		usuario.equals(livro);
	}
	@Test
	public void CT04UC06CadastraUsuario_com_obj_valido() {
		usuario.equals(usuario);
	}
	@Test
	public void CT04UC06CadastraUsuario_com_class_valido() {
		usuario.equals(usuario);
	}
}
