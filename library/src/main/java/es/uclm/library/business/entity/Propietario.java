package es.uclm.library.business.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "propietarios")
public class Propietario extends Usuario {

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Inmueble> propiedades = new ArrayList<>();

    public Propietario() {}

    public List<Inmueble> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Inmueble> propiedades) {
        this.propiedades = propiedades;
    }
}