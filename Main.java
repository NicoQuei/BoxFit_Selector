import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\ZZZTESTE\\src\\Entrada"));
            String[] dimensoes = reader.readLine().split(" ");
            int largura = Integer.parseInt(dimensoes[0]);
            int altura = Integer.parseInt(dimensoes[1]);
            Corte corte = new Corte(largura, altura);

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String[] dados = reader.readLine().split(" ");
                int tipo = Integer.parseInt(dados[0]);
                int comprimento = Integer.parseInt(dados[1]);
                int alturaPeca = Integer.parseInt(dados[2]);
                int quantidade = Integer.parseInt(dados[3]);
                corte.adicionarPeca(new Peca(tipo, comprimento, alturaPeca, quantidade));
            }

            corte.fazerCorte("C:\\Users\\User\\eclipse-workspace\\ZZZTESTE\\src\\Saida");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
