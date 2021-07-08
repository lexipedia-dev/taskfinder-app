package br.com.taskfinder.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
@Transactional
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioRequestDto dto) {
        Usuario usuario = dto.toModel(dto);
        Perfil perfil = new Perfil();
        perfil.setNome("CONTRATANTE");
        perfilRepository.save(perfil);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultar(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscaTodosUsuarios(){
        return ResponseEntity.ok().body(usuarioRepository.findAll());
    }


    @PostMapping("/{id}/tornar-contratado")
    public ResponseEntity<?>mudarRoleContratado(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.mudarRoleContratado();
        return ResponseEntity.ok().body(usuario);

    }

    @PostMapping("/{id}/tornar-contratante")
    public ResponseEntity<?>mudarRoleContratante(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.mudarRoleContratante();
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/{id}/atualizar")
    public ResponseEntity<?> atualizarCadastro(@PathVariable Integer id, @RequestBody @Valid FormAtualizacao form){
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.atualizarCadastro(form);
        return ResponseEntity.ok().body(usuario);
    }

}
