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

    public double getMediaMensalVisitas() {
        return visitasAnuais / 12.0;
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
