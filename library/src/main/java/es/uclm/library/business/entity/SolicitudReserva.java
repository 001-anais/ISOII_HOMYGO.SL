package es.uclm.library.business.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitudes_reserva")
public class SolicitudReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva_confirmada_id")
    private Reserva reservaConfirmada;

    private boolean confirmada;

    public SolicitudReserva() {}

    public int getId() { return id; }

    public Inmueble getInmueble() { return inmueble; }
    public void setInmueble(Inmueble inmueble) { this.inmueble = inmueble; }

    public Reserva getReservaConfirmada() { return reservaConfirmada; }
    public void setReservaConfirmada(Reserva reservaConfirmada) { this.reservaConfirmada = reservaConfirmada; }

    public boolean isConfirmada() { return confirmada; }
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }
}
