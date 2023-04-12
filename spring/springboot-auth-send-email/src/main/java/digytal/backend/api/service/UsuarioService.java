package digytal.backend.api.service;

import digytal.backend.api.model.usuario.UsuarioEntity;
import digytal.backend.api.model.usuario.UsuarioNovaSenha;
import digytal.backend.api.model.usuario.UsuarioRequest;
import digytal.backend.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public void gravarUsuario(UsuarioRequest request){
        UsuarioEntity entity = new UsuarioEntity();

        entity.setNome(request.getNome());
        entity.setLogin(request.getLogin());

        //uma senha temporária de 8 digitos
        String senhaCriptografada =  UUID.randomUUID().toString().substring(0, 8);
        entity.setSenha(senhaCriptografada);

        repository.save(entity);
    }
    @Transactional
    public void gerarSenhaTemporaria(String email){
        //localizando o usuario pelo login
        UsuarioEntity entity = repository.findByEmail(email);

        //uma senha temporária de 8 digitos
        String senhaCriptografada =  UUID.randomUUID().toString().substring(0, 8);
        entity.setSenha(senhaCriptografada);

        repository.save(entity);
    }

    @Transactional
    public void alterarSenha(UsuarioNovaSenha novaSenha){
        //localizando o usuario pelo login
        UsuarioEntity entity = repository.findByEmail(novaSenha.getEmail());

        /**
         * FAÇA AS VALIDAÇÕES PARA ALTERAÇÃO DE SENHA
         */

        //uma senha temporária de 8 digitos
        String senhaCriptografada =  novaSenha.getSenhaNova();
        entity.setSenha(senhaCriptografada);

        repository.save(entity);
    }
}
