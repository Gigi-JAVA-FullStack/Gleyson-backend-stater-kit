package digytal.backend.api.service;

import digytal.backend.api.model.ClienteEntity;
import digytal.backend.api.model.ClienteRequest;
import digytal.backend.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    //PrePersist
    public void save(ClienteRequest request){
        //chamando o método da propria classe para cuidar em persistir no banco de dados
        this.persist(null, request);
    }
    //PreUpdate
    public void update(Integer id, ClienteRequest request){
        //chamando o método da propria classe para cuidar em persistir no banco de dados
        this.persist(id, request);
    }
    @Transactional
    public Integer persist(Integer id, ClienteRequest request){
        ClienteEntity entity = null;
        if(id!=null){
            entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível localizar o cliente com o ID " + id));
        }else
            entity = new ClienteEntity();

        //este método copia todos os atributos do request para o entity
        BeanUtils.copyProperties(request,entity);

        return repository.save(entity).getId();
    }
}
