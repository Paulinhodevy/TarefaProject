package service;

import com.Paulo.HenriqueProject.dto.TarefaDTO;
import com.Paulo.HenriqueProject.model.Tarefa;
import org.springframework.stereotype.Service;
import com.Paulo.HenriqueProject.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa salvar(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto.getTitulo(), dto.getDescricao());
        return repository.save(tarefa);
    }

    public Tarefa concluir(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.concluir(); //polimorfismo: ação depende do estado da tarefa
        return repository.save(tarefa);
    }
}

