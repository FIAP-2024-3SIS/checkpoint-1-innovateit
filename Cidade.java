import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cidade {
    private int id;
    private String nome;
    private String rodoviaria;

    private List<Cidade> listaCidades = new ArrayList<>();

    public Cidade() {
    }

    public Cidade(String nome, String rodoviaria) {
        this.nome = nome;
        this.rodoviaria = rodoviaria;
    }

    public List<Cidade> listarCidades(){

        if(listaCidades.size() > 0) {

            for (Cidade cidade : listaCidades) {
                System.out.println(cidade.toString());
            }
        } else {
           System.out.println("Não existem cidades cadastradas para listar");
        }

        return listaCidades;
    }

    public void cadastrarCidade(String nome, String rodoviaria) throws Exception {
        validaString(nome, "nome", "Cadastrar Cidade");
        validaString(rodoviaria, "rodoviaria", "Cadastrar Cidade");

        Cidade cidade = new Cidade(nome, rodoviaria);

        cidade.setId( listaCidades.size() + 1 );

        listaCidades.add(cidade);
    }

    public void excluirCidade(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id da cidade inválido, certifique-se de que o ID da cidade informado para exclusão seja válido e maior do que zero");
        }

        Iterator iterator = listaCidades.iterator();

        while(iterator.hasNext()){
            Cidade cidade = (Cidade) iterator.next();
            if(cidade.getId() == id){
                iterator.remove();
            }
        }

    }

    public void alterarCidade(Cidade cidade) throws Exception {
        validaString(cidade.getNome(), "nome", "Alterar Cidade");
        validaString(cidade.getRodoviaria(), "rodoviaria", "Alterar Cidade");

        for( Cidade cidadeDaLista : listaCidades ){
            if(cidadeDaLista.getId() == cidade.getId()){
                listaCidades.remove(cidadeDaLista);
                listaCidades.add(cidade);
            }
        }
    }

    private void validaString(String variavel, String nomeVariavel, String nomeAcao) throws Exception{
        if( variavel.isBlank() ){
            throw new Exception("Variavel " + nomeVariavel + " não pode ser nula ou conter apenas espaços. Processo " + nomeAcao + " não pode ser executado.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRodoviaria() {
        return rodoviaria;
    }

    public void setRodoviaria(String rodoviaria) {
        this.rodoviaria = rodoviaria;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }
    
    @Override
    public String toString() {
        return "Index do Objeto na lista = " + String.valueOf(this.id - 1) + "\nId cidade = " + this.id + "\nNome = " + this.nome + "\nRodoviária = " + this.rodoviaria + "\n\n";
    }
}
