package plus.estoque.infra.security.usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.estoque.infra.security.token.DadosTokenJWT;
import plus.estoque.infra.security.token.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);
        var usuario = (Usuario) autenticacao.getPrincipal();  // Obtém o usuário autenticado
        var tokenJWT = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT, usuario.getNome()));
    }

}
