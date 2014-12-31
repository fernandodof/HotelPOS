package br.com.pos.hotel.services;

import br.com.pos.hotel.beans.Hotel;
import br.com.pos.hotel.dao.GenericDAO;
import br.com.pos.hotel.dao.GenericDAOImp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Fernando
 */
@WebService
public class ReservaService {

    private GenericDAO genericDAO = new GenericDAOImp();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Reservar")
    public int Reservar(String nomeHotel, String nomePessoa, String documento, Date dataEntrada, Date dataSaida) {
        Map<String, Object> params = new HashMap();
        params.put("nome", nomeHotel);
        Hotel hotel = (Hotel) genericDAO.getSingleResultOfNamedQuery("Hotel.getHotelByName", params);
        
        ///Fezendo
        
        return 1;
    }

}
