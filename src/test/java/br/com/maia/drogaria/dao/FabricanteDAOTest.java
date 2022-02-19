package br.com.maia.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.maia.drogaria.domain.Fabricante;
import br.com.maia.drograria.dao.FabricanteDAO;

public class FabricanteDAOTest {

	@Ignore
	@Test
	public void salvar() {

		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Diagnósticos do Brasil");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);

	}

	@Test
	public void listar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getDescricao());
		}
	}

	@Test
	public void buscar() {

		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");

		} else {
			System.out.println("Registro encontrado: " + fabricante.getDescricao());
		}

	}

}
