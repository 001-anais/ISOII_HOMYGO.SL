package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "inmuebles")
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany(mappedBy = "inmuebles", cascade = CascadeType.ALL)
    private List<ListaDeseos> listaDeseos = new ArrayList<>();

    private String direccion;
    private double precioNoche;

    public Inmueble() {}

    public int getId() { return id; }

    public Propietario getPropietario() { return propietario; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public double getPrecioNoche() { return precioNoche; }
    public void setPrecioNoche(double precioNoche) { this.precioNoche = precioNoche; }

    public List<ListaDeseos> getListaDeseos() { return listaDeseos; }
    public void setListaDeseos(List<ListaDeseos> listaDeseos) { this.listaDeseos = listaDeseos; }
}
