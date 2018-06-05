package com.example.dell.registropc.Pojo;

/**
 * Created by dell on 05/06/2018.
 */

public class Registro {
    private String nombrePc,serial,fechaIngreso,fechaSalida;
    private int estado,piso, idRegistro;

    public Registro(int idRegistro, String nombrePc, String serial, String fechaIngreso, String fechaSalida, int estado, int piso) {
        this.nombrePc = nombrePc;
        this.serial = serial;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.piso = piso;
        this.idRegistro = idRegistro;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombrePc() {
        return nombrePc;
    }

    public void setNombrePc(String nombrePc) {
        this.nombrePc = nombrePc;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
