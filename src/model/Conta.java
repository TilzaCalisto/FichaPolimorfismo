/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
import java.io.Serializable;

public interface Conta extends Serializable {
    double calcularTaxa();
    String getNumeroConta();
    double getSaldo();
    String getTipoConta();
}