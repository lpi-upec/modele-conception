package fr.esipe.mch.dmonlinemarketplace.services;

import fr.esipe.mch.dmonlinemarketplace.models.productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daiiguren
 */
@Service
public interface IproductService {

    @Autowired
    productDTO add(productDTO product);

    void remove(String id);

    productDTO update(productDTO product);

    productDTO get(String id);

    List<productDTO> getAll();
}
