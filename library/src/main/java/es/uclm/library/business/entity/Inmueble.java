package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Inmueble {

	Propietario propietario;
	Collection<Reserva> reservas;
	Collection<ListaDeseos> listaDeseos;
	Collection<Disponibilidad> disponibilidades;
	Collection<SolicitudReserva> solicitudesReserva;
	private String direccion;
	private double precioNoche;

}