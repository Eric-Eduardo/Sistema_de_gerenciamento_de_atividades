package entity;

public class Entity {
    private int id;
    private Boolean ativo = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Boolean getAtivo() {
        return ativo;
    }
}