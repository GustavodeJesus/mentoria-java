package br.com.mentoriajava.database;

import br.com.mentoriajava.base.Endereco;
import br.com.mentoriajava.clientes.Cliente;
import br.com.mentoriajava.clientes.StatusCivilEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ClienteDataSource {

    private static final ClienteDataSource instancia = new ClienteDataSource();

    private final ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList(
            new Cliente("01970989670",
                    "Natalia Amaraes",
                    new Endereco("Av Dr Misael Castro", "3292", "NA", "Segismundo Pereira", "Brasil", "MG", "Uberlandia", "38408277"),
                    LocalDate.of(2000,4,20),
                    "34992787342",
                    "nataliaafborges@hotmail.com",
                    StatusCivilEnum.SOLTEIRO,
                    0),
            new Cliente("11897623666",
                    "Henrique Coelho",
                    new Endereco("Rua Tailandia", "152", "Casa", "Laranjeiras", "Brasil", "MG", "Uberlândia", "38410246"),
                    LocalDate.of(2000,8,7),
                    "3491494589",
                    "henriqueMaus0803@hotmail.com",
                    StatusCivilEnum.SOLTEIRO,
                    0),
            new Cliente("88104443615",
                    "Renata Borges",
                    new Endereco("Rua Serra Negra", "346", "Bloco C Apto 1101", "Jardim das Palmeiras", "Brasil", "MG", "Estrela do Sul", "55078962"),
                    LocalDate.of(1974, 4, 3),
                    "34988437869",
                    "renatafborges@hotmail.com",
                    StatusCivilEnum.CASADO,
                    0)
    );

    public static ClienteDataSource getInstancia(){
        return instancia;
    }

    public ObservableList<Cliente> getListaDeClientes(){
        return listaDeClientes;
    }

    public void adiconarCliente(Cliente cliente){
        listaDeClientes.add(cliente);
    }

    public void removerCliente (Cliente cliente){
        listaDeClientes.remove(cliente);
    }
}
