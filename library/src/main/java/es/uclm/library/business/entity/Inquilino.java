package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Inquilino extends Usuario {

	Collection<Reserva> reservas;
	ListaDeseos listaDeseos;

}