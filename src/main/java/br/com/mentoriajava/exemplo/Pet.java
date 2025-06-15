package br.com.mentoriajava.exemplo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Classe que representa um Pet com informações como nome, peso, raça, tipo, data de nascimento e dono.
 */
public class Pet {

    // Atributos do pet
    private final StringProperty nome = new SimpleStringProperty();
    private final StringProperty peso = new SimpleStringProperty();
    private final StringProperty raca = new SimpleStringProperty();
    private final StringProperty tipo = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>();
    private final StringProperty dono = new SimpleStringProperty();

    /**
     * Construtor padrão.
     */
    public Pet() {
    }

    /**
     * Construtor completo para inicializar o pet.
     */
    public Pet(String nome, String peso, String raca, String tipo, LocalDate dataNascimento, String dono) {
        this.nome.set(nome);
        this.peso.set(peso);
        this.raca.set(raca);
        this.tipo.set(tipo);
        this.dataNascimento.set(dataNascimento);
        this.dono.set(dono);
    }

    // Métodos de acesso com propriedades JavaFX (necessários para TableView)

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty pesoProperty() {
        return peso;
    }

    public StringProperty racaProperty() {
        return raca;
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public ObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public StringProperty donoProperty() {
        return dono;
    }

    // Getters e Setters tradicionais

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getPeso() {
        return peso.get();
    }

    public void setPeso(String peso) {
        this.peso.set(peso);
    }

    public String getRaca() {
        return raca.get();
    }

    public void setRaca(String raca) {
        this.raca.set(raca);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }

    public String getDono() {
        return dono.get();
    }

    public void setDono(String dono) {
        this.dono.set(dono);
    }

    @Override
    public String toString() {
        return nome.get() + " - " + tipo.get();
    }
}