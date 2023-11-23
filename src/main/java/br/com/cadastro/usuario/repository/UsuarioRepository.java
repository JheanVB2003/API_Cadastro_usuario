package br.com.cadastro.usuario.repository;

import br.com.cadastro.usuario.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsuarioRepository extends CrudRepository<Usuario, UUID> {

}
