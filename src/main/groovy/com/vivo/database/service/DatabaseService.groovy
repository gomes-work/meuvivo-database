package com.vivo.database.service

import com.vivo.database.repository.ProcConsultaDadosCliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by joaogomes on 10/05/17.
 */
@Component
class DatabaseService {
    @Autowired ProcConsultaDadosCliente consultaDadosCliente;

    public Map<String, Object> consultaPorEmail(String email) {
        consultaDadosCliente.execute(email, null, null, null, null);
    }
}
