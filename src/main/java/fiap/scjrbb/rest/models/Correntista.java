package fiap.scjrbb.rest.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class Correntista {

    @Schema(description = "Identificador do correntista", nullable = false, required = true)
    private String id;

    @Schema(description = "Nome do correntista", nullable = false, required = true)
    private String nome;

    @Schema(description = "Telefone do correntista", nullable = true, required = false)
    private String telefone;

    public Correntista() {
        super();
    }

    public Correntista(String id, String nome, String telefone) {
        this();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
