package br.com.cadastro.usuario.repository;

import br.com.cadastro.usuario.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
