package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    private UUID referencia = UUID.randomUUID();

    public Pago() {}

    public int getId() { return id; }

    public MetodoPago getMetodo() { return metodo; }
    public void setMetodo(MetodoPago metodo) { this.metodo = metodo; }

    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    public UUID getReferencia() { return referencia; }
    public void setReferencia(UUID referencia) { this.referencia = referencia; }
}