package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
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

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date disponibleDesde;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date disponibleHasta;
    public Date getDisponibleDesde() { return disponibleDesde; }
    public void setDisponibleDesde(Date disponibleDesde) { this.disponibleDesde = disponibleDesde; }

    public Date getDisponibleHasta() { return disponibleHasta; }
    public void setDisponibleHasta(Date disponibleHasta) { this.disponibleHasta = disponibleHasta; }
    private String imagen;
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
