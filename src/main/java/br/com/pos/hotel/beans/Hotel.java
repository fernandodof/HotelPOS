package br.com.pos.hotel.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Fernando
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Hotel.getHotelByName", query = "SELECT H FROM Hotel H WHERE H.nome = :nome"),
    @NamedQuery(name = "Hotel.getQuartosDesocupados", query = "SELECT Q FROM Hotel H, IN (H.quartos) Q WHERE H.nome LIKE :nome AND Q.ocupado = FALSE"),
    @NamedQuery(name = "Hotel.getQuartosDesocupadosByIdHotel", query = "SELECT Q FROM Hotel H, IN (H.quartos) Q WHERE H.id = :id AND Q.ocupado = FALSE"),
})
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nome;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Quarto> quartos = new ArrayList();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList();

    public Hotel() {
    }

    public Hotel(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }
    
    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", quartos=" + quartos + ", reservas=" + reservas + '}';
    }

}
