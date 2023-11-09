package br.com.alura.fipeApp.principal;

import br.com.alura.fipeApp.model.*;
import br.com.alura.fipeApp.service.ConsumoApi;
import br.com.alura.fipeApp.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private String busca = "";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void iniciarApp() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                ***ESCOLHA UMA OPÇAO***
                Carros
                Caminhoes
                Motos\n
                Digite uma opção:
                """);
        var opcao = input.nextLine().toLowerCase();
        if (opcao.contains("car")) {
            busca = "carros/marcas/";
        } else if (opcao.contains("mot")) {
            busca = "motos/marcas/";
        } else {
            busca = "caminhoes/marcas/";
        }
        String json = consumo.obterDados(ENDERECO + busca);
        System.out.println(busca + " Selecionado" + "\n");

        List<DadosMontadora> dados = conversor.obterLista(json, DadosMontadora.class);

        List<Montadora> listaMarcas = dados.stream()
                .map(Montadora::new)
                .sorted(Comparator.comparing(Montadora::getCodigo))
                .collect(Collectors.toList());

        System.out.println("Lista de marcas\n");
        listaMarcas.forEach(System.out::println);

        while (true) {
            System.out.println("Digite o codigo da montadora que voce deseja pesquisar.");
            var digito = input.nextInt();
            if (listaMarcas.stream().noneMatch(v -> v.getCodigo() == digito)) {
                System.out.println("*** Codigo inexistente na lista! ***\n");
            } else {
                busca += digito + "/modelos/";
                json = consumo.obterDados(ENDERECO + busca);
                break;
            }
        }

        DadosModelos moDados = conversor.obterDados(json, DadosModelos.class);

        List<Montadora> listaModelos = moDados.modelos().stream()
                .map(Montadora::new)
                .sorted(Comparator.comparing(Montadora::getCodigo))
                .collect(Collectors.toList());

        System.out.println("\n*** Lista de modelos da montadora ***");
        listaModelos.stream().forEach(System.out::println);

//        while (true) {
//            System.out.println("Digite o nome do Veiculo para pesquisar o preço.");
//            String nomev = input.next().toLowerCase();
//            if (listaModelos.stream().anyMatch(m -> m.getNome().toLowerCase().contains(nomev))){
//                List<Integer> listaCodigos = listaModelos.stream()
//                        .filter(m -> m.getNome().toLowerCase().contains(nomev))
//                        .map(lm -> lm.getCodigo())
//                        .collect(Collectors.toList());
//
////                System.out.println(jsonJm);
//
//                List<String> listaAnos = listaCodigos.stream()
//                        .map(c -> consumo.obterDados(ENDERECO + busca + c.toString() + "/anos/"))
//                        .peek(System.out::println)
//                        .collect(Collectors.toList());
//
//
//                System.out.println(listaAnos);
//
//                List<DadosMontadora> carrosAgrupados =
//                break;
//            } else {
//                System.out.println("*** Verifique se digitou o nome corretamente ***\n");
//            }
//        }
//
        while (true) {
            System.out.println("Digite o codigo do Veiculo para pesquisar o preço.");
            var digito = input.nextInt();
            if(listaModelos.stream().anyMatch(v -> v.getCodigo() == digito)) {
                busca += digito + "/anos/";
                json = consumo.obterDados(ENDERECO + busca);
                break;
            } else {
                System.out.println("*** Codigo inexistente na lista! ***\n");
            }
        }
        List<DadosMontadora> mDados = conversor.obterLista(json, DadosMontadora.class);
        List<Montadora> listaVeiculos = mDados.stream()
                .map(Montadora::new)
                .collect(Collectors.toList());

        List<DadosVeiculo> dadosVeiculos = new ArrayList<>();
        listaVeiculos.forEach(v -> {
            var jsonVeiculos = consumo.obterDados(ENDERECO + busca + v.getCodigoAno());
            DadosVeiculo vDados = conversor.obterDados(jsonVeiculos, DadosVeiculo.class);
            dadosVeiculos.add(vDados);
        });

        List<Veiculo> veiculos = dadosVeiculos.stream()
                .map(Veiculo::new)
                .sorted(Comparator.comparing(Veiculo::getValor))
                .collect(Collectors.toList());

        veiculos.forEach(System.out::println);
    }
}