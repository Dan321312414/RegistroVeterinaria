package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mascota {
    private String nombre;
    private String tipoMascota;
    private String raza;
    private String colorPelaje;
    private int edad;
    private String nombreDueno;
    private String dniDueno;
    private String tipoServicio;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Mascota(String nombre, String tipoMascota, String raza, String colorPelaje, int edad, String nombreDueno, String dniDueno) {
        this.nombre = nombre;
        this.tipoMascota = tipoMascota;
        this.raza = raza;
        this.colorPelaje = colorPelaje;
        this.edad = edad;
        this.nombreDueno = nombreDueno;
        this.dniDueno = dniDueno;
        this.horaEntrada = LocalDateTime.now(); 
    }

    public Mascota() {}

    public void calcularHoras(String tipoServicio, int cantidadVacunas) {
        this.horaEntrada = LocalDateTime.now(); 
        if (tipoServicio.equals("Baño")) {
            this.horaSalida = horaEntrada.plusMinutes(60); 
        } else if (tipoServicio.equals("Vacunas")) {
            this.horaSalida = horaEntrada.plusMinutes(cantidadVacunas * 20); 
        }
    }

   
    public String getNombre() { return nombre; }
    public String getTipoMascota() { return tipoMascota; }
    public String getRaza() { return raza; }
    public String getColorPelaje() { return colorPelaje; }
    public int getEdad() { return edad; }
    public String getNombreDueno() { return nombreDueno; }
    public String getDniDueno() { return dniDueno; }
    public String getTipoServicio() { return tipoServicio; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public LocalDateTime getHoraSalida() { return horaSalida; }

    public String getHoraEntradaFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return horaEntrada.format(formatter);
    }

    public String getHoraSalidaFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return horaSalida.format(formatter);
    }

    public void setTipoServicio(String tipoServicio) { this.tipoServicio = tipoServicio; }

    int getId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setNombre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setTipoMascota(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setRaza(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setColorPelaje(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setEdad(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setNombreDueno(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setDniDueno(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setEnfermedad(String enfermedad) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setVacuna(String vacuna) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
