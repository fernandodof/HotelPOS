/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pos.hotel.services;

import br.com.pos.hotel.beans.Hotel;
import br.com.pos.hotel.beans.Quarto;
import br.com.pos.hotel.dao.GenericDAO;
import br.com.pos.hotel.dao.GenericDAOImp;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Fernando
 */
@WebService
public class ServicoInterno {

    private final GenericDAO dao = new GenericDAOImp();

    @WebMethod
    public boolean addHotel(Hotel hotel) {
        return dao.save(hotel);
    }

    public boolean addQuarto(int idHotel, Quarto quarto) {
        if (dao.save(quarto)) {
            Hotel hotel = (Hotel) dao.getById(Hotel.class, idHotel);
            hotel.addQuarto(quarto);
            return dao.update(hotel);
        }else{
            return false;
        }
    }
}
