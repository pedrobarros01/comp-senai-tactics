package CSTgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ManipuladorDeArquivo {
    public static List<itemConsumivel> leitorConsumivel(String nome, List<itemConsumivel> qualquer, partidaCST partidaCST) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = buffRead.readLine();;
        int ID = 0;
        qualquer.clear();
        qualquer = new ArrayList<>();
        while (linha != null) {
                String[] fatiada = linha.split(" ");
                if(fatiada[0].intern() == "FlexaoPyke"){
                    ID = 1;
                }else if(fatiada[0].intern() == "Pizza"){
                    ID = 2;
                }else{
                    ID = 3;
                }
                qualquer.add(new itemConsumivel(fatiada[0] , (int)fatiada[2].charAt(0), partidaCST, ID));
                
            linha = buffRead.readLine();
        }
        buffRead.close();
        return qualquer;
    }
    public static List<itemEquipavel> leitorEquipavel(String nome, List<itemEquipavel> qualquer, partidaCST partidaCST) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = buffRead.readLine();
        int IDS = 0;
         qualquer.clear();
        qualquer = new ArrayList<>();
        while (linha != null) {
                String[] fatiada = linha.split(" ");
                if(fatiada[0].intern() == "CamisadaPlaystation"){
                    IDS = 1;
                }else if(fatiada[0].intern() == "TacodeSinuca"){
                    IDS = 2;
                }
                qualquer.add(new itemEquipavel(fatiada[0], partidaCST, IDS));

            linha = buffRead.readLine();
        }
        buffRead.close();
        return qualquer;
    }
    public static void lerArquivo(String nome) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(nome));
        String linha = buffRead.readLine();

        while(linha != null){
            System.out.println(linha);
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
    public static void escritorConsumivel(List<itemConsumivel> qualquer, String nome, partidaCST partidaCST) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome, false));
        time timevencendor = partidaCST.testaQuemGanhou();
        if(timevencendor == time.ORACULO){
            for (itemConsumivel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNome() + " O " + itemConsumivel.getQuantidade() + "\n");
            }
        }else{
            for (itemConsumivel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNome() + " T " + itemConsumivel.getQuantidade()+ "\n");
            }
        }

        buffWrite.close();
    }
    public static void escritorEquipavel(List<itemEquipavel> qualquer, String nome, partidaCST partidaCST) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome, false));
        time timevencendor = partidaCST.testaQuemGanhou();
        if(timevencendor == time.ORACULO){
            for (itemEquipavel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNomeItem() + " O" + "\n");
            }
        }else{
            for (itemEquipavel itemConsumivel : qualquer) {
                buffWrite.append(itemConsumivel.getNomeItem() + " T" + "\n");
            }
        }

        buffWrite.close();
    }
}

