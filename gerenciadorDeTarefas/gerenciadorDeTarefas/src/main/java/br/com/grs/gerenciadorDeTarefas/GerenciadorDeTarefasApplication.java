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
		.nome("Criar App")
		.descricao("Criar um aplicativo de gerenciar tarefas")
		.status(StatusTarefa.CONCLUIDA)
		.data(LocalDate.of(2023, 6, 9))
		.build();

		var t2 = Tarefa.builder()
		.nome("Estudar")
		.descricao("Estudar novas linguagens de programação")
		.status(StatusTarefa.EmPROGRESSO)
		.data(LocalDate.of(2020, 2, 1))
		.build();

		var t3 = Tarefa.builder()
		.nome("Aprender um novo idioma")
		.descricao("Estudar e praticar um novo idioma")
		.status(StatusTarefa.PENDENTE)
		.data(LocalDate.of(1995, 1, 12))
		.build();


		tarefaRepository.saveAll(List.of(t1,t2,t3));
		

	}

}
