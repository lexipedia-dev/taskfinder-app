package br.com.taskfinder.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioRequestDto dto){
        Usuario usuario = dto.toModel(dto);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPendenteResponseDto>> getUsers(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioPendenteResponseDto> usuariosDto = UsuarioPendenteResponseDto.toDtoList(usuarios);

        return ResponseEntity.ok().body(usuariosDto);

    }
}
