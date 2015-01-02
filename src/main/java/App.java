
import br.com.pos.hotel.beans.Hotel;
import br.com.pos.hotel.dao.GenericDAO;
import br.com.pos.hotel.dao.GenericDAOImp;
import br.com.pos.hotel.services.ReservaService;
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
//        Endereco endereco = new Endereco("Rua do bobos", "Cidade", "Estado", "68.234-023", "500");
//        Hotel hotel = new Hotel("Gravatá", endereco);

//        Map<String, Object> params = new HashMap();
//        params.put("nome", "Gravatá");
//        
        GenericDAO genericDAO = new GenericDAOImp();
//        Hotel hotel1 = (Hotel) genericDAO.getSingleResultOfNamedQuery("Hotel.getHotelByName",params);
//        
//        Quarto quarto = new Quarto(1, false, 30.00);
//        hotel1.addQuarto(quarto);
//        
//        genericDAO.update(hotel1);
//
//        Quarto quarto = (Quarto) genericDAO.getListResultOfNamedQueryWithLimit("Quarto.getDesocupado",0, 1).get(0);
//        System.out.println(quarto);

        List<Hotel> hoteis = genericDAO.getAll(Hotel.class);

        for (Hotel hotei : hoteis) {
            System.out.println(hotei.getNome());
        }

        ReservaService reservaService = new ReservaService();
        hoteis = reservaService.getHoteis();
        for (Hotel hotei : hoteis) {
            System.out.println(hotei.getNome());
        }
    }
}
