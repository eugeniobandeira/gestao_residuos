package br.com.fiap.gestao_residuos.enums;

public enum UsuarioRoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    UsuarioRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
