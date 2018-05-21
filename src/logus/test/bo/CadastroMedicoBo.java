package logus.test.bo;

import java.util.List;
import logus.test.dao.CadastroMedicoDao;
import logus.test.model.CadastroMedico;

public class CadastroMedicoBo {

	public List<CadastroMedico> getListaMedicos() {
		return new CadastroMedicoDao().getListaMedicos();
	}
}
