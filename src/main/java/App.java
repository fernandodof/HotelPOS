
import br.com.pos.hotel.beans.Reserva;
import br.com.pos.hotel.dao.GenericDAO;
import br.com.pos.hotel.dao.GenericDAOImp;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando
 */
public class App {

    public static void main(String args[]) {        
        GenericDAO genericDAO = new GenericDAOImp();
//        Endereco endereco = new Endereco("Rua do bobos", "Cidade", "Estado", "68.234-023", "500");
//        Hotel hotel = new Hotel("Gravatá", endereco);
//        genericDAO.save(hotel);

//        Map<String, Object> params = new HashMap();
//        params.put("nome", "Gravatá");
//        

//        Hotel hotel1 = (Hotel) genericDAO.getSingleResultOfNamedQuery("Hotel.getHotelByName",params);
//        
//        Quarto quarto = new Quarto(1, false, 30.00);
//        hotel.addQuarto(quarto);
//        
//        genericDAO.update(hotel);
//
//        Quarto quarto = (Quarto) genericDAO.getListResultOfNamedQueryWithLimit("Quarto.getDesocupado",0, 1).get(0);
//        System.out.println(quarto);

//        List<Hotel> hoteis = genericDAO.getAll(Hotel.class);
//
//        for (Hotel hotei : hoteis) {
//            System.out.println(hotei.getNome());
//        }
//
//        ReservaService reservaService = new ReservaService();
//        hoteis = reservaService.getHoteis();
//        for (Hotel hotei : hoteis) {
//            System.out.println(hotei.getNome());
//        }
        
        List<Reserva> rs = genericDAO.getAll(Reserva.class);
        
        for (Reserva r : rs) {
            System.out.println(r);
        }
        
    }
}
