package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UserDetails findByEmail(String email);
}
