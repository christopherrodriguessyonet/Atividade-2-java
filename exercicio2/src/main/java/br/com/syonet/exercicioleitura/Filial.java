package br.com.syonet.exercicioleitura;

import java.util.List;

public class Filial {
    String nome;
    String endereco;
    String cidade;
    String codigoPostal;
    List<Integer> visitasMensais;
    int visitasAnuais;
    String geolocalizacao;  



// Método para calcular a média das visitas mensais
public double getMediaMensalVisitas() {
    int totalVisitas = 0;
    for (int visitas : visitasMensais) {
        totalVisitas += visitas;
    } return (double) totalVisitas / visitasMensais.size();
}
    //Sobrescrevendo o objeto
    @Override
    public String toString() {
        return "Filial{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", visitasMensais=" + visitasMensais +
                ", visitasAnuais=" + visitasAnuais +
                ", geolocalizacao='" + geolocalizacao + '\'' +
                '}';
    }
}