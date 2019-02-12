package fr.esipe.mch.dmonlinemarketplace.services;

import fr.esipe.mch.dmonlinemarketplace.models.productDTO;
import fr.esipe.mch.dmonlinemarketplace.utils.repository.productRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daiiguren
 */
@Service
public class productService implements IproductService {
    @Autowired
    private productRepositoryMock productRepository;

    /**
     * Method to create a new product
     * @param product productDTO
     * @return productDTO created
     */
    @Override
    public productDTO add(productDTO product) {
        return productRepository.save(product);
    }

    /**
     * Method to remove a product
     * @param id Product ID
     */
    @Override
    public void remove(String id) {
        productRepository.delete(get(id));
    }

    /**
     * Method to update a product
     * @param product productDTO
     * @return productDTO updated
     */
    @Override
    public productDTO update(productDTO product) {
        return productRepository.save(product);
    }

    /**
     * Method to get a product by ID
     * @param id Product ID
     * @return productDTO found
     */
    @Override
    public productDTO get(String id) {
        return productRepository.findById(id);
    }

    /**
     * Method to list all product
     * @return all product
     */
    @Override
    public List<productDTO> getAll() {
        return (List<productDTO>) productRepository.findAll();
    }
}
