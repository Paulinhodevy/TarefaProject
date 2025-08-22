package com.Paulo.HenriqueProject.repository;

import com.Paulo.HenriqueProject.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
