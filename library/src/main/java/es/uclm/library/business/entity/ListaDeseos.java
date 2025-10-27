package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListaDeseos {

	Inquilino usuario;
	Collection<Inmueble> inmuebles;

}