package main;

import java.util.ArrayList;

import dao.CNVaraAnualDao;
import dao.CNVaraDao;
import dao.CNVaraSimuladaDao;
import modelo.VaraAno;
import util.LeitorCSV;


public class Principal {

	public static void main(String[] args) {
		Principal me =new Principal();
		//me.lerCSV();
		//me.popularMedias();
		me.simular();

	}
	
	public void lerCSV() {
	/*
	 * popular TB_CN_VARA_ANUAL
	 */
		ArrayList<VaraAno> lista = new LeitorCSV().readCSV("casos_novos_por_vara.csv");
		
		System.out.println("populando....");
		new CNVaraAnualDao().limpar();
		
		for(VaraAno linha:lista) {
			new CNVaraAnualDao().inserir(linha);
		}	
		System.out.println("fim de popular");
	}
	
	public void popularMedias() {
	/*
	 * popular TB_CN_VARA
	 */
		ArrayList<VaraAno> listaMedia = new CNVaraAnualDao().getMedias(2021,2023);
		
		new CNVaraDao().limpar();
		
		for( VaraAno linha:listaMedia) {
			new CNVaraDao().inserir(linha);
			System.out.println(linha.getVara() + ", "+ linha.getQuantidade());
		}
	}
	
	public void simular() {
	/*
	 * popular TB_CN_VARA_SIMULADA
	 */	
	System.out.println("populando....");
	new CNVaraSimuladaDao().limpar();
	new CNVaraSimuladaDao().inserir();
	System.out.println("fim de popular");	
	
	new CNVaraSimuladaDao().alterar("001VT/CF");
	
	}
}
