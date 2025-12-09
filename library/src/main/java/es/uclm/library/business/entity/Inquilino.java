package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "inquilinos")
public class Inquilino extends Usuario {

    @OneToMany(mappedBy = "inquilino", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ListaDeseos listaDeseos;

    public Inquilino() {}

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public ListaDeseos getListaDeseos() { return listaDeseos; }
    public void setListaDeseos(ListaDeseos listaDeseos) { this.listaDeseos = listaDeseos; }
}