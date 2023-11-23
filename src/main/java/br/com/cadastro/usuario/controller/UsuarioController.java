package br.com.cadastro.usuario.controller;

import br.com.cadastro.usuario.model.Usuario;
import br.com.cadastro.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
   @Autowired
   private UsuarioRepository repository;

    @GetMapping({"","/"})
    public List<Usuario> listaUsuarios(){
        return (List<Usuario>) repository.findAll();
    }

    @PostMapping
    public  ResponseEntity<?> criarUsuario(@RequestBody Usuario usuarios){

        if (usuarios.getNome() == null || usuarios.getNome().isEmpty()) {
            return ResponseEntity.badRequest().body("O campo 'nome' é obrigatório.");
        }

        Usuario usuarioNovo  = repository.save(usuarios);
        return ResponseEntity.ok(usuarioNovo);
    }

    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuarios){
        Usuario usuarioNovo = repository.save(usuarios);
        return usuarioNovo;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> excluirUsuario (@PathVariable Integer id){
        Optional<Usuario> usuario = repository.findById(id);
        repository.deleteById(id);
        return usuario;
    }



}
