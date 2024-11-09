package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DaoBase {
	Connection conn = new DBConnectionSQLite().getConnection();
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public int buscaIdInserido()    throws SQLException {

        Statement s = conn.createStatement();
        s.execute("SELECT last_insert_rowid()");
        ResultSet rs=s.getResultSet();

    	if (!rs.next()) {
    	    System.out.println("Something is wrong...");
    	    return 0;
    	}

    	final int id = rs.getInt("last_insert_rowid()");

    	return id;
    }
    
    protected void trataErro(String msg, Exception e) {
    	e.printStackTrace();
    	JOptionPane.showMessageDialog(null,msg);
    }
}
