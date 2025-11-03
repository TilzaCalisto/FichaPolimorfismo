/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Gato extends Animal {
    public Gato(String nome, int idade) {
        super(nome, idade);
    }
    
    @Override
    public void fazerSom() {
        System.out.println(nome + " diz: Miau!");
    }
    
    @Override
    public String toString() {
        return "Gato{" + "nome='" + nome + "', idade=" + idade + "}";
    }
}