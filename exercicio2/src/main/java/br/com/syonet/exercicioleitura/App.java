package br.com.syonet.exercicioleitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Filial> filiais = new ArrayList<>();

        try (BufferedReader ler = new BufferedReader(new FileReader("arquivo_fornecido.csv"))) {
            String linha;
            int lineCount = 0;
            while ((linha = ler.readLine()) != null) {
                if (lineCount == 0) {
                    // Pular a primeira linha, que é o cabeçalho
                    lineCount++;
                    continue;
                }
                
                String[] dados = linha.split(",");

                // Inicializa novaLista para cada linha lida
                Filial novaLista = new Filial();
                novaLista.nome = dados[0];
                novaLista.endereco = dados[1];
                novaLista.cidade = dados[2];
                novaLista.codigoPostal = dados[3];
                //System.out.println(novaLista.nome); // Teste para verificar que está funcionando

                List<Integer> visitasMensais = new ArrayList<>();
                for (int i = 4; i <= 15; i++) {
                    visitasMensais.add(Integer.parseInt(dados[i]));
                }

                // Atribui a lista de visitas mensais à novaLista
                novaLista.visitasMensais = visitasMensais;

                //Conversão de uma string para um número inteiro
                try {
                    novaLista.visitasAnuais = Integer.parseInt(dados[16]);
                } catch (NumberFormatException e) {
                    novaLista.visitasAnuais = 0; // Valor padrão
                    System.out.println("Sem valor numérico " + dados[16]);
                }
                novaLista.geolocalizacao = dados[17];
                filiais.add(novaLista);
                
            }
            //Imprimi quebrando as linhas
            for (Filial filial : filiais) {
            System.out.println(filial);
                }

            // Encontrar a filial com a maior média de visitas
            Filial maiorMediaFilial = filiais.stream()
            .max((f1, f2) -> Double.compare(f1.getMediaMensalVisitas(), f2.getMediaMensalVisitas()))
            .orElse(null);

            // Encontrar a filial com a menor média de visitas
            Filial menorMediaFilial = filiais.stream()
            .min((f1, f2) -> Double.compare(f1.getMediaMensalVisitas(), f2.getMediaMensalVisitas()))
            .orElse(null);

            if (menorMediaFilial != null) {
                System.out.println("=================================================");
                System.out.println("A filial com a menor média de visitas é: " + menorMediaFilial.nome +
                        " com média de " + menorMediaFilial.getMediaMensalVisitas());
            }

           if (maiorMediaFilial != null) {
            System.out.println("=================================================");
           System.out.println("A filial com a maior média de visitas é: " + maiorMediaFilial.nome + " com média de " + maiorMediaFilial.getMediaMensalVisitas());
}
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }
    }
}
