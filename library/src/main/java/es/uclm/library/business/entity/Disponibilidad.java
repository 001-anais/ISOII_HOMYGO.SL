package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.Date;

public class Disponibilidad {

	Inmueble inmueble;
	PoliticaCancelacion politicaCancelación;
	private Date fechaInicio;
	private Date fechaFin;
	private double precio;
	private boolean directa;

}