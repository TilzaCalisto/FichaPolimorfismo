package model;

public class Carro extends Veiculo {
    private int portas;
    
    public Carro(String marca, String modelo, int portas) {
        super(marca, modelo);
        this.portas = portas;
    }
    
    public int getPortas() { return portas; }
    public void setPortas(int portas) { this.portas = portas; }
    
    @Override
    public String mover() {
        return "Carro " + marca + " " + modelo + " está acelerando nas estradas!";
    }
    
    @Override
    public String toString() {
        return "Carro{" + "marca='" + marca + "', modelo='" + modelo + "', portas=" + portas + "}";
    }
}