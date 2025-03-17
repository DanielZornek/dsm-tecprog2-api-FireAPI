package br.edu.fatecpg.tecprog.spring.consultafireapi.model;

public class Veiculo {
    private int TipoVeiculo;
    private String Valor;
    private String Marca;
    private String Modelo;
    private int AnoModelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private String SiglaCombustivel;

    @Override
    public String toString() {
        return "Veiculo: \n" +
                "TipoVeiculo: " + this.TipoVeiculo + "\n" +
                "Valor: " + this.Valor + "\n" +
                "Marca: " + this.Marca + "\n" +
                "Modelo: " + this.Modelo + "\n" +
                "AnoModelo: " + this.AnoModelo +
                "Combustivel: " + this.Combustivel + "\n" +
                "CodigoFipe: " + this.CodigoFipe + "\n" +
                "MesReferencia: " + this.MesReferencia + "\n" +
                "SiglaCombustivel: " + this.SiglaCombustivel;
    }
}
