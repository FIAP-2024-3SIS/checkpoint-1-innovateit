import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Onibus {

    private int id;
    private int qtdAssentos;
    private double velociadeMedia;
    private List<Onibus> listaOnibus = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Onibus() {
    }

    public Onibus(int qtdAssentos, double velociadeMedia) {
        this.qtdAssentos = qtdAssentos;
        this.velociadeMedia = velociadeMedia;
    }

    public List<Onibus> listarOnibus(){

        if( !listaOnibus.isEmpty() ) {
            for (Onibus onibus : listaOnibus) {
                System.out.println(onibus.toString());
            }
        } else {
            System.out.println("Não existem ônibus cadastrados para listar");
        }

        return listaOnibus;
    }

    public void cadastrarOnibus(int qtdAssentos, double velociadeMedia) throws Exception {
        validaQtdAssentos(qtdAssentos, "Cadastrar Ônibus");
        validaVelocidadeMedia(velociadeMedia, "Cadastrar Ônibus");


        Onibus onibus = new Onibus(qtdAssentos, velociadeMedia);
        //Criando o ID com size da lista + 1
        onibus.setId( listaOnibus.size() + 1 );

        listaOnibus.add(onibus);
    }

    public void excluirOnibus(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Id do ônibus inválido, certifique-se de que o ID do ônibus informado para exclusão seja válido e maior do que zero");
        }

        Iterator iterator = listaOnibus.iterator();

        while(iterator.hasNext()){
            Onibus onibus = (Onibus) iterator.next();
            if(onibus.getId() == id){
                iterator.remove();
            }
        }

    }

    public void alterarOnibus(Onibus onibus) throws Exception {
        validaQtdAssentos(qtdAssentos, "Alterar Ônibus");
        validaVelocidadeMedia(velociadeMedia, "Alterar Ônibus");

        for( Onibus onibusDaLista : listaOnibus ){
            if( onibusDaLista.getId() == onibus.getId() ){
                listaOnibus.remove(onibusDaLista);
                listaOnibus.add(onibus);
            }
        }
    }

    public void inicializaOnibus(){
        Onibus Onibus01 = new Onibus(30, 50);
        listaOnibus.add(Onibus01);
        Onibus Onibus02 = new Onibus(30, 100);
        listaOnibus.add(Onibus02);
        Onibus Onibus03 = new Onibus(30, 120);
        listaOnibus.add(Onibus03);
        Onibus Onibus04 = new Onibus(30, 90);
        listaOnibus.add(Onibus04);
        Onibus Onibus05 = new Onibus(30, 60);
        listaOnibus.add(Onibus05);
        Onibus Onibus06 = new Onibus(30, 110);
        listaOnibus.add(Onibus06);
        Onibus Onibus07 = new Onibus(18, 120);
        listaOnibus.add(Onibus07);
        Onibus Onibus08 = new Onibus(15, 60);
        listaOnibus.add(Onibus08);
        Onibus Onibus09 = new Onibus(28, 95);
        listaOnibus.add(Onibus09);
        Onibus Onibus10 = new Onibus(25, 80);
        listaOnibus.add(Onibus10);
    }
    
    private void validaQtdAssentos(int qtdAssentos, String nomeAcao) throws Exception{
        if( qtdAssentos <= 0  ){
            throw new Exception("Quantidade de assentos não pode ser menor ou igual a 0. Processo " + nomeAcao + " não pode ser executado.");
        }
    }

    private void validaVelocidadeMedia(double velocidadeMedia, String nomeAcao) throws Exception{
        if( velocidadeMedia <= 0  ){
            throw new Exception("Velocidade média não pode ser igual ou menor do que zero. Processo " + nomeAcao + " não pode ser executado.");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }

    public double getVelociadeMedia() {
        return velociadeMedia;
    }

    public void setVelociadeMedia(double velociadeMedia) {
        this.velociadeMedia = velociadeMedia;
    }

    public List<Onibus> getListaOnibus() {
        return listaOnibus;
    }

    @Override
    public String toString() {
        return "Index do Objeto na lista = " + String.valueOf(this.id - 1) + "\nId Ônibus = " + this.id + "\nQuantidade de assentos = " + this.qtdAssentos + "\nVelocidade média = " + this.velociadeMedia + "\n\n";
    }
}
