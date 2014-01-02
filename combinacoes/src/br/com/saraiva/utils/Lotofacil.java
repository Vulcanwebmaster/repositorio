package br.com.saraiva.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Uma classe que compara um arquivo de apostas efetuadas com todos os resultados publicados num arquivo
 * @author saraiva
 *
 */
public class Lotofacil {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Lotofacil lf = new Lotofacil();

//		String nomeDoArquivoComApostas = "C:\\Temp\\08_DE_21_15_A_15_COMBINACOES_201401020946.txt";
		String nomeDoArquivoComApostas = "C:\\Temp\\21_15_A_15_COMBINACOES_201401021504.txt";
				
		// lf.compararaTodosOsResultadosComMinhasApostas(nomeDoArquivoComApostas);
		
//		listaDezenasNoArquivo(Utils.leConteudoArquivo(nomeDoArquivoComApostas), Utils.leConteudoArquivo("c:\\temp\\Lotofacil_C1001.txt"));

		listaDezenasNoArquivo(Utils.leConteudoArquivo(nomeDoArquivoComApostas), Utils.leConteudoArquivo("c:\\temp\\resultadofake.txt"));
		
	}

	private static void listaDezenasNoArquivo(String conteudo, String resultado) {
		
		List<String> lista = new ArrayList<String>();
		
		for (String linha : conteudo.split("\n")) {
			String[] aux = linha.trim().replaceAll("\r", "").split(" ");
			for (String string : aux) {
				if (!lista.contains(string)) {
					lista.add(string);
				}
			}
		}
		
		System.out.println(" Tamanho do Array:[" + lista.size() + "]");
		
		Collections.sort(lista);
		
		System.out.print("Dezenas Apostadas:[");
		for (String string : lista) {
			System.out.printf("%s ", string);
		}
		System.out.println("]");
		
		System.out.println("        Resultado:[" + resultado.replaceAll("\n", "").trim() + "]");
		
		String[] aux = resultado.replaceAll("\n", "").trim().split(" ");
		
		int acertos = 0;
		String strAcertos = "";
		EXTERNO:
		for (String string : aux) {
			for (String apostada : lista) {
				if (string.equals(apostada)) {
					acertos++;
					strAcertos = strAcertos.concat(apostada).concat(" ");
					continue EXTERNO;
				}
			}
		}
		
		System.out.println("          Acertos:[" + acertos + "]");
		System.out.println("      Str Acertos:[" + strAcertos.trim() + "]");
	}

	@SuppressWarnings("unused")
	private void preparaArquivoDeResultados(String arqEntrada, String arqSaida) {
		Map<Integer, String> results = this.trataConteudo(Utils.leConteudoArquivo(arqEntrada));
		System.out.println("Tamanho do mapa:[" + results.size() + "]");
		Utils.gravaMapaEmArquivo(results, arqSaida);
	}
	
	/**
	 * Compara todos os resultadados da Lotofacil com um arquivo de apostas
	 * 
	 * @param arquivoApostas arquivo com apostas
	 */
	@SuppressWarnings("unused")
	private void compararaTodosOsResultadosComMinhasApostas(
			String arquivoApostas) {

		System.out.println("Iniciando compara��o...");

		boolean temPremiado = false;

		String s1 = Utils.leConteudoArquivo("c:\\temp\\lotofacil_2.txt");
		String s2 = Utils.leConteudoArquivo(arquivoApostas);

		Map<Integer, String> todos = this.trataConteudo(s1);
		Map<Integer, String> meus = this.trataConteudo(s2);

		for (Integer chave : meus.keySet()) {
			if (todos.containsKey(chave)) {
				System.out.println("Jogo:[" + todos.get(chave)
						+ "] j� foi premiado.");
				temPremiado = true;
			}
		}

		for (Integer chave : todos.keySet()) {
			ConferidorDeLoteria cl = new ConferidorDeLoteria(todos.get(chave));
			for (Integer aposta : meus.keySet()) {
				String[] aux = meus.get(aposta).split(" ");
				cl.premiado(aux);
			}
		}

		if (!temPremiado) {
			System.out
					.println("Nenhuma das apostas deste arquivo j� fez os 15 pontos.");
		}

	}

	/**
	 * Trata o conte�do de um string transformando o mesmo num mapa
	 * 
	 * @param conteudoArquivo String a tratar
	 * @return Mapa onde cada entrada representa uma "linha" do conte�do passado
	 */
	private Map<Integer, String> trataConteudo(String conteudoArquivo) {

		String[] conteudo = conteudoArquivo.split("\n");

		Map<Integer, String> mapa = new HashMap<Integer, String>();

		for (String linha : conteudo) {
			String aux = linha.replaceAll("\r", "");

			// System.out.println("> " + aux);

			int[] resultado = paraArrayInt(aux);

			String sResultado = paraStr(resultado);

			// System.out.println("< " + sResultado);

			mapa.put(sResultado.hashCode(), sResultado);
		}

		return mapa;
	}

	/**
	 * Recebe um array de inteiros e devolve um string com os n�meros formatados
	 * e separados por espa�os
	 * 
	 * @param old o array que se deseja converter
	 * @return um String que representa o array
	 */
	private String paraStr(int[] old) {
		StringBuilder sb = new StringBuilder();

		DecimalFormat df = new DecimalFormat("00");

		for (int i : old) {
			sb.append(df.format(i)).append(" ");
		}

		return sb.toString().trim();
	}

	/**
	 * Converte uma String em int[] usando o espa�o como separador
	 * 
	 * @param origem String com n�meros separados por espa�os
	 * @return um array de inteiros
	 */
	private static int[] paraArrayInt(String origem) {

		String[] bolas = origem.split(" ");

		int[] numeros = new int[bolas.length];

		for (int i = 0; i < bolas.length; i++) {
			numeros[i] = Integer.parseInt(bolas[i]);
		}

		Arrays.sort(numeros);

		return numeros;
	}

}
