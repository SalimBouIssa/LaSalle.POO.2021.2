package model;

public class Jogo {
    private String id;
    private String nome;
    private String genero;
    private String id_dev;
    private String id_publi;

    // Getters
    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String getId_dev() {
        return id_dev;
    }
    
    public String getId_publi() {
        return id_publi;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setId_dev(String id_dev) {
        this.id_dev = id_dev;
    }

    public void setId_publi(String id_publi) {
        this.id_publi = id_publi;
    }
}
