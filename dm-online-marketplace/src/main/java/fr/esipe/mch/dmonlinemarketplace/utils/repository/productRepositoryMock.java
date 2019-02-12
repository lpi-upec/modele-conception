package fr.esipe.mch.dmonlinemarketplace.utils.repository;

import fr.esipe.mch.dmonlinemarketplace.models.productDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daiiguren
 */
@Repository
public class productRepositoryMock {

    public static final List<productDTO> productMock;

    static {
        productMock = new ArrayList<>();
        productMock.add(productDTO.builder().id("id1").name("toto").build());
    }

    public <S extends productDTO> S save(S s) {
        productMock.add(s);
        return s;
    }

    public productDTO findById(String s) {
        for(productDTO product : productMock) {
            if(product.getId().equals(s)){
                return product;
            }
        }
        return null;
    }

    public boolean existsById(String s) {
        return false;
    }

    public Iterable<productDTO> findAll() {
        return productMock;
    }

    public Iterable<productDTO> findAllById(Iterable<String> iterable) {
        return null;
    }

    public void delete(productDTO productDTO) {
        productMock.remove(productDTO);
    }
}
