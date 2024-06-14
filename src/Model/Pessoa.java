/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class Pessoa {
    private String nome;
    private String CPF;
    private Date Aniversario;
    private int idade;
    private String telefone;

    public Pessoa(String Nome, String CPF, String Aniversario, String telefone) throws ParseException {
        this.nome = Nome;
        this.CPF = CPF;
        TransformaData(Aniversario);
        CalcularIdade();
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }


    public String getAniversario() {
        
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this.Aniversario);
        int dia_aniver = calendario.get(Calendar.DAY_OF_MONTH);
        int mes_aniver = calendario.get(Calendar.MONTH)+1;
        int ano_aniver = calendario.get(Calendar.YEAR);
        
        return (dia_aniver+"/"+mes_aniver+"/"+ano_aniver);
    }

    public void setAniversario(String Aniversario) throws ParseException {
        TransformaData(Aniversario);
    }

    public int getIdade() {
        return idade;
    }
     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  
    private void TransformaData(String Aniversario) throws ParseException{

        SimpleDateFormat formato__data = new SimpleDateFormat("dd/MM/yyyy");

        this.Aniversario = formato__data.parse(Aniversario);

    }
 private void CalcularIdade(){
        Date Hoje = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(Hoje);
        int dia_hoje = calendario.get(Calendar.DAY_OF_MONTH);
        int mes_hoje = calendario.get(Calendar.MONTH)+1;
        int ano_hoje = calendario.get(Calendar.YEAR);
        
        calendario.setTime(this.Aniversario);
        int dia_aniver = calendario.get(Calendar.DAY_OF_MONTH);
        int mes_aniver = calendario.get(Calendar.MONTH)+1;
        int ano_aniver = calendario.get(Calendar.YEAR);
        
        this.idade = ano_hoje - ano_aniver;
        if(mes_hoje < mes_aniver){
           this.idade--;
        } else if((mes_hoje == mes_aniver) && (dia_hoje < dia_aniver)){
            this.idade--;
        }
        if(this.idade<0){
            this.idade = 0;
        }
   
    }
    }      
        
   
    


    