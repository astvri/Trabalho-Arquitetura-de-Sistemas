import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO {
    private Map<Integer, Produto> produtos = new HashMap<>();

    // CREATE
    public void create(Produto produto) {
        if (produtos.containsKey(produto.getId())) {
            System.out.println("Erro: Produto com ID " + produto.getId() + " já existe.");
        } else {
            produtos.put(produto.getId(), produto);
            System.out.println("Produto criado: " + produto);
        }
    }

    // READ
    public Produto read(int id) {
        return produtos.get(id);
    }

    // UPDATE
    public void update(int id, String novoNome, double novoPreco) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            System.out.println("Produto atualizado: " + produto);
        } else {
            System.out.println("Erro: Produto com ID " + id + " não encontrado.");
        }
    }

    // DELETE
    public void delete(int id) {
        Produto removido = produtos.remove(id);
        if (removido != null) {
            System.out.println("Produto removido: " + removido);
        } else {
            System.out.println("Erro: Produto com ID " + id + " não encontrado.");
        }
    }
}
