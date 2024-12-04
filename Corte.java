import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Corte {
    
    private int largura;
    private int altura;
    private List<Peca> pecas;

  
    public Corte(int largura, int altura) {
        this.largura = largura;   
        this.altura = altura;     
        this.pecas = new ArrayList<>();  
    }

    
    public void adicionarPeca(Peca peca) {
        pecas.add(peca);  
    }

    // Método para realizar o corte das peças na área fornecida
    public void fazerCorte(String outputFile) throws IOException {
    	
        pecas.sort((p1, p2) -> Integer.compare(p2.area(), p1.area()));
        
        List<String> resultados = new ArrayList<>();
        
        int[][] area = new int[largura][altura];
        
        int areaUtilizada = 0;

        // Loop para tentar cortar as peças
        for (Peca peca : pecas) {
        	
            // Tenta achar uma posição onde a peça pode ser cortada
            for (int i = 0; i <= largura - peca.getComprimento(); i++) {  
                for (int j = 0; j <= altura - peca.getAltura(); j++) {
               
                    // Verifica se a peça pode ser colocada na posição (i, j)
                    if (podeCortar(area, i, j, peca.getComprimento(), peca.getAltura())) {
                    	
                        // Marca a área como ocupada
                        cortar(area, i, j, peca.getComprimento(), peca.getAltura());
                        
                        resultados.add(peca.getTipo() + " " + i + " " + j);
                        
                        // Atualiza a area utilizada
                        areaUtilizada += peca.area();
                        
                        // Diminui a quantidade da peça depois do corte
                        peca.setQuantidade(peca.getQuantidade() - 1);
                        
                        if (peca.getQuantidade() == 0) {
                        	break;
                        }
                    }
                }
                // Se n houver mais peças desse tipo, quebra 
                if (peca.getQuantidade() == 0) {
                	break;
                }
            }
        }

        // Calcula a eficiência do corte
        double areaTotal = largura * altura;  
        double eficiencia = (areaUtilizada / areaTotal) * 100;  

        // Escreve os resultados e a eficiência no arquivo de saida
        escreverSaida(outputFile, resultados, eficiencia);
    }

    // Verifica se é possível cortar uma peça na posição especificada
    private boolean podeCortar(int[][] area, int x, int y, int comprimento, int altura) {
    	
        
        for (int i = x; i < x + comprimento; i++) {
            for (int j = y; j < y + altura; j++) {
            	
                // Se estiver ocupada não é possível cortar
                if (area[i][j] != 0) {
                	return false; 
                }
            }
        }
        // Se todas livres é possível cortar
        return true;
    }

    // Marca a area como ocupada apos cortar a peça
    private void cortar(int[][] area, int x, int y, int comprimento, int altura) {
        // Marca as areas como ocupadas 
        for (int i = x; i < x + comprimento; i++) {
            for (int j = y; j < y + altura; j++) {
                area[i][j] = 1;  // 1 significa ocupado
            }
        }
    }

    // Escreve os resultados e a eficiência do corte no arquivo de saída
    private void escreverSaida(String outputFile, List<String> resultados, double eficiencia) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        
        // Escreve os resultados de cada corte no arquivo
        for (String resultado : resultados) {
            writer.write(resultado);
            writer.newLine();  
        }
        
        // Escreve a %
        writer.write(String.format("Eficiência do corte: %.2f%%", eficiencia));
        writer.newLine();
        
        writer.close();
    }

}