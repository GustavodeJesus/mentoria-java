package br.com.mentoriajava.database;

import br.com.mentoriajava.base.Endereco;
import br.com.mentoriajava.clientes.StatusCivilEnum;
import br.com.mentoriajava.vendedores.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class VendedorDataSource {

    // singleton
    private static final VendedorDataSource instancia = new VendedorDataSource();

    private final ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList(
            new Vendedor(
                    "11144477735",
                    "Carlos Alberto",
                    new Endereco(
                            "Avenida Semi Simão",
                            "2000",
                            "casa",
                            "Laranjeiras",
                            "Brasil",
                            "Minas Gerais",
                            "Uberlândia",
                            "38412000"),
                    LocalDate.of(2000, 2, 7),
                    "34997564865",
                    "carlinhodev@hotmail.com",
                    StatusCivilEnum.DIVORCIADO,
                    "Vendas",
                    "24240123"),

            new Vendedor(
                    "12345678909",
                    "Félix Noronha",
                    new Endereco(
                            "Avenida das Acacias",
                            "654",
                            "Ap 201 Bloco 2",
                            "Tubalina",
                            "Brasil",
                            "Minas Gerais",
                            "Uberlandia",
                            "38743564"),
                    LocalDate .of(1995, 5, 7),
                    "34985621540",
                    "felixpnoronha@gmail.com",
                    StatusCivilEnum.CASADO,
                    "Vendas",
                    "45870203"),
            new Vendedor(
                    "98765432100",
                    "Ana Clara Mendonça",
                    new Endereco(
                            "Rua Fernando Vilela",
                            "87",
                            "Ap 101",
                            "Centro",
                            "Brasil",
                            "Minas Gerais",
                            "Uberlandia",
                            "38412547"),
                    LocalDate .of(2003, 11, 27),
                    "34997875645",
                    "anacmendo342@outlook.com",
                    StatusCivilEnum.SOLTEIRO,
                    "Vendas",
                    "45127899")
    );

    private VendedorDataSource(){
    }

    public static VendedorDataSource getInstancia(){
        return instancia;
    }

    public ObservableList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }
    public void removerVendedor(Vendedor vendedor){
        listaVendedores.remove(vendedor);
    }
}
