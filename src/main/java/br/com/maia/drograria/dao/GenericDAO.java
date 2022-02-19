package br.com.maia.drograria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.pro.maia.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		// para saber qual o tipo da classe filha que esta sendo trabalhada em tempo de
		// execução
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void salvar(Entidade entidade) {

		// abre sessao
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		// transaction para garantir o processo completo
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.save(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback(); // desfaz a operação em caso de falha
			}
			throw erro; // propaga msg de erro
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = sessao.createCriteria(this.classe);
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = sessao.createCriteria(this.classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
