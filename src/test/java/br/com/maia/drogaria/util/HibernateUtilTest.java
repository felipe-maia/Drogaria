package br.com.maia.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

import br.pro.maia.drogaria.util.HibernateUtil;

public class HibernateUtilTest {

	@Test
	public void conectar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();

	}

}
