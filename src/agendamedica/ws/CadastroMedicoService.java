package agendamedica.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logus.test.bo.CadastroMedicoBo;

//defini a URL para acesso da classe
@Path("/cadastro-medico")

public class CadastroMedicoService {

	@Path("/listAll")
	@GET

	public Object getListaMedico() {

		return "Hello service";
//		Gson gson = new GsonBuilder().create();
//		return gson.toJson(new CadastroMedicoBo().getListaMedicos());
//	}
	}
}
