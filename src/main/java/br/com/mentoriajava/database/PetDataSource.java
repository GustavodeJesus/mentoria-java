package br.com.mentoriajava.database;

import br.com.mentoriajava.exemplo.Pet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Classe singleton que armazena e gerencia uma lista compartilhada de pets.
 */
public class PetDataSource {

    // Instância única (singleton)
    private static final PetDataSource instancia = new PetDataSource();

    // Lista observável de pets
    private final ObservableList<Pet> listaDePets = FXCollections.observableArrayList(
            new Pet("Thor", "10", "Labrador", "Cão", LocalDate.of(2020, 5, 12), "João"),
            new Pet("Mia", "4", "Siamesa", "Gato", LocalDate.of(2021, 2, 28), "Maria"),
            new Pet("Rex", "12", "Pastor Alemão", "Cão", LocalDate.of(2019, 9, 15), "Carlos"),
            new Pet("Luna", "3.5", "Persa", "Gato", LocalDate.of(2022, 1, 5), "Juliana"),
            new Pet("Bidu", "2", "Poodle", "Cão", LocalDate.of(2023, 3, 18), "Fernanda"),
            new Pet("Zezé", "0.8", "Calopsita", "Ave", LocalDate.of(2021, 11, 7), "Roberto"),
            new Pet("Belinha", "9", "Golden Retriever", "Cão", LocalDate.of(2018, 6, 22), "Tatiane"),
            new Pet("Tom", "4.2", "Maine Coon", "Gato", LocalDate.of(2020, 8, 30), "Lucas"),
            new Pet("Pipoca", "1.1", "Hamster", "Roedor", LocalDate.of(2022, 10, 2), "Aline"),
            new Pet("Nina", "7", "Beagle", "Cão", LocalDate.of(2017, 4, 14), "Bruno")
    );

    /**
     * Construtor privado para impedir criação externa.
     */
    private PetDataSource() {
        // Inicializa com alguns dados se quiser
    }

    /**
     * Retorna a instância única da fonte de dados.
     */
    public static PetDataSource getInstancia() {
        return instancia;
    }

    /**
     * Retorna a lista observável de pets (compartilhada).
     */
    public ObservableList<Pet> getListaDePets() {
        return listaDePets;
    }

    /**
     * Adiciona um novo pet à lista.
     *
     * @param pet Pet a ser adicionado.
     */
    public void adicionarPet(Pet pet) {
        listaDePets.add(pet);
    }

    /**
     * Remove um pet da lista.
     *
     * @param pet Pet a ser removido.
     */
    public void removerPet(Pet pet) {
        listaDePets.remove(pet);
    }
}
