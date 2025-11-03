/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cachorro extends Animal {
    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }
    
    @Override
    public void fazerSom() {
        System.out.println(nome + " diz: Au Au!");
    }
    
    @Override
    public String toString() {
        return "Cachorro{" + "nome='" + nome + "', idade=" + idade + "}";
    }
}


