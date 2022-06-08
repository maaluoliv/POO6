import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select extends Conect {

    private Statement st;

    @Override
    public Statement start() {
        return super.start();
    }

    @Override
    public void end() {
        super.end();
    }

    public void conectar() {

        try {
            st = start().getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buscaLivros() throws SQLException, ClassNotFoundException {

        try {
            conectar();
            st.executeQuery("SELECT * FROM livro;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {

                System.out.println("Livro: " + rs.getString("nm_titulo")+"\nValor: R$ " + rs.getString("vl_preco")+"\n======================================================");
                end();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    public void buscaClientes() throws SQLException, ClassNotFoundException {

        try {
            conectar();
            st.executeQuery("SELECT * FROM cliente;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {

                System.out.println("id: " + rs.getString("id_cliente") + "\nNome: " + rs.getString("nm_cliente") + "\nNumero: " + rs.getString("nu_telefone_cliente") + "\n================================");
                end();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }
    public void buscarPedidos(int id) throws SQLException,ClassNotFoundException{
        try {
            conectar();
            st.executeQuery("SELECT * FROM cliente WHERE id_cliente = "+id+";");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nm_cliente"));
            }
            st.executeQuery("SELECT * FROM pedido where id_cliente = "+id+";");
            rs = st.getResultSet();
            while (rs.next()) {
                System.out.println("Valor do Pedido = : " + rs.getString("vl_total_pago")+"\n===========================================");
                end();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}