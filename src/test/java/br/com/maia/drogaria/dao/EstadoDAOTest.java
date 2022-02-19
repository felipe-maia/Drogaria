package br.com.maia.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.maia.drogaria.domain.Estado;
import br.com.maia.drograria.dao.EstadoDAO;

public class EstadoDAOTest {

	@Ignore
	@Test
	public void salvar() {

		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		EstadoDAO estadoDAO = new EstadoDAO();

		estadoDAO.salvar(estado);

	}

	@Ignore
	@Test
	public void listar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	public void bucar() {

		Long codigo = 3L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			System.out.println("Registro encontrado: " + estado.getNome() + " - " + estado.getSigla());
		}
	}

}
