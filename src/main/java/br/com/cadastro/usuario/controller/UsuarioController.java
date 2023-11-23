package br.com.cadastro.usuario.controller;

import br.com.cadastro.usuario.model.Usuario;
import br.com.cadastro.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
   @Autowired
   private UsuarioRepository repository;

    @GetMapping({"","/"})
    public List<Usuario> listaUsuarios(){
        return (List<Usuario>) repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPeloID(@PathVariable(value = "id")UUID id){
        Optional<Usuario> usuario = repository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PostMapping
    public  ResponseEntity<?> criarUsuario(@Valid @RequestBody Usuario usuarios){
        Usuario usuarioNovo  = repository.save(usuarios);
        return ResponseEntity.ok(usuarioNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarUsuario (@PathVariable(value = "id") UUID id,@RequestBody Usuario usuario){
        Optional<Usuario> usuarioNovo = repository.findById(id);
        Usuario usuarioExiste = usuarioNovo.get();
        usuarioExiste.setNome(usuario.getNome());
        usuarioExiste.setEmail(usuario.getEmail());
        usuarioExiste.setSenha(usuario.getSenha());
        usuarioExiste.setTelefone(usuario.getTelefone());
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarioExiste));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirUsuario (@PathVariable(value = "id") UUID id){
        Optional<Usuario> usuario = repository.findById(id);
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }
    @DeleteMapping({"","/"})
    public ResponseEntity<Object> deletaUsuarios(){
        Iterable<Usuario> usuarios = repository.findAll();
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todos os usuários foram deletados!");
    }



}
