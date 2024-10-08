package com.example.formulario;
public class Usuario {

    private int codigoID;
    private String nombre;
    private String apellidos;
    private String documento;
    private int edad;
    private String telefono;
    private String fechaNacimiento;
    private String direccion;
    private String email;
    private String estadoCivil;
    private String genero;
    private String gustos;
    private String equipoFutbol;
    private String peliculaFavorita;
    private String colorFavorito;
    private String comidaFavorita;
    private String libroFavorito;
    private String descripcion;

    // Constructor completo
    public Usuario(int codigoID, String nombre, String apellidos, String documento, int edad, String telefono,
                   String fechaNacimiento, String direccion, String email, String estadoCivil, String genero,
                   String gustos, String equipoFutbol, String peliculaFavorita, String colorFavorito,
                   String comidaFavorita, String libroFavorito, String descripcion) {
        this.codigoID = codigoID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.gustos = gustos;
        this.equipoFutbol = equipoFutbol;
        this.peliculaFavorita = peliculaFavorita;
        this.colorFavorito = colorFavorito;
        this.comidaFavorita = comidaFavorita;
        this.libroFavorito = libroFavorito;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getCodigoID() { return codigoID; }
    public void setCodigoID(int codigoID) { this.codigoID = codigoID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getGustos() { return gustos; }
    public void setGustos(String gustos) { this.gustos = gustos; }

    public String getEquipoFutbol() { return equipoFutbol; }
    public void setEquipoFutbol(String equipoFutbol) { this.equipoFutbol = equipoFutbol; }

    public String getPeliculaFavorita() { return peliculaFavorita; }
    public void setPeliculaFavorita(String peliculaFavorita) { this.peliculaFavorita = peliculaFavorita; }

    public String getColorFavorito() { return colorFavorito; }
    public void setColorFavorito(String colorFavorito) { this.colorFavorito = colorFavorito; }

    public String getComidaFavorita() { return comidaFavorita; }
    public void setComidaFavorita(String comidaFavorita) { this.comidaFavorita = comidaFavorita; }

    public String getLibroFavorito() { return libroFavorito; }
    public void setLibroFavorito(String libroFavorito) { this.libroFavorito = libroFavorito; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
