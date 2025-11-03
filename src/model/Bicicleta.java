package model;

public class Bicicleta extends Veiculo {
    private int marchas;
    
    public Bicicleta(String marca, String modelo, int marchas) {
        super(marca, modelo);
        this.marchas = marchas;
    }
    
    public int getMarchas() { return marchas; }
    public void setMarchas(int marchas) { this.marchas = marchas; }
    
    @Override
    public String mover() {
        return "Bicicleta " + marca + " " + modelo + " está pedalando suavemente!";
    }
    
    @Override
    public String toString() {
        return "Bicicleta{" + "marca='" + marca + "', modelo='" + modelo + "', marchas=" + marchas + "}";
    }
}