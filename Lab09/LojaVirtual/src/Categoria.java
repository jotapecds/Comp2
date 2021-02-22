public enum Categoria {

    ENCICLOPEDIA("ENC"),
    LIVRO_DIDATICO("LD"),
    FICCAO("FIC"),
    BIOGRAFIA("BIO"),
    ARTE("AR"),
    DICIONARIO("DIC"),
    NAO_FICCAO("NF");

    private String codigo;

    Categoria (String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }
}