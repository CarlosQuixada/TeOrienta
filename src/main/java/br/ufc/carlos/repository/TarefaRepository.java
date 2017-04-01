package br.ufc.carlos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.carlos.model.Tarefa;

@Repository
@Transactional
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
