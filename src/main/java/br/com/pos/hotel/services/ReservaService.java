package br.com.pos.hotel.services;

import br.com.pos.hotel.beans.Quarto;
import br.com.pos.hotel.dao.GenericDAO;
import br.com.pos.hotel.dao.GenericDAOImp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Fernando
 */
@WebService
public class ReservaService {

    private final GenericDAO dao = new GenericDAOImp();

    /**
     * Web service operation
     * @param nomeHotel
     * @return 
     */
    @WebMethod(operationName = "getListaQuartosDesocupados")
    public List<Quarto> getListaQuartosDesocupadosPorNomeDoHotel(String nomeHotel) {
        Map<String, Object> params = new HashMap();
        params.put("nome", nomeHotel);
        return dao.getListResultOfNamedQuery("Hotel.getQuartosDesocupados", params);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Reservar")
    public int Reservar(int idQuarto, String nomePessoa, String documento, Date dataEntrada, Date dataSaida) {

    }

}
