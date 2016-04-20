package Atv1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by Djian on 06/04/2016.
 */
public class Main {
    public static void main(String[] args){
        ArrayList<Livros> l = new ArrayList<>();
        char verificador;
        boolean bool = true;
        boolean teste = true;

        Scanner ler = new Scanner(System.in);

        do {
            int totalDeTitulos = Livros.getTotalDeTitulos();
            int totalDeExemplares = Livros.getTotalDeExemplares();

            System.out.println(totalDeTitulos + " TÍTULOS CADASTRADOS\n" +
                    totalDeExemplares + " EXEMPLARES CADASTRADOS" +
                    "\n\t_________________________" +
                    "\n\t|\t1 - CADASTRAR LIVRO\t|" +
                    "\n\t|\t2 - REMOVER LIVRO\t|" +
                    "\n\t|\t3 - EDITAR LIVRO\t|" +
                    "\n\t|\t4 - PESQUISAR LIVRO\t|" +
                    "\n\t|\t5 - SAIR\t\t\t|" +
                    "\n\t_________________________");
            verificador = ler.next().charAt(0);

            switch (verificador) {
                case '1':
                    Livros a = new Livros();

                    a.cadastraLivros();

                    l.add(a);
                    break;

                case '2':
                    if(l.size() > 0) {
                        for (int i = 0; i < l.size(); i++) {
                            System.out.println(i + " - " + l.get(i).getTitulo() + "\n_________________________________\n");
                        }

                        int cont = 0;

                        do {
                            try {
                                System.out.println("Insira o código do livro a ser deletado:");
                                if (cont != 0) {
                                    ler.next();
                                }
                                int check = ler.nextInt();
                                Livros.setTotalDeTitulos(totalDeTitulos - 1);
                                Livros.setTotalDeExemplares(totalDeExemplares - l.get(check).getNumeroExemplares());
                                l.remove(check);

                                System.out.println("Livro excluído com êxito!");
                                Livros.enterToContinue();

                                teste = false;
                            } catch (Exception e) {
                                System.out.println("Caracter inválido!");
                                teste = true;
                                cont++;
                            }
                        } while (teste);
                    }else{
                        System.out.println("Tente cadastrar algo antes de excluir!");
                        Livros.enterToContinue();
                    }

                    break;

                case '3':
                    if(l.size() > 0) {
                        for (int i = 0; i < l.size(); i++) {
                            System.out.println(i + " - " + l.get(i).getTitulo() + "\n_________________________________\n");
                        }

                        int cont = 0;

                        do {
                            try {
                                System.out.println("Insira o código do livro a ser editado:");
                                if (cont != 0) {
                                    ler.next();
                                }
                                int check = ler.nextInt();
                                Livros.setTotalDeTitulos(totalDeTitulos - 1);
                                Livros.setTotalDeExemplares(totalDeExemplares - l.get(check).getNumeroExemplares());
                                l.remove(check);

                                Livros b = new Livros();

                                b.cadastraLivros();

                                l.add(b);

                                System.out.println("Livro editado com êxito!");
                                Livros.enterToContinue();

                                teste = false;
                            } catch (Exception e) {
                                System.out.println("Caracter inválido!");
                                teste = true;
                                cont++;
                            }
                        } while (teste);
                    }else{
                        System.out.println("Tente cadastrar algo antes de editar!");
                        Livros.enterToContinue();
                    }

                    break;

                case '4':
                    if (l.size() > 0){
                        char variavel;
                        boolean boleano = true;

                        do {
                            System.out.println("\n\tDeseja pesquisar livros pelo:"+
                                    "\n\t_____________________" +
                                    "\n\t|\t1 - TÍTULO\t\t|" +
                                    "\n\t|\t2 - AUTOR\t\t|" +
                                    "\n\t|\t3 - EDITORA\t\t|"+
                                    "\n\t|\t4 - SAIR\t\t|"+
                                    "\n\t_____________________");
                            variavel = ler.next().charAt(0);

                            switch (variavel){
                                case '1':
                                    Livros buscaTitulo = new Livros();
                                    System.out.println("Digite o título do livro a ser procurado: ");
                                    ler.nextLine();
                                    buscaTitulo.setTitulo(ler.nextLine());
                                    for(int j = 0; j < l.size(); j++){
                                        if(buscaTitulo.getTitulo().equals(l.get(j).getTitulo())){
                                            System.out.println(l.get(j).toString());
                                            Livros.enterToContinue();
                                        }else {
                                            System.out.println("Nenhum livro cadastrado com esse título");
                                        }
                                    }
                                    break;

                                case '2':
                                    Livros buscaAutor = new Livros();
                                    Autor autor = new Autor();
                                    System.out.println("Digite o nome do autor do livro a ser procurado: ");
                                    ler.nextLine();
                                    autor.setNome(ler.nextLine());
                                    System.out.println("Digite o sobrenome do autor do livro a ser procurado: ");
                                    autor.setSobrenome(ler.nextLine());
                                    buscaAutor.setAutor(autor);
                                    for(int j = 0; j < l.size(); j++){
                                        if(buscaAutor.getAutor().getNome().equals(l.get(j).getAutor().getNome()) && buscaAutor.getAutor().getSobrenome().equals(l.get(j).getAutor().getSobrenome())){
                                            System.out.println(l.get(j).toString());
                                        }else {
                                            System.out.println("Nenhum livro cadastrado com esse autor");
                                        }
                                    }

                                    Livros.enterToContinue();
                                    break;

                                case '3':
                                    Livros buscaEditora = new Livros();
                                    Editora editora = new Editora();
                                    System.out.println("Digite o nome da editora do livro a ser procurado: ");
                                    ler.nextLine();
                                    editora.setNome(ler.nextLine());
                                    buscaEditora.setEditora(editora);
                                    for(int j = 0; j < l.size(); j++){
                                        if(buscaEditora.getEditora().getNome().equals(l.get(j).getEditora().getNome())){
                                            System.out.println(l.get(j).toString());
                                        }else {
                                            System.out.println("Nenhum livro cadastrado com essa editora");
                                        }
                                    }
                                    Livros.enterToContinue();
                                    break;

                                case '4':
                                    boleano = false;

                                    break;

                                default:

                                    break;
                            }
                        }while (boleano);
                    }else{
                        System.out.println("Tente cadastrar algo antes de procurar!");
                        Livros.enterToContinue();
                    }


                    break;

                case '5':
                    bool = false;

                    break;

                default:
                    System.out.println("Entrada invalida, tente novamente!");
                    Livros.enterToContinue();



                    break;
            }
        }while(bool);

        System.out.println("Sistema finalizado!");
    }
}
