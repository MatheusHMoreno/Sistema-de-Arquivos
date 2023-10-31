/*
 * Licensed to the Apache Software Foundation (ASF) under
 * the Apache License, Version 2.0 (
 * @autor Matheus Henrique Moreno da Silva
 */

package hardware;

public class Configuracao {
	// Variaveis estaticas que armazenam valores constantes
	private static int nome = 8 * 12; // Tamanho do campo "nome"
	private static int endereco = 21; // Tamanho do campo "endereco"
	private static int data = 20; // Tamanho do campo "data"
	private static int mes = 4; // Tamanho do campo "mes"
	private static int dia = 5; // Tamanho do campo "dia"
	private static int hora = 5; // Tamanho do campo "hora"
	private static int minuto = 6; // Tamanho do campo "minuto"
	private static int permissao = 9; // Tamanho do campo "permissao"
	private static int conteudoBlocoA = 315; // Tamanho do campo "conteudoBlocoA"
	private static int conteudoBlocoB = 441; // Tamanho do campo "conteudoBlocoB"
	private static int tipo = 2; // Tamanho do campo "tipo"
	private static int resto = 512 - 484; // Tamanho do campo "resto"
	private static int tamBloco = 512; // Tamanho de um bloco
	private static int completaConteudoBinario = 5; // Tamanho do campo "completaConteudoBinario"
	private static int qntdFilhos = 14; // Número de filhos

	public static int getTamBloco() {
		return tamBloco;
	}

	public static int getResto() {
		return resto;
	}

	public static int getNome() {
		return nome;
	}

	public static int getEndereco() {
		return endereco;
	}

	public static int getData() {
		return data;
	}

	public static int getMes() {
		return mes;
	}

	public static int getDia() {
		return dia;
	}

	public static int getHora() {
		return hora;
	}

	public static int getMinuto() {
		return minuto;
	}

	public static int getPermissao() {
		return permissao;
	}

	public static int getConteudoBlocoA() {
		return conteudoBlocoA;
	}

	public static int getConteudoBlocoB() {
		return conteudoBlocoB;
	}

	public static int getTipo() {
		return tipo;
	}

	public static int getPosicaoInicioNome() {
		return nome;
	}

	public static int getPosicaoInicioEndereco() {
		return endereco;
	}

	public static int getPosicaoInicioData() {
		return data;
	}

	public static int getPosicaoInicioMes() {
		return mes;
	}

	public static int getPosicaoInicioDia() {
		return dia;
	}

	public static int getPosicaoInicioHora() {
		return hora;
	}

	public static int getPosicaoInicioMinuto() {
		return minuto;
	}

	public static int getPosicaoInicioPermissao() {
		return permissao;
	}

	public static int getPosicaoInicioConteudoBlocoA() {
		return conteudoBlocoA;
	}

	public static int getPosicaoInicioConteudoBlocoB() {
		return conteudoBlocoB;
	}

	public static int getPosicaoInicioTipo() {
		return tipo;
	}

	public static int getPosicaoFimNome() {
		return nome;
	}

	public static int getPosicaoFimEndereco() {
		return endereco;
	}

	public static int getPosicaoFimData() {
		return data;
	}

	public static int getPosicaoFimMes() {
		return mes;
	}

	public static int getPosicaoFimDia() {
		return dia;
	}

	public static int getPosicaoFimHora() {
		return hora;
	}

	public static int getPosicaoFimMinuto() {
		return minuto;
	}

	public static int getPosicaoFimPermissao() {
		return permissao;
	}

	public static int getPosicaoFimConteudoBlocoA() {
		return conteudoBlocoA;
	}

	public static int getPosicaoFimConteudoBlocoB() {
		return conteudoBlocoB;
	}

	public static int getPosicaoFimTipo() {
		return tipo;
	}

	public static int getCompletaConteudoBinario() {
		return completaConteudoBinario;
	}

	public static void setCompletaConteudoBinario(int completaConteudoBinario) {
		Configuracao.completaConteudoBinario = completaConteudoBinario;
	}

	public static int getQntdFilhos() {
		return qntdFilhos;
	}

	public static void setQntdFilhos(int qntdFilhos) {
		Configuracao.qntdFilhos = qntdFilhos;
	}

}
