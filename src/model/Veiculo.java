package model;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    protected String marca;
    protected String modelo;
    
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    // Getters e Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    // Método abstrato
    public abstract String mover();
    
    @Override
    public String toString() {
        return "Veículo{" + "marca='" + marca + "', modelo='" + modelo + "'}";
    }
}