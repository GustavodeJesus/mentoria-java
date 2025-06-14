package br.com.mentoriajava.database;

import br.com.mentoriajava.formaspagamento.FormaDePagamento;
import javafx.collections.FXCollections;
import br.com.mentoriajava.formaspagamento.TiposDePagamentos;
import javafx.collections.ObservableList;

public class FormaDePagamentoDataSource {

    private static final FormaDePagamentoDataSource instancia = new FormaDePagamentoDataSource();

    private final ObservableList<FormaDePagamento> listaFormaPagamentos = FXCollections.observableArrayList(
            new FormaDePagamento(TiposDePagamentos.CREDITO, 12, "MasterCard"),
            new FormaDePagamento(TiposDePagamentos.DEBITO, 1, "MasterCard"),
            new FormaDePagamento(TiposDePagamentos.CREDITO, 12, "Visa"),
            new FormaDePagamento(TiposDePagamentos.DEBITO, 1, "Visa"),
            new FormaDePagamento(TiposDePagamentos.PIX, 1, "Pix"),
            new FormaDePagamento(TiposDePagamentos.BOLETO, 1, "Boleto")
    );

    private FormaDePagamentoDataSource (){}

    public static FormaDePagamentoDataSource getInstancia() {
        return instancia;
    }

    public ObservableList<FormaDePagamento> getListaFormaPagamentos() {
        return listaFormaPagamentos;
    }
}
