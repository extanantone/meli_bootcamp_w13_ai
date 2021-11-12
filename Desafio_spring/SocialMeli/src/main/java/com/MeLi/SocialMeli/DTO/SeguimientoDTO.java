package com.MeLi.SocialMeli.DTO;

public class SeguimientoDTO {
    private int idSeguidor;
    private String nombreSeguidor;
    private int idSeguido;
    private String nombreSeguido;
    private String msj;

    public SeguimientoDTO(int idSeguidor, String nombreSeguidor, int idSeguido, String nombreSeguido, String msj){
        this.idSeguidor = idSeguidor;
        this.nombreSeguidor = nombreSeguidor;
        this.idSeguido = idSeguido;
        this.nombreSeguido = nombreSeguido;
        this. msj = msj;
    }

    public SeguimientoDTO(String msj){
        this.msj = msj;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public int getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(int idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public String getNombreSeguidor() {
        return nombreSeguidor;
    }

    public void setNombreSeguidor(String nombreSeguidor) {
        this.nombreSeguidor = nombreSeguidor;
    }

    public int getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(int idSeguido) {
        this.idSeguido = idSeguido;
    }

    public String getNombreSeguido() {
        return nombreSeguido;
    }

    public void setNombreSeguido(String nombreSeguido) {
        this.nombreSeguido = nombreSeguido;
    }
}
