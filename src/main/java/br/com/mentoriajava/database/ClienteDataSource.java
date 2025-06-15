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
            new Cliente("28011968270",
                    "Carla Maitê Carvalho",
                    new Endereco("Rua H",
                            "852",
                            "NA",
                            "Zona de Expansão (Mosqueiro)",
                            "Brasil",
                            "SE",
                            "Aracaju",
                            "49008435"),
                    LocalDate.of(2000, 4, 20),
                    "79992585548",
                    "carlamaitecarvalho@nokia.com",
                    StatusCivilEnum.SOLTEIRO),
            new Cliente("12345678901",
                    "João Pedro Lima",
                    new Endereco("Rua das Flores",
                            "123",
                            "Apt 202",
                            "Centro",
                            "Brasil",
                            "SP",
                            "São Paulo",
                            "01001000"),
                    LocalDate.of(1995, 8, 15),
                    "11987654321",
                    "joaopedrolima@gmail.com",
                    StatusCivilEnum.CASADO),
            new Cliente("98765432100",
                    "Ana Luísa Gomes",
                    new Endereco("Av. Brasil",
                            "456",
                            "Bloco B",
                            "Copacabana",
                            "Brasil",
                            "RJ",
                            "Rio de Janeiro",
                            "22041001"),
                    LocalDate.of(1992, 12, 5),
                    "21998877665",
                    "ana.gomes@yahoo.com",
                    StatusCivilEnum.SOLTEIRO),
            new Cliente("45612378909",
                    "Fernando Henrique Souza",
                    new Endereco("Rua da Paz",
                            "789", "NA",
                            "Liberdade",
                            "Brasil",
                            "BA",
                            "Salvador",
                            "40000123"),
                    LocalDate.of(1988, 3, 22),
                    "71988776655",
                    "fernandohs@outlook.com",
                    StatusCivilEnum.DIVORCIADO),
            new Cliente("32165498700",
                    "Beatriz Cristina Silva",
                    new Endereco("Rua das Acácias",
                            "321",
                            "Casa 4",
                            "Jardins",
                            "Brasil",
                            "MG",
                            "Belo Horizonte",
                            "30140071"),
                    LocalDate.of(1999, 11, 11),
                    "31993445566",
                    "beatrizcsilva@icloud.com",
                    StatusCivilEnum.SOLTEIRO),
            new Cliente("14725836901",
                    "Lucas Gabriel Fernandes",
                    new Endereco("Av. das Américas",
                            "987",
                            "NA",
                            "Barra da Tijuca",
                            "Brasil",
                            "RJ",
                            "Rio de Janeiro",
                            "22640001"),
                    LocalDate.of(1990, 7, 7),
                    "21991234567",
                    "lucasgfernandes@gmail.com",
                    StatusCivilEnum.CASADO)
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
