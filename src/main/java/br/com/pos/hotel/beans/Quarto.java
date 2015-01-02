package br.com.pos.hotel.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Fernando
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Quarto.getDesocupados", query = "SELECT q FROM Quarto q WHERE q.ocupado = FALSE")})
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int capacidade;
    private boolean ocupado;
    private double valor;

    public Quarto() {
    }

    public Quarto(int capacidade, boolean ocupado, double valor) {
        this.capacidade = capacidade;
        this.ocupado = ocupado;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Quarto{" + "id=" + id + ", capacidade=" + capacidade + ", ocupado=" + ocupado + ", valor=" + valor + '}';
    }

}
