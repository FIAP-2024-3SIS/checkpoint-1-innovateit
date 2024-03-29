public class Main {
    public static void main(String[] args) throws Exception {

        Cidade cidade = new Cidade();
        // Cadastrando uma cidade
        cidade.cadastrarCidade("testeCidade", "testeRodoviariaDaCidade");

        //Listando as cidades
        cidade.listarCidades();

        //Pegando a cidade da lista pelo seu index
        Cidade cidadeDaLista = cidade.getListaCidades().get(0);
        
        //Alterando a cidade da lista conforme index
        cidadeDaLista.setNome("NomeAlterado");
        cidade.alterarCidade(cidadeDaLista);

        //Listando as cidades
        cidade.listarCidades();

        //Excluindo a cidade cadastrada
        cidade.excluirCidade( cidadeDaLista.getId() );

        //Listando as cidades
        cidade.listarCidades();

    }
}
