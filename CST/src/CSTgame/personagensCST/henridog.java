package CSTgame.personagensCST;

import CSTgame.CSTpeca;

import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro; 

public class henridog extends CSTpeca{

public henridog(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome) {
    super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
}

@Override
public String toString(){
    return "@";
}


    @Override
    public boolean[][] possiveisMovimentos() {
    boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
    int contMovimento = 1;
    posicao posTeste = new posicao(0, 0);
    //acima
    
    posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna());
        contMovimento++;
    }
    //abaixo
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna());
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna());
        contMovimento++;
    }
    //esquerda
      contMovimento = 1;
      posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() - 1);
      while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
        contMovimento++;
    }
        //direita
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
        contMovimento++;
    }
        // diagonal inferior esquerda
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() + 1 , posicao.getColuna() - 1);
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() + 1 , posTeste.getColuna() - 1);
        contMovimento++;
    }
        // diagonal superior esquerda
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() - 1 , posicao.getColuna() - 1);
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() - 1 , posTeste.getColuna() - 1);
        contMovimento++;
    }
        // diagonal inferior direita
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() + 1 , posicao.getColuna() + 1);
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() + 1 , posTeste.getColuna() + 1);
        contMovimento++;
    }
        // diagonal superior direita
    contMovimento = 1;
    posTeste.setCoordenada(posicao.getLinha() - 1 , posicao.getColuna() + 1);
    while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
        matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        posTeste.setCoordenada(posTeste.getLinha() - 1 , posTeste.getColuna() + 1);
        contMovimento++;
    }

    return matAux;
}  
    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        posicao posTeste = new posicao(0, 0);
        //acima
        posTeste.setCoordenada(getPosicao().getLinha() - 2, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //baixo
        posTeste.setCoordenada(getPosicao().getLinha() + 2, getPosicao().getColuna());
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //esquerda
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //direita
        posTeste.setCoordenada(getPosicao().getLinha() , getPosicao().getColuna() + 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }

        //diagonal inferior esquerda
        posTeste.setCoordenada(getPosicao().getLinha() + 2 , getPosicao().getColuna() - 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }  
        
        //diagonal superior esquerda
        posTeste.setCoordenada(getPosicao().getLinha() - 2 , getPosicao().getColuna() - 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }  
        
        //diagonal inferior direita
        posTeste.setCoordenada(getPosicao().getLinha() + 2 , getPosicao().getColuna() + 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        } 
        
        //diagonal superior direita
        posTeste.setCoordenada(getPosicao().getLinha() - 2 , getPosicao().getColuna() - 2);
        if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }         

        return matAux;
    }  
    @Override
    public void habilidade(CSTpeca generico) {
        CSTpeca qualquercoisa;
        posicao posTeste = new posicao (0, 0);
        int rangehab = 5;
        int cont = 1;
        // cima
    
        posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna());
        while (getTabul().posicaoExiste(posTeste) && cont <= rangehab) {
            if (haUmaPecaDoOponente(posTeste)) {
                qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                qualquercoisa.setVida(qualquercoisa.getVida() - 12);
                System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
            }
            posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna());
            cont++;
        }
        
        // baixo
        cont = 1;
        posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna());
        while (getTabul().posicaoExiste(posTeste) && cont <= rangehab) {
            if (haUmaPecaDoOponente(posTeste)) {
                qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                qualquercoisa.setVida(qualquercoisa.getVida() - 12);
                System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
            }
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna());
            cont++;
        }
        
        // esquerda
       cont = 1;
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 1);
        while (getTabul().posicaoExiste(posTeste) && cont <= rangehab) {
            if (haUmaPecaDoOponente(posTeste)) {
                qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                qualquercoisa.setVida(qualquercoisa.getVida() - 12);
                System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
        }
            posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
            cont++;
        }
        
        // direita
        cont = 1;
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() + 1);
        while (getTabul().posicaoExiste(posTeste) && cont <= rangehab) {
            if (haUmaPecaDoOponente(posTeste)) {
                qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                qualquercoisa.setVida(qualquercoisa.getVida() - 12);
                System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
            }
            posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() + 1);
            cont++;
        }
        
    }

}