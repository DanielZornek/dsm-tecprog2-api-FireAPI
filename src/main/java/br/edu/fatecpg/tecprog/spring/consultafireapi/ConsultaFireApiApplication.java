package br.edu.fatecpg.tecprog.spring.consultafireapi;

import br.edu.fatecpg.tecprog.spring.consultafireapi.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ConsultaFireApiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ConsultaFireApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean loop_programa = true;
		Scanner entrada = new Scanner(System.in);

		while(loop_programa){
			System.out.print("\n\nSistema de busca de Automóveis\n1- Procurar Carro\n2- Fechar\n\nEScolha: ");
			String escolha = entrada.nextLine();

			if(escolha.equals("1")){
				listarMarcas();
				System.out.print("Código da marca: ");
				String codigoMarca = entrada.nextLine();

				listarModelos(codigoMarca);
				System.out.print("Código do modelo: ");
				String codigoModelo = entrada.nextLine();
				
			}else if(escolha.equals("2")){
				loop_programa = false;
				System.out.println("Fechando programa, até mais");
			}else{
				System.out.println("Desculpe não entendi, tente novamente!");
			}
		}
	}

	protected static void listarModelos(String marca) throws IOException, InterruptedException {
		String dados = ConsumoAPI.obterDados("https://fipe.parallelum.com.br/api/v1/carros/marcas/"+marca+"/modelos/");
		dados = dados.replace("{", "");
		dados = dados.replace("}", "");
		dados = dados.replace("\"", "");
		dados = dados.replace("[", "");
		dados = dados.replace("]", "");
		dados = dados.replace("modelos", "");
		dados = dados.replace(":", "");

		String[] listaCarros = dados.split(",");

		for(int i = 1; i <= listaCarros.length; i+=2){

			String nomeCarro = listaCarros[i];
			nomeCarro = nomeCarro.replace("nome", "");
			String cdCarro = listaCarros[i-1];
			cdCarro = cdCarro.replace("codigo", "");

			if(!nomeCarro.contains("Gasolina") && !nomeCarro.contains("Diesel")){
				System.out.println("Código do carro: " + cdCarro + " | Modelo: " + nomeCarro);
			}
		}
	}

	protected static void listarMarcas() throws IOException, InterruptedException {
		String dados = ConsumoAPI.obterDados("https://fipe.parallelum.com.br/api/v1/carros/marcas");
		dados = dados.replace("[","");
		dados = dados.replace("]","");
		dados = dados.replace("{", "");

		String[] listaMarcasSeparado = dados.split(",");

		System.out.println("Marcas cadastradas: ");

		for(int i = 1; i <= listaMarcasSeparado.length; i+=2){

			String codigo = listaMarcasSeparado[i-1];
			String marca = listaMarcasSeparado[i].replace("}", "");

			codigo = codigo.replace("\"", "");
			codigo = codigo.replace(":", "");
			codigo = codigo.replace("codigo", "");

			marca = marca.replace("nome", "");
			marca = marca.replace("\"", "");
			marca = marca.replace(":", "");

			System.out.print("Codigo da marca: " + codigo + " | Marca: " + marca + "\n");
		}
	}
}
