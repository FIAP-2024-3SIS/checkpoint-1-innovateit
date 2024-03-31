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
		double tempoParada=0;

		int opcao;
		do {
			System.out.println("");
			System.out.println(" - - - - Escolha uma opção - - - -  ");
			System.out.println("1. Cadastrar Ônibus");
			System.out.println("2. Excluir Ônibus");
			System.out.println("3. Alterar Ônibus");
			System.out.println("4. Listar Ônibus");
			System.out.println("5. Cadastrar Viagem");
			System.out.println("6. Excluir Viagem");
			System.out.println("7. Alterar Viagem");
			System.out.println("8. Listar Viagem");
			System.out.println("9. Cadastrar Cidade");
			System.out.println("10. Excluir Cidade");
			System.out.println("11. Alterar Cidade");
			System.out.println("12. Listar Cidade ");
			System.out.println("13. Sair");
			System.out.println(" - - - - - - - - - - - - - - - - -  \n");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:

				try {
					System.out.print("Informe a quantidade de assentos: ");
					int qtdAssentos = scanner.nextInt();
					System.out.print("Informe a velocidade média: ");
					double velocidadeMedia = scanner.nextDouble();
					onibus.cadastrarOnibus(qtdAssentos, velocidadeMedia);
					System.out.println("Ônibus cadastrado com sucesso!\n");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar ônibus! Tente novamente." + e.getMessage());
				}

				break;
			case 2:
				try {
					System.out.print("Informe o ID do ônibus a ser excluído: ");
					int idOnibus = scanner.nextInt();
					onibus.excluirOnibus(idOnibus);
					System.out.println("Ônibus excluído com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao excluir ônibus! Tente novamente." + e.getMessage());
				}
				break;
				
			case 3:
				try {
					System.out.print("Informe o ID do ônibus a ser alterado: ");
					int idOnibusAlterar = scanner.nextInt();
					System.out.print("Informe a nova quantidade de assentos: ");
					int novaQtdAssentos = scanner.nextInt();
					System.out.print("Informe a nova velocidade média: ");
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
					System.out.println("- -Lista de Onibus Cadastrados- -");
					for (Onibus o : onibus.getListaOnibus()) {
						System.out.println(o);
					}
				
				break;
			
			case 5:
				try {
					System.out.print("Informe a quantidade de paradas: ");
					int qtdParadas = scanner.nextInt();
					
					if (qtdParadas > 0) {
						System.out.print("Informe o tempo de cada parada (em minutos): ");
						tempoParada = scanner.nextDouble();
					}
					
					System.out.print("Informe a distância da viagem (em km): ");
					double distancia = scanner.nextDouble();
					System.out.print("Informe o ID da cidade de origem: ");
					int idOrigem = scanner.nextInt();
					System.out.print("Informe o ID da cidade de destino: ");
					int idDestino = scanner.nextInt();
					System.out.print("Informe o ID do ônibus: ");
					int idOnibusViagem = scanner.nextInt();
					Cidade origem = cidade.getListaCidades().get(idOrigem-1);
					Cidade destino = cidade.getListaCidades().get(idDestino-1);
					Onibus onibusViagem = onibus.getListaOnibus().get(idOnibusViagem-1);
					viagem.cadastrarViagem(qtdParadas, tempoParada, distancia, origem, destino, onibusViagem);
					System.out.println("Viagem cadastrada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar viagem! Tente novamente." + e.getMessage());
				}
				break;
				
			case 6:
				try {
					System.out.print("Informe o ID da viagem a ser excluída: ");
					int idViagem = scanner.nextInt();
					viagem.excluirViagem(idViagem);
					System.out.print("Viagem excluída com sucesso!");
				} catch (Exception e) {
					System.out.print("Erro ao excluir viagem! Tente novamente." + e.getMessage());
				}
				break;
				
			case 7:
				try {
					System.out.print("Informe o ID da viagem a ser alterada: ");
					int idViagemAlterar = scanner.nextInt();
					System.out.print("Informe a nova quantidade de paradas: ");
					int novaQtdParadas = scanner.nextInt();
					System.out.print("Informe o novo tempo de cada parada (em minutos): ");
					double novoTempoParada = scanner.nextDouble();
					System.out.print("Informe a nova distância da viagem (em km): ");
					double novaDistancia = scanner.nextDouble();
					System.out.print("Informe o novo ID da cidade de origem: ");
					int novoIdOrigem = scanner.nextInt();
					System.out.print("Informe o novo ID da cidade de destino: ");
					int novoIdDestino = scanner.nextInt();
					System.out.print("Informe o novo ID do ônibus: ");
					int novoIdOnibusViagem = scanner.nextInt();
					Cidade novaOrigem = cidade.getListaCidades().get(novoIdOrigem);
					Cidade novoDestino = cidade.getListaCidades().get(novoIdDestino);
					Onibus novoOnibusViagem = onibus.getListaOnibus().get(novoIdOnibusViagem);
					viagem.alterarViagem(new Viagem(idViagemAlterar, novaQtdParadas, novoTempoParada, novaDistancia,
							novaOrigem, novoDestino, novoOnibusViagem));
					System.out.print("Viagem alterada com sucesso!");
				} catch (Exception e) {
					System.out.print("Erro ao alterar viagem! Tente novamente." + e.getMessage());
				}
				break;
				
			case 8:
				
				System.out.println("- -Lista de Viagens Cadastradas- -");
				for (Viagem v : viagem.getListaViagem()) {
					System.out.println(v);
				}
				
			case 9:
				
				try {
					System.out.print("Informe o nome da cidade: ");
					scanner.nextLine();
					String nomeCidade= scanner.nextLine();
					System.out.print("Informe a rodoviaria da cidade: ");
					String rodoviaria = scanner.nextLine();
					System.out.print("Informe o estado que a cidade pertence: ");
					String estado = scanner.nextLine();
					
					cidade.cadastrarCidade(nomeCidade, rodoviaria, estado);
					System.out.println("Cidade cadastrada com sucesso!\n");
				} catch (Exception e) {
					System.out.println("Erro ao cadastrar cidade! Tente novamente." + e.getMessage());
				}
				
				break;
				
			case 10:
				try {
					System.out.print("Informe o ID da cidade a ser excluída: ");
					int idCidade = scanner.nextInt();
					cidade.excluirCidade(idCidade);
					System.out.print("Cidade excluída com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao excluir cidade! Tente novamente." + e.getMessage());
				}
				break;
				
			case 11:
				try {
					System.out.print("Informe o ID da cidade a ser alterada: ");
					int idCidadeAlterar = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Informe o novo nome da cidade: ");
					String novoNomeCidade = scanner.nextLine();
					System.out.print("Informe a nova rodoviária: ");
					String novaRodoviaria = scanner.nextLine();
					System.out.print("Informe o novo Estado da cidade: ");
					String novoEstado = scanner.nextLine();
					Cidade cidadeNova = new Cidade(novoNomeCidade, novaRodoviaria, novoEstado);
					cidadeNova.setId(idCidadeAlterar);
					cidade.alterarCidade(cidadeNova);
					
					
					System.out.println("Cidade alterada com sucesso!");
				} catch (Exception e) {
					System.out.println("Erro ao alterar cidade! Tente novamente." + e.getMessage());
				}
				break;
				
			case 12:
				System.out.println("- -Lista de Cidades Cadastradas- -");
				for (Cidade c : cidade.getListaCidades()){
					System.out.println(c);
				}
				break;
			case 13:
				System.out.println("Você está saindo... Obrigada por utilizar nossos serviços! Até breve :)");
				break;
			default:
				System.out.println("Opção inválida, digite novamente: ");
				break;
			}
		} while (opcao != 13);
		scanner.close();
	}

}
