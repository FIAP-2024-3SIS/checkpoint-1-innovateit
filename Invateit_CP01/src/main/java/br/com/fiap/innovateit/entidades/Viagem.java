package br.com.fiap.innovateit.entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Viagem {

	private int id;
	private int qtdParadas;
	private double tempoParada;
	private double distancia;
	private double horaTempoViagem;
	private double minTempoViagem;
	private Cidade origem;
	private Cidade destino;
	private Onibus onibus;
	private List<Viagem> listaViagem = new ArrayList<Viagem>();

	public Viagem() {

	}

	public Viagem(int id, int qtdParadas, double tempoParada, double distancia, Cidade origem, Cidade destino,
			Onibus onibus) {
		super();
		this.id = id;
		this.qtdParadas = qtdParadas;
		this.tempoParada = tempoParada;
		this.distancia = distancia;
		this.origem = origem;
		this.destino = destino;
		this.onibus = onibus;
	}

	public void cadastrarViagem(int qtdParadas, double tempoParada, double distancia, Cidade origem, Cidade destino,
			Onibus onibus) throws Exception {

		validaQtdParadas(qtdParadas, "Cadastrar Viagem");
		validaTempoParada(tempoParada, "Cadastrar Viagem");
		validaDistancia(distancia, "Cadastrar Viagem");
		validaOrigem(origem, "Cadastrar Viagem");
		validaDestino(origem, "Cadastrar Viagem");
		validaOnibus(onibus, "Cadastrar Viagem");

		Viagem viagem = new Viagem(qtdParadas, qtdParadas, tempoParada, distancia, origem, destino, onibus);
		viagem.setId(listaViagem.size() + 1);

		listaViagem.add(viagem);
	}

	public void alterarViagem(Viagem viagem) throws Exception {

		validaQtdParadas(qtdParadas, "Cadastrar Viagem");
		validaTempoParada(tempoParada, "Cadastrar Viagem");
		validaDistancia(distancia, "Cadastrar Viagem");
		validaOrigem(origem, "Cadastrar Viagem");
		validaDestino(origem, "Cadastrar Viagem");
		validaOnibus(onibus, "Cadastrar Viagem");

		for (Viagem viagemDaLista : listaViagem) {
			if (viagemDaLista.getId() == viagem.getId()) {
				listaViagem.remove(viagemDaLista);
				listaViagem.add(viagem);
			}
		}
	}

	public void excluirViagem(int id) throws Exception {

		if (id <= 0) {
			throw new Exception(
					"Id da viagem inválido, certifique-se de que o ID da viagem informado para exclusão seja válido e maior do que zero");
		}

		Iterator<Viagem> iterator = listaViagem.iterator();

		while (iterator.hasNext()) {
			Viagem viagem = (Viagem) iterator.next();
			if (viagem.getId() == id) {
				iterator.remove();
			}
		}
	}

	public List<Viagem> listarViagem() {

		if (!listaViagem.isEmpty()) {
			for (Viagem viagem : listaViagem) {
				System.out.println(viagem.toString());
			}
		} else {
			System.out.println("Não existem viagens cadastradas para listar");
		}

		return listaViagem;
	}

	public void calcularTempo(Viagem viagem) {
		double resultado = viagem.distancia / viagem.getOnibus().getVelociadeMedia();
		horaTempoViagem = (int) resultado;
		double qtdMinutos = resultado - horaTempoViagem;
		minTempoViagem = qtdMinutos * 60;

		viagem.setHoraTempoViagem(horaTempoViagem);
		viagem.setMinTempoViagem(minTempoViagem);
	}

	private void validaQtdParadas(int qtdParadas, String nomeAcao) throws Exception {
		if (qtdParadas < 0) {
			throw new Exception(
					"Quantidade de pargadas não pode ser negativo. Processo " + nomeAcao + " não pode ser executado.");
		}
	}

	private void validaTempoParada(double tempoParada, String nomeAcao) throws Exception {
		if (tempoParada <= 0) {
			throw new Exception("Tempo da parada não pode ser menor ou igual a 0 . Processo " + nomeAcao
					+ " não pode ser executado.");
		}
	}

	private void validaDistancia(double distancia, String nomeAcao) throws Exception {
		if (distancia <= 0) {
			throw new Exception(
					"Distância da viagem não pode ser negativa ou igual a zero. Processo " + nomeAcao + " não pode ser executado.");
		}
	}

	private void validaOrigem(Cidade origem, String nomeAcao) throws Exception {
		if (origem == null || origem.getNome() == null) {
			throw new Exception("A cidade não pode ser nula. Processo " + nomeAcao + " não pode ser executado.");
		}
	}

	private void validaDestino(Cidade destino, String nomeAcao) throws Exception {
		if (destino == null || destino.getNome() == null) {
			throw new Exception("A cidade não pode ser nula. Processo " + nomeAcao + " não pode ser executado.");
		}
	}

	private void validaOnibus(Onibus onibus, String nomeAcao) throws Exception {
		if (onibus == null || onibus.getId() <= 0) {
			throw new Exception("O Onibus não pode ser nulo. Processo " + nomeAcao + " não pode ser executado.");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdParadas() {
		return qtdParadas;
	}

	public void setQtdParadas(int qtdParadas) {
		this.qtdParadas = qtdParadas;
	}

	public double getTempoParada() {
		return tempoParada;
	}

	public void setTempoParada(double tempoParada) {
		this.tempoParada = tempoParada;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getHoraTempoViagem() {
		return horaTempoViagem;
	}

	public void setHoraTempoViagem(double horaTempoViagem) {
		this.horaTempoViagem = horaTempoViagem;
	}

	public double getMinTempoViagem() {
		return minTempoViagem;
	}

	public void setMinTempoViagem(double minTempoViagem) {
		this.minTempoViagem = minTempoViagem;
	}

	public Cidade getOrigem() {
		return origem;
	}

	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}

	public Cidade getDestino() {
		return destino;
	}

	public void setDestino(Cidade destino) {
		this.destino = destino;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public List<Viagem> getListaViagem() {
		return listaViagem;
	}

	@Override
	public String toString() {
		return "Index do Objeto na lista = " + String.valueOf(this.id - 1) + "\nId Viagem = " + this.id + "\nOrigem = "
				+ this.origem.getNome() + "\nDestino= " + this.destino.getNome() + "\nTempo = " + this.horaTempoViagem
				+ "h" + this.minTempoViagem + "min" + "\nQuantidade de paradas = " + this.qtdParadas
				+ "\nTempo de cada parada (em min) = " + this.tempoParada + "\nDistância em KM = " + this.distancia
				+ "\n\n";
	}
}
