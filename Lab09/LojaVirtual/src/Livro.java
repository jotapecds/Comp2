public class Livro extends ArtigoCultural {

    private final int codigoISBN;

    private String titulo;

    private String autor;

    private String editora;

    private int anoPublicacao;

    private int numeroDePaginas;

    private Categoria categoria;

    public Livro(int codigoISBN,
                 String titulo, String autor, String editora, int anoPublicacao, Categoria categoria) {

        super(codigoISBN,
                String.format("Livro: %s (%s, %d)",
                titulo, autor, anoPublicacao));

        this.codigoISBN = codigoISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
    }

    public int getCodigoISBN() {
        return codigoISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getCategoria() {return this.categoria.getCodigo();}

    public void setCategoria(Categoria novaCategoria) {this.categoria = novaCategoria;}

    @Override
    public String toString() {
        return "Código ISBN: " + getCodigoISBN() +
                "Título: " + getTitulo() +
                "Autor: " + getAutor() +
                "Editora: " + getEditora() +
                "Ano de publicação: " + getAnoPublicacao() +
                "Número de páginas: " + getNumeroDePaginas() +
                "Categoria: " + getCategoria();
    }
}
