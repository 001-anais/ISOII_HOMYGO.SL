package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "listas_deseos")
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "inquilino_id")
    private Inquilino usuario;

    @ManyToMany
    @JoinTable(
            name = "lista_inmuebles",
            joinColumns = @JoinColumn(name = "lista_id"),
            inverseJoinColumns = @JoinColumn(name = "inmueble_id")
    )
    private List<Inmueble> inmuebles = new ArrayList<>();

    public ListaDeseos() {}

    public int getId() { return id; }

    public Inquilino getUsuario() { return usuario; }
    public void setUsuario(Inquilino usuario) { this.usuario = usuario; }

    public List<Inmueble> getInmuebles() { return inmuebles; }
    public void setInmuebles(List<Inmueble> inmuebles) { this.inmuebles = inmuebles; }
}