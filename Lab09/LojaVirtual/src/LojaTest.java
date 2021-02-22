import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import static org.junit.Assert.*;

public class LojaTest {

    Loja loja;
    Livro livro1;
    Livro livro2;
    CD cd1;
    Bicicleta bicicleta1;
    Usuario comprador;
    Transportadora gatoPreto;
    ImpressoraJatoDeTinta impressoraJatoDeTinta1;
    Grafica grafica1;

    @Before
    public void setUp() {
        gatoPreto = new Transportadora();
        impressoraJatoDeTinta1 = new ImpressoraJatoDeTinta("HP", 2018);
        grafica1 = new Grafica();

        loja = new Loja(
                gatoPreto,                // informamos à loja qual a transportadora que ela vai usar (agregação)
                impressoraJatoDeTinta1);  // ...e o serviço de impressão que ela vai usar (agregação tb);

        livro1 = new Livro(12345, "Da Terra à Lua", "Julio Verne", null, 1865, Categoria.LIVRO_DIDATICO);
        livro1.setPrecoEmReais(25);

        livro2 = new Livro(12446, "Dom Quixote", "Miguel de Cervantes", null, 1605, Categoria.FICCAO);
        livro2.setPrecoEmReais(42.30f);

        cd1 = new CD(121223, "Ride The Lightning", "Metallica", 1985);
        cd1.setPrecoEmReais(18.50f);

        bicicleta1 = new Bicicleta(9999, 700, "Pinarello");
        bicicleta1.setPrecoEmReais(580);

        loja.incluirItem(livro1);
        loja.incluirItem(livro2);
        loja.incluirItem(cd1);
        loja.incluirItem(bicicleta1);

        comprador = new Usuario(111111, "Maria");
        comprador.setEndereco("Rua Tal, Numero Tal");
    }

    @Test
    public void testarVendaParaProdutoExistente() throws
            ItemNaoExisteNoCatalogoException, EstoqueInsuficienteException,
            EnderecoInvalidoException, ErroNoPagamentoException {

        String recibo = null;
        recibo = loja.receberPedido(cd1, 3, comprador);
        assertNotNull(recibo);
        System.out.println(recibo);
    }

    @Test
    public void testarVendaParaProdutoNaoExistente() {

        Livro livroNaoExistente = new Livro(1010101,
                "Blah",
                "Qualquer coisa",
                null,
                2000,
                Categoria.LIVRO_DIDATICO);

        String recibo = null;

        try {
            recibo = loja.receberPedido(livroNaoExistente, 5, comprador);
        }
        catch (ItemNaoExisteNoCatalogoException  |
                    EstoqueInsuficienteException |
                    EnderecoInvalidoException    |
                    ErroNoPagamentoException e) {
            assertNull(recibo);
        }
    }

    @Test
    public void testarVendaComDescontoParaLivrosDidaticos() {
        String recibo = null;
        int quantidade = 4;
        try {

            recibo = loja.receberPedido(livro1, quantidade, comprador);

            int index = recibo.indexOf("$");
            float valorComDesconto = new Float(
                        recibo.substring(index + 1,index + 6)
                            .replace(",","."))
                            .longValue();

            float valorSemDesconto = livro1.getPrecoEmReais() * quantidade;

            System.out.println("Valor sem desconto: " + valorSemDesconto +
                    "\nValor com desconto: " + valorComDesconto);

            assertNotEquals(valorComDesconto,valorSemDesconto);

        }
        catch (ItemNaoExisteNoCatalogoException  |
                    EstoqueInsuficienteException |
                    EnderecoInvalidoException    |
                    ErroNoPagamentoException e) {
            System.out.println("Algo de errado não está certo");
        }
    }
}