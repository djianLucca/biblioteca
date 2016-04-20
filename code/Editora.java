package Atv1;

import java.util.Scanner;

/**
 * Created by Djian on 08/04/2016.
 */
public class Editora {
    private String nome;
    private String endereco;
    private String email;

    Scanner ler = new Scanner(System.in);

    public void lerEditora(){
        System.out.println("Digite o nome da editora: ");
        this.setNome(ler.nextLine());

        System.out.println("Digite o endereço da editora: ");
        this.setEndereco(ler.nextLine());

        System.out.println("Digite o email da editora: ");
        this.setEmail(ler.nextLine());

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = verificaEmail(email);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String verificaEmail(String email){
        boolean x;
        char a;

        do {
            x = true;

            for (int i = 0; i < email.length(); i++){
                a = email.charAt(i);
                int b = a;
                if(b == 64){
                    x = false;
                }
            }
            if(x){
                System.out.println("Email inválido\nInforme um email válido");
                email = ler.nextLine();
            }
        }while(x);
        return email;
    }

    @Override
    public String toString() {
        return "" + nome + "";
    }
}