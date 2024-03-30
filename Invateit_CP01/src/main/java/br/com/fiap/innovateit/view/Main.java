package br.com.fiap.innovateit.view;

import java.util.Scanner;

import br.com.fiap.innovateit.entidades.Cidade;
import br.com.fiap.innovateit.entidades.Onibus;
import br.com.fiap.innovateit.entidades.Viagem;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Onibus onibus = new Onibus();
		Viagem viagem = new Viagem();
		Cidade cidade = new Cidade();

		int opcao;
		do {
			System.out.println("");
			System.out.println(" - - - - Escolha uma opção - - - -  ");
			System.out.println("1. Cadastrar Ônibus");
			System.out.println("2. Excluir Ônibus");
			System.out.println("3. Alterar Ônibus");
			System.out.println("4. Cadastrar Viagem");
			System.out.println("5. Excluir Viagem");
			System.out.println("6. Alterar Viagem");
			System.out.println("7. Cadastrar Cidade");
			System.out.println("8. Excluir Cidade");
			System.out.println("9. Alterar Cidade");
			System.out.println("10. Listar Viagem");
			System.out.println("11. Sair");
			System.out.println(" - - - - - - - - - - - - - - - - -  ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:

				try {
					System.out.println("Informe a quantidade de assentos:");
					int qtdAssentos = scanner.nextInt();
					System.out.println("Informe a velocidade média:");
					double velocidadeMedia = scanner.nextDouble();
					onibus.cadastrarOnibus(qtdAssentos, velocidadeMedia);
					System.out.println("Ônibus cadastrado com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar ônibus! Tente novamente." + e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.println("Informe o ID do ônibus a ser excluído: ");
					int idOnibus = scanner.nextInt();
					onibus.excluirOnibus(idOnibus);
					System.out.println("Ônibus excluído com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao excluir ônibus! Tente novamente." + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Informe o ID do ônibus a ser alterado: ");
					int idOnibusAlterar = scanner.nextInt();
					System.out.println("Informe a nova quantidade de assentos: ");
					int novaQtdAssentos = scanner.nextInt();
					System.out.println("Informe a nova velocidade média: ");
					double novaVelocidadeMedia = scanner.nextDouble();
					Onibus novoOnibus = new Onibus(novaQtdAssentos, novaVelocidadeMedia);
					novoOnibus.setId(idOnibusAlterar);
					onibus.alterarOnibus(novoOnibus);
					System.out.println("Ônibus alterado com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao alterar ônibus! Tente novamente." + e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Informe a quantidade de paradas: ");
					int qtdParadas = scanner.nextInt();
					System.out.println("Informe o tempo de cada parada (em minutos): ");
					double tempoParada = scanner.nextDouble();
					System.out.println("Informe a distância da viagem (em km): ");
					double distancia = scanner.nextDouble();
					System.out.println("Informe o ID da cidade de origem: ");
					int idOrigem = scanner.nextInt();
					System.out.println("Informe o ID da cidade de destino: ");
					int idDestino = scanner.nextInt();
					System.out.println("Informe o ID do ônibus: ");
					int idOnibusViagem = scanner.nextInt();
					Cidade origem = cidade.getListaCidades().get(idOrigem);
					Cidade destino = cidade.getListaCidades().get(idDestino);
					Onibus onibusViagem = onibus.getListaOnibus().get(idOnibusViagem);
					viagem.cadastrarViagem(qtdParadas, tempoParada, distancia, origem, destino, onibusViagem);
					System.out.println("Viagem cadastrada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar viagem! Tente novamente." + e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Informe o ID da viagem a ser excluída: ");
					int idViagem = scanner.nextInt();
					viagem.excluirViagem(idViagem);
					System.out.println("Viagem excluída com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao excluir viagem! Tente novamente." + e.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println("Informe o ID da viagem a ser alterada: ");
					int idViagemAlterar = scanner.nextInt();
					System.out.println("Informe a nova quantidade de paradas: ");
					int novaQtdParadas = scanner.nextInt();
					System.out.println("Informe o novo tempo de cada parada (em minutos): ");
					double novoTempoParada = scanner.nextDouble();
					System.out.println("Informe a nova distância da viagem (em km): ");
					double novaDistancia = scanner.nextDouble();
					System.out.println("Informe o novo ID da cidade de origem: ");
					int novoIdOrigem = scanner.nextInt();
					System.out.println("Informe o novo ID da cidade de destino: ");
					int novoIdDestino = scanner.nextInt();
					System.out.println("Informe o novo ID do ônibus: ");
					int novoIdOnibusViagem = scanner.nextInt();
					Cidade novaOrigem = cidade.getListaCidades().get(novoIdOrigem);
					Cidade novoDestino = cidade.getListaCidades().get(novoIdDestino);
					Onibus novoOnibusViagem = onibus.getListaOnibus().get(novoIdOnibusViagem);
					viagem.alterarViagem(new Viagem(idViagemAlterar, novaQtdParadas, novoTempoParada, novaDistancia,
							novaOrigem, novoDestino, novoOnibusViagem));
					System.out.println("Viagem alterada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao alterar viagem! Tente novamente." + e.getMessage());
				}
				break;
			case 7:
				try {
					System.out.println("Informe o nome da cidade: ");
					String nomeCidade = scanner.next();
					System.out.println("Informe o nome da rodoviária: ");
					String rodoviaria = scanner.next();
					System.out.println("Informe o Estado da cidade: ");
					String estado = scanner.next();
					cidade.cadastrarCidade(nomeCidade, rodoviaria, estado);
					System.out.println("Cidade cadastrada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar cidade! Tente novamente." + e.getMessage());
				}
				break;
			case 8:
				try {
					System.out.println("Informe o ID da cidade a ser excluída: ");
					int idCidade = scanner.nextInt();
					cidade.excluirCidade(idCidade);
					System.out.println("Cidade excluída com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao excluir cidade! Tente novamente." + e.getMessage());
				}
				break;
			case 9:
				try {
					System.out.println("Informe o ID da cidade a ser alterada: ");
					int idCidadeAlterar = scanner.nextInt();
					System.out.println("Informe o novo nome da cidade: ");
					String novoNomeCidade = scanner.next();
					System.out.println("Informe a nova rodoviária: ");
					String novaRodoviaria = scanner.next();
					System.out.println("Informe o novo Estado da cidade: ");
					String novoEstado = scanner.next();
					Cidade idAlterar = cidade.getListaCidades().get(idCidadeAlterar);
					cidade.alterarCidade(new Cidade(novoNomeCidade, novaRodoviaria, novoEstado));
					
					
					System.out.println("Cidade alterada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao alterar cidade! Tente novamente." + e.getMessage());
				}
				break;
			case 10:
				System.out.println("- -Lista de Viagens Cadastradas- -");
				for (Viagem v : viagem.getListaViagem()) {
					System.out.println(v);
				}
				break;
			case 11:
				System.out.println("Você está saindo... Obrigada por utilizar nossos serviços! Até breve :)");
				break;
			default:
				System.out.println("Opção inválida, digite novamente: ");
				break;
			}
		} while (opcao != 11);
		scanner.close();
	}

}
