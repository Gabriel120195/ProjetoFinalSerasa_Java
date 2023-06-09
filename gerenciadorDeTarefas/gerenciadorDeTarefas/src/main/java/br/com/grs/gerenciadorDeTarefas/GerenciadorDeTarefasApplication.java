package br.com.grs.gerenciadorDeTarefas;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.grs.gerenciadorDeTarefas.model.entity.Tarefa;
import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import br.com.grs.gerenciadorDeTarefas.repository.TarefaRepository;

@SpringBootApplication
public class GerenciadorDeTarefasApplication implements CommandLineRunner{

	@Autowired
	private TarefaRepository tarefaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeTarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var t1 = Tarefa.builder()
		.nome("Festa")
		.descricao("Uma grande festa")
		.status(StatusTarefa.EmPROGRESSO)
		.data(LocalDate.now())
		.build();

		var t2 = Tarefa.builder()
		.nome("Casamento")
		.descricao("Um grande casamento")
		.status(StatusTarefa.CONCLUIDA)
		.data(LocalDate.now())
		.build();

		var t3 = Tarefa.builder()
		.nome("Jogo de futebol")
		.descricao("Um grande Jogo")
		.status(StatusTarefa.PENDENTE)
		.data(LocalDate.now())
		.build();


		tarefaRepository.saveAll(List.of(t1,t2,t3));
		

	}

}
