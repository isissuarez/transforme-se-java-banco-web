/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoweb.model;

/**
 *
 * @author DELL
 */
public class Cliente {

    
    private String nome;
    private char sexo;
    private int Id;
   private String email;
    private String estadoCivil;

    public Cliente(String nome, char sexo, String email, String estadoCivil) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
 
}
