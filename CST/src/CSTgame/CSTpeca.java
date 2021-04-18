package CSTgame;

import tabuleiroGame.peca;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public abstract class CSTpeca extends peca{
    private time timinho;
    private int ataque;
    private int vida;
    private int defesa;
    private int rangeMovimento;
    public int getRangeMovimento() {
        return rangeMovimento;
    }
    protected void setRangeMovimento(int rangeMovimento) {
        this.rangeMovimento = rangeMovimento;
    }
    public int getAtaque() {
        return ataque;
    }
    protected void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getVida() {
        return vida;
    }
    protected void setVida(int vida) {
        this.vida = vida;
    }
    public int getDefesa() {
        return defesa;
    }
    protected void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public CSTpeca(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento) {
        super(tabul);
        this.timinho = timinho;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.rangeMovimento =rangeMovimento;
        
    }
    public time getTiminho() {
        return timinho;
    }
    protected boolean haUmaPecaDoOponente(posicao posicao){
        CSTpeca peca = (CSTpeca) getTabul().peca(posicao);
        return peca != null && peca.getTiminho() != getTiminho();
    }


    

}
