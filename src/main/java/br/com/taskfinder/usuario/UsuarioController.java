package br.com.taskfinder.usuario;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioRequestDto dto){
        Usuario usuario = dto.toModel(dto);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultar(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPendenteResponseDto>> getUsers(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioPendenteResponseDto> usuariosDto = UsuarioPendenteResponseDto.toDtoList(usuarios);

        return ResponseEntity.ok().body(usuariosDto);

    }

    @PostMapping("/teste-cadastro")
    public ResponseEntity<?> testeCadastro(){
        UsuarioRequestDto dto1 = new UsuarioRequestDto("Nome 01", "email01@email.com", "Usuario01", "Senha 01");
        UsuarioRequestDto dto2 = new UsuarioRequestDto("Nome 01", "email01@email.com", "Usuario01", "Senha 01");
        UsuarioRequestDto dto3 = new UsuarioRequestDto("Nome 01", "email01@email.com", "Usuario01", "Senha 01");
        UsuarioRequestDto dto4 = new UsuarioRequestDto("Nome 01", "email01@email.com", "Usuario01", "Senha 01");

        usuarioRepository.save(dto1.toModel(dto1));
        usuarioRepository.save(dto2.toModel(dto2));
        usuarioRepository.save(dto3.toModel(dto3));
        usuarioRepository.save(dto4.toModel(dto4));

        return ResponseEntity.ok().build();
    }



}
