package com.ParkCore.service;

import com.ParkCore.model.Funcionario;

import java.util.List;

public interface FuncionarioServiceInterface {

    Funcionario cadastrarFuncionario(Funcionario funcionario);

    Funcionario atualizarFuncionario(Long id, Funcionario funcionario);

    void removerFuncionario(Long id);

    List<Funcionario> listarFuncionarios();

}
