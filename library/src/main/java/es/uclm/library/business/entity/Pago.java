package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.UUID;

public class Pago {

	MetodoPago metodo;
	Reserva reserva;
	private UUID referencia;

}