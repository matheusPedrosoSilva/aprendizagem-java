package application;

public class TestaConexao {

	public static void main(String[] args) {
		Conexao c = new Conexao();
        c.openConnection();

        try {
            Thread.sleep(4000);
            c.closeConnection();
        } catch (InterruptedException e) {
            System.out.println("Houve algum problema no teste de conecxão. "+e.getMessage());
        }
    }
}


