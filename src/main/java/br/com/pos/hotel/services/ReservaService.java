package br.com.pos.hotel.services;

import br.com.pos.hotel.beans.Hotel;
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
     *
     * @param nomeHotel
     * @return
     */
    @WebMethod(operationName = "getListaQuartosDesocupados")
    public List<Quarto> getListaQuartosDesocupadosPorNomeDoHotel(String nomeHotel) {
        Map<String, Object> params = new HashMap();
        params.put("nome", nomeHotel);
        return dao.getListResultOfNamedQuery("Hotel.getQuartosDesocupados", params);
    }

    @WebMethod(operationName = "getListaQuartosDesocupadosPorIdHotel")
    public List<Quarto> getListaQuartosDesocupadosPorIdHotel(int idHotel) {
        Map<String, Object> params = new HashMap();
        params.put("id", idHotel);
        return dao.getListResultOfNamedQuery("Hotel.getQuartosDesocupadosByIdHotel", params);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHoteis")
    public List<Hotel> getHoteis() {
        return dao.getAll(Hotel.class);
    }

    @WebMethod(operationName = "getHotelById")
    public Hotel getHotelById(int id) {
        return (Hotel) dao.getById(Hotel.class, id);
    }

//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "Reservar")
//    public int Reservar(int idQuarto, String nomePessoa, String documento, Date dataEntrada, Date dataSaida) {
//
//    }
}
