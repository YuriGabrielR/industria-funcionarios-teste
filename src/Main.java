import models.Funcionario;
import services.FuncionarioService;
import utils.FormatadorUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();

        // 3.1 Adiciona os funcionários na lista.
        service.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44) , "Operador"));
        service.adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38) , "Operador"));
        service.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14) , "Coordenador"));
        service.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88) , "Diretor"));
        service.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68) , "Recepcionista"));
        service.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72) , "Operador"));
        service.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84) , "Contador"));
        service.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 07, 8), BigDecimal.valueOf(3017.45) , "Gerente"));
        service.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85) , "Eletricista"));
        service.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 02), BigDecimal.valueOf(2799.93) , "Gerente"));

        //3.2 Remove o João da lista
        service.removerFuncionario("João");

        //3.3 Imprimir todos os funcionários
        service.listarFuncionarios().forEach(System.out::println);

        //3.4 Aumento de salário (10%) + Atualização da lista.
        service.aplicarAumentoSalarial(BigDecimal.valueOf(10));

        //3.5 e 3.6 agrupamento de colaboradores por função
        service.agruparPorFuncao().forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });

        //3.8 listar funcionários que fazem niver mes 10 e 12
        service.filtrarPorMesAniversario(10, 12);

        //3.9 listar funcionario com maior idade + atributos
        Funcionario funcionarioMaisVelho = service.buscarFuncionarioMaisVelho();
        System.out.println("\nFuncionário mais velho: " + funcionarioMaisVelho);


        //3.10 listar funcionarios em ordem alfabética
        service.ordenarFuncionariosPorNome().forEach(System.out::println);

        //3.11 imprimir o total dos salários dos funcionários
        System.out.println("\nTotal de salários: " + FormatadorUtil.formatarSalario(service.calcularTotalSalarios()));

        // 3.12 Quantidade de salários mínimos
        service.calcularSalariosMinimos(BigDecimal.valueOf(1212)).forEach((nome, qtd) ->
                System.out.println(nome + " recebe " + qtd + " salários mínimos."));

    }
}