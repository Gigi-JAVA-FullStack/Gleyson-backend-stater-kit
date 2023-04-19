package digytal.backend.api.starter;

import digytal.backend.api.properties.CadastroProperties;
import digytal.backend.api.model.cliente.ClienteRequest;
import digytal.backend.api.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MercadoPagoIntegration {
    @Autowired
    private ClienteService service;

    @Autowired
    private CadastroProperties cadastroProperties;
    public void execute(){
        ClienteRequest request = new ClienteRequest();
        BeanUtils.copyProperties(cadastroProperties,request);

        System.out.println(request);
    }
}
