package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.VaraAno;

public class CNVaraAnualDao extends DaoBase{
	
	public void inserir(VaraAno linha)  {

		String sql = "INSERT INTO TB_CN_VARA_ANUAL (vara,ano,jurisdicao, quantidade) VALUES(?,?,?,?)";

		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, linha.getVara());
			pstmt.setInt(2, linha.getAno());
			pstmt.setString(3, linha.getJurisdicao());
			pstmt.setInt(4, linha.getQuantidade());
			pstmt.executeUpdate();
			
			super.close();
		} catch (Exception e) {trataErro("Erro de banco de dados:",e);	}
	}
	
	public void limpar()  {
		String sql = "DELETE FROM TB_CN_VARA_ANUAL";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			super.close();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);}
	}
	
	public ArrayList<VaraAno>  getMedias(int anoInicial, int anoFinal) {
		
		ArrayList<VaraAno> lista = new ArrayList<VaraAno> ();
		
		String sql = "select vara,jurisdicao, round(avg(quantidade),0) media from tb_cn_vara_anual"
				+ " where ano between ?  and ?"
				+ " group by vara,jurisdicao"
				+ " order by vara,jurisdicao";
		
		try {        	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,anoInicial);
			pstmt.setInt(2,anoFinal);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				VaraAno obj = new VaraAno();
				obj.setVara(rs.getString("VARA"));
				obj.setJurisdicao(rs.getString("JURISDICAO"));
				obj.setQuantidade(rs.getInt("MEDIA")); 
				
				lista.add(obj);
			}		
			
			super.close();
		} catch (Exception e) {	trataErro("Erro de banco de dados:",e);	}
		
		return lista;
	}

}
