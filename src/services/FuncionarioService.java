package services;

import models.Funcionario;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {
    private final Map<String, Funcionario> funcionarios = new HashMap<>();


    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getNome(), funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.remove(nome);
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios.values());
    }

    public void aplicarAumentoSalarial(BigDecimal percentual) {
        funcionarios.values().forEach(func -> {
            BigDecimal novoSalario = func.getSalario().multiply(BigDecimal.ONE.add(percentual.divide(BigDecimal.valueOf(100))));
            func.setSalario(novoSalario);
        });
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.values().stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> filtrarPorMesAniversario(int... meses) {
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        return funcionarios.values().stream()
                .filter(func -> mesesSet.contains(func.getDataNascimento().getMonthValue()))
                .collect(Collectors.toList());
    }

    public Funcionario buscarFuncionarioMaisVelho() {
        return funcionarios.values().stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    public BigDecimal calcularTotalSalarios() {
        return funcionarios.values().stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Funcionario> ordenarFuncionariosPorNome() {
        return funcionarios.values().stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public Map<String, BigDecimal> calcularSalariosMinimos(BigDecimal salarioMinimo) {
        return funcionarios.values().stream()
                .collect(Collectors
                        .toMap(Funcionario::getNome, func -> func.getSalario()
                                .divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP)));
    }
}
