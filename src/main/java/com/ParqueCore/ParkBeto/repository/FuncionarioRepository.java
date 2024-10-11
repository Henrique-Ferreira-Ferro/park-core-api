package com.ParqueCore.ParkBeto.repository;

import com.ParqueCore.ParkBeto.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByCpf(String cpf);

}
