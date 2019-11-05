package com.nobre.graficos;

public class DadosMesNumero {
    private String mes;
    private double numero;

    public DadosMesNumero() {
    }

    public DadosMesNumero(String mes, double numero) {
        this.mes = mes;
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
