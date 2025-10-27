package es.uclm.library.business.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String pass;
    private String nombre;
    private String apellidos;
    private String direccion;  // ojo: sin tilde, Java no admite "dirección"
    private int attribute;     // puede representar rol o tipo de usuario

    //  Constructores
    public Usuario() {}

    public Usuario(String login, String pass, String nombre, String apellidos, String direccion, int attribute) {
        this.login = login;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.attribute = attribute;
    }

    //  Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    //  Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
