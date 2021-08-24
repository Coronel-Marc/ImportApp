package ImportApp;
import java.util.ArrayList;
import java.util.Scanner;


/*
* Necessário implentação de um método ou recursos para limpar a tela sempre que atualizar
*
* */
public class Principal {

    private final Produto[] produtosList = new Produto[10];
    protected int atualPosicao = 0;



    public static void main(String[] args){
        Principal app = new Principal();
        titulo();
        app.menuPrincipal();

    }


    private void menuPrincipal(){
        int opcaoUsuario = 0;

        do{
            opcaoUsuario = opcaoMenu();
            switch (opcaoUsuario) {
                case 1:
                    menuCadastroProduto();
                    break;

                case 2:
                    menuMovimentacao();
                    break;

                case 3:
                    menuReajustePreco();
                    break;

                case 4:
                    relatorios();
                    break;

                case 0:
//                    finalizar();
                    System.out.println("Finalizando o programa. Até a proxima.");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
            //Finaliza o Scanner
        } while (opcaoUsuario != 0);




    }


    //INICIO METODO PARA APRESENTAR MENU ----------------------
    private static void titulo(){
        System.out.println("IMPORTAPP SOLUTIONS LTDA\nSISTEMA DE CONTROLE DE ESTOQUE\nOPÇÃO: ");
    }
    private int opcaoMenu() {
        int opcao;
        System.out.println("MENU PRINCIPAL\n" +
                "1 - CADASTRO DE PRODUTOS\n" +
                "2 - MOVIMENTAÇÃO\n" +
                "3 - REAJUSTE DE PREÇO\n" +
                "4 - RELATÓRIOS\n" +
                "0 - FINALIZAR\n" +
                "OPÇÃO  :");
        opcao = getEscolhaMenu();
        return opcao;
    }
    private int getEscolhaMenu() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }
    //FIM METODO PARA APRESENTAR MENU

    //----------------------

    //INICIO METODOS DO MENU PRINCIPAL

    private void relatorios(){
        titulo();
        System.out.println("RELATÓRIO");

        for (int i = 0; i < atualPosicao; i++){
            System.out.println("\n//---------------------//: \n" +
                    "CÓDIGO: " + i + "\n" +
                    produtosList[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("APERTE QUALQUER LETRA + ENTER PARA CONTINUAR");
        scanner.next();

    }

    private void menuCadastroProduto(){
        int opcao;
        System.out.println("" +
                "1 - INCLUSÃO\n" +
                "2 - ALTERAÇÃO\n" +
                "3 - CONSULTA\n" +
                "4 - EXCLUSÃO\n" +
                "0 - RETORNAR\n");
        opcao = getEscolhaMenu();

        switch (opcao) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                consultarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            default:
                System.out.println("//--------------------------------//\nRetornando ao menu");
                break;
        }
    }

    private void menuMovimentacao(){
        System.out.println("teste2");

    }

    private void menuReajustePreco(){
        System.out.println("teste3");

    }
    //FIM METODOS DO MENU PRINCIPAL

    //--------------------------

    //INICIO METODOS MENU DE CADASTRO
    private void cadastrarProduto(){
        String escolha = "";
        do{
            titulo();
            System.out.println("CADASTRAR PRODUTO");
            Produto produto = setDadosProduto();
            escolha = confirmaOperacao();
            if(escolha.equalsIgnoreCase("S")){
                produtosList[atualPosicao] = produto;
                atualPosicao++;
            }
            escolha = getRepetirOperacao();

        }while (escolha.equalsIgnoreCase("S"));
    }

    private void alterarProduto(){
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            titulo();
            System.out.println("ALTERAÇÃO DE PRODUTO");
            System.out.println("INFORME O NOME DO PRODUTO: ");
            String nomeConsulta = scanner.nextLine();
            boolean controle = true;

            for (int i = 0; i < atualPosicao; i++){

                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome())){
                    controle = false;
                    System.out.println("PRODUTO ENCONTRADO\n");
                    Produto produto = setDadosProduto();
                    escolha = confirmaOperacao();

                    if (escolha.equalsIgnoreCase("S")){
                        produtosList[i] = produto;
                    }
                    break;
                }
            }
            mensagemConsultaInvalida(controle);
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }

    private void mensagemConsultaInvalida(boolean controle){
        if (controle){
            System.out.println("PRODUTO NÃO ENCONTRADO");
        }
    }

    private void consultarProduto(){
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            titulo();
            System.out.println("CONSULTA DE PRODUTO");
            System.out.println("INFORME O NOME DO PRODUTO A SER PESQUISADO: ");
            String nomeConsulta = scanner.nextLine();

            boolean controle = true;

            for (int i = 0; i < atualPosicao; i++){
                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome())){
                    controle = false;
                    System.out.println(produtosList[i].toString());
                    break;
                }
            }
            mensagemConsultaInvalida(controle);
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }

    private void excluirProduto(){
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            titulo();
            System.out.println("EXCLUSÃO DE PRODUTO");
            System.out.println("INFOME O NOME DO PRODUTO PARA PESQUISA: ");
            String nomeConsulta = scanner.nextLine();

            boolean controle = true;
            ArrayList<Produto> arrayList = new ArrayList<>();
            arrayList.add(new Produto());
            for (int i = 0; i < atualPosicao; i++){
                scanner = new Scanner(System.in);
                Produto produto = arrayList.get(i);

                if (nomeConsulta.equalsIgnoreCase(produtosList[i].getNome())){
                    controle = false;
                    System.out.println(produtosList[i].toString());
                    System.out.println("CONFIRMA EXCLUSÃO? (S/N): ");
                    escolha = scanner.next();

                    if (escolha.equalsIgnoreCase("S")){
                        for (int k = i; k < atualPosicao - 1; k++){
                            produtosList[k] = produtosList[k + 1];
                            atualPosicao--;
                        }
                    }
                    break;

                }
            }
            mensagemConsultaInvalida(controle);
            escolha = getRepetirOperacao();
        } while (escolha.equalsIgnoreCase("S"));
    }



    //------------------------------------------------------

    //FIM METODOS MENU DE CADASTRO

    //------------------------------------------------------

    //Confirmação de operação

    private String confirmaOperacao(){
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("CONFIRMA OPERAÇÃO? (S/N): ");
        escolha =  scanner.next();
        return escolha;
    }

    private String getRepetirOperacao(){
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("REPETIR OPERAÇÃO? (S/N): ");
        escolha = scanner.next();
        return escolha;
    }

    //Fim confirmação de operação

    //------------------------------------------------------
    private Produto setDadosProduto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Insira o preço unitário do produto: ");
        float precoUnitario = scanner.nextInt();

        System.out.println("Insira a quantidade de unidades a serem adicionadas: ");
        int unidade = scanner.nextInt();

        int id = atualPosicao;

        Produto produto = new Produto(nome, precoUnitario, unidade,id);

        produto.setNome(nome);
        produto.setPrecoUnitario(precoUnitario);
        produto.setUnidade(unidade);
        produto.setId(id);
        return produto;


    }
}





