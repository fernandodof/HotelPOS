package br.com.pos.hotel.services;

import br.com.pos.hotel.beans.Hotel;
import br.com.pos.hotel.beans.Pessoa;
import br.com.pos.hotel.beans.Quarto;
import br.com.pos.hotel.beans.Reserva;
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
     *
     * @return
     */
    @WebMethod(operationName = "getHoteis")
    public List<Hotel> getHoteis() {
        return dao.getAll(Hotel.class);
    }

    @WebMethod(operationName = "getHotelById")
    public Hotel getHotelById(int id) {
        return (Hotel) dao.getById(Hotel.class, id);
    }

    @WebMethod(operationName = "getQuartoByID")
    public Quarto getQuartoById(int id) {
        return (Quarto) dao.getById(Quarto.class, id);
    }

    /**
     * Web service operation
     *
     * @param idHotel
     * @param idQuarto
     * @param nomePessoa
     * @param documento
     * @param dataEntrada
     * @param dataSaida
     * @return
     */
    @WebMethod(operationName = "Reservar")
    public boolean reservar(int idHotel,int idQuarto, String nomePessoa, String documento, Date dataEntrada, Date dataSaida) {
        Quarto quarto = (Quarto) dao.getById(Quarto.class, idQuarto);
        Reserva reserva = new Reserva(dataEntrada, dataSaida);

        Pessoa pessoa = new Pessoa(nomePessoa, documento, quarto, reserva);
        dao.save(pessoa);
        
        Hotel hotel = (Hotel) dao.getById(Hotel.class, idHotel);
        hotel.addReserva(reserva);
        dao.update(hotel);
        
        return true;
    }

    @WebMethod(operationName = "getListaReservas")
    public List<Reserva> getListaReservas() {
        return dao.getAll(Reserva.class);
    }
}
