package mantenimiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion_mysql_television {

	private String _usuario="root";
	private String _pwd= "1234";
	private static String _bd="television";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	
	public conexion_mysql_television() {
		
		try{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
				System.out.println("Conexi-n a base de datos "+_url+" . . . Ok");
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}		
	}
	
	public ResultSet getQuery(String _query)
	{
		Statement state = null;
		ResultSet resultado = null;
		try{
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(_query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		return resultado;
	}
	
	public void setQuery(String _query){

		Statement state = null;
		
		try{			
			state=(Statement) conn.createStatement();
			state.execute(_query);

         } catch (SQLException e){
            e.printStackTrace();
       }
	}
}
