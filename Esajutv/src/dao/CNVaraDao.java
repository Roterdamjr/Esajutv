package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.VaraAno;

public class CNVaraDao  extends DaoBase{
	
	public void inserir(VaraAno linha)  {

		String sql = "INSERT INTO TB_CN_VARA(vara,jurisdicao, quantidade) VALUES(?,?,?)";

		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, linha.getVara());
			pstmt.setString(2, linha.getJurisdicao());
			pstmt.setInt(3, linha.getQuantidade());
			pstmt.executeUpdate();
			
			super.close();
		} catch (Exception e) {trataErro("Erro de banco de dados:",e);	}
	}
	
	public void limpar()  {
		String sql = "DELETE FROM TB_CN_VARA";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			super.close();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);}
	}
	
	public ArrayList<String> getVaras() {
		ArrayList<String> varas = new ArrayList<String>();
		
		String sql = "SELECT * from TB_VARA";

		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				varas.add(rs.getString("vara"));
            }
			
			super.close();
		} catch (Exception e) {		trataErro("Erro de banco de dados:",e);		}
		return varas;
	}
	
	public ArrayList<String> getJurisdicoes() {
		ArrayList<String> varas = new ArrayList<String>();
		
		String sql = "select distinct jurisdicao from tb_vara order by jurisdicao";

		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				varas.add(rs.getString("jurisdicao"));
            }
			
			super.close();
		} catch (Exception e) {		trataErro("Erro de banco de dados:",e);		}
		return varas;
	}
}
