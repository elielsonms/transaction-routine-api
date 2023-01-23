package com.elielsonms.transactionroutineapi.infra.config;

import com.elielsonms.transactionroutineapi.infra.model.jpa.OperationType;
import com.elielsonms.transactionroutineapi.infra.repository.jpa.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DatabaseInitializationConfig implements ApplicationRunner{

    @Autowired
    OperationTypeRepository operationTypeRepository;
    @Override
    public void run(ApplicationArguments args) {
        final var operationTypes = new ArrayList<OperationType>();
        var operationType = new OperationType();
        operationType.setOperationTypeId(1);
        operationType.setDescription("COMPRA A VISTA");
        operationType.setCreditOperation(true);
        operationTypes.add(operationType);

        operationType = new OperationType();
        operationType.setOperationTypeId(2);
        operationType.setDescription("COMPRA PARCELADA");
        operationType.setCreditOperation(true);
        operationTypes.add(operationType);


        operationType = new OperationType();
        operationType.setOperationTypeId(3);
        operationType.setDescription("SAQUE");
        operationType.setCreditOperation(true);
        operationTypes.add(operationType);


        operationType = new OperationType();
        operationType.setOperationTypeId(4);
        operationType.setDescription("PAGAMENTO");
        operationType.setCreditOperation(false);
        operationTypes.add(operationType);




        operationTypeRepository.saveAll(operationTypes);
    }
}
