package es.uclm.library.business.entity;

import jakarta.persistence.*;

public class SolicitudReserva extends Reserva {

	Inmueble inmueble;
	Reserva reservaConfirmada;
	private boolean confirmada;

	public void confirmarReserva() {
		// TODO - implement SolicitudReserva.confirmarReserva
		throw new UnsupportedOperationException();
	}

}