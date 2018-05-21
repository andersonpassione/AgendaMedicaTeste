package logus.test.dao;

import java.util.List;

import org.hibernate.classic.Session;

import logus.test.model.CadastroMedico;
import logus.test.persistance.HibernateUtil;

public class CadastroMedicoDao {

	public List<CadastroMedico> getListaMedicos() {

		// Abertura de conexão com o banco
		// CTRL1 para criar a variavel da conexão
		Session session = HibernateUtil.openSession();

		// funções a serem executadas na conexão do banco
		try {
			// o critério são as funcoes basicas (select/delete/insert)
			return session.createCriteria(CadastroMedico.class).list();

		} finally {
			// depois executado, conexão é fechada
			session.close();
		}

	}

}
