
public class Peca {
	
	private int tipo;
    private int comprimento;
    private int altura;
    private int quantidade;

    public Peca(int tipo, int comprimento, int altura, int quantidade) {
		this.tipo = tipo;
		this.comprimento = comprimento;
		this.altura = altura;
		this.quantidade = quantidade;
	}
    
    
    
	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public int getComprimento() {
		return comprimento;
	}



	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	// Metpdo que calcula area
    public int area() {
        return comprimento * altura;
    }
	
}
