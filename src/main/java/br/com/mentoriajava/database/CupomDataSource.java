package br.com.mentoriajava.database;

import br.com.mentoriajava.cupons.Cupom;
import br.com.mentoriajava.cupons.CuponsEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

    public class CupomDataSource {

        // Instância única
        private static final CupomDataSource instancia = new CupomDataSource();

        // Lista de cupons
        private final ObservableList<Cupom> ListaDeCupons = FXCollections.observableArrayList(
                new Cupom("Cuei24", 24.99, LocalDate.of(2025, 8, 27), 0.15, 1, "Cupom do cuei ", true, CuponsEnum.ANIVERSARIO)
        );

        // Construtor privado para impedir criação externa.
        public CupomDataSource() {
        }

        // retorna a instâcia única da fonte de dados.
        public static CupomDataSource getInstancia() {
            return instancia;
        }

        //retorna a lista observável de cupons (compartilhada).
        public ObservableList<Cupom> getListaDeCupons() {
            return ListaDeCupons;
        }

        //Adiciona um novo cupom à lista.

        public void adicionarCupom(Cupom cupom) {
            ListaDeCupons.add(cupom);
        }
        //Remove um cupom da lista, caso não tiver sido usado
        public void removerCupom(Cupom cupom) {
            if (cupom.getVezesUtilizado() > 0) {
                cupom.setStatus(false); // Marca como inválido
            } else {
                ListaDeCupons.remove(cupom);
            }
        }
}

