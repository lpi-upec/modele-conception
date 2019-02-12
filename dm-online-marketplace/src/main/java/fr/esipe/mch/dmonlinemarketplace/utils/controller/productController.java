package fr.esipe.mch.dmonlinemarketplace.utils.controller;

import fr.esipe.mch.dmonlinemarketplace.models.productDTO;
import fr.esipe.mch.dmonlinemarketplace.services.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Daiiguren
 */
@RestController
public class productController {
    @Autowired
    private IproductService productService;

    /**
     * Request method to get a product by his ID
     * @param id Product ID
     * @return productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/{id}")
    public productDTO getProduct(@PathVariable("id") String id) {
        return productService.get(id);
    }

    /**
     * Request method to create a new product by id
     * @param id Product ID
     * @param name Product Name
     * @param price Product Price
     * @param description Product Description
     * @return productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/new/{id}")
    public productDTO newProduct(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("description") String description) {
        return productService.add(productDTO.builder().id(id).name(name).description(description).price(price).build());
    }

    /**
     * Request method to delete a product
     * @param id Product ID
     * @return Delete String
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.remove(id);
        return "Product Deleted";
    }

    /**
     * Request method to get all product
     * @return Liste of all product
     */
    @RequestMapping(method = RequestMethod.GET, path = "/products")
    public List<productDTO> allProd(){
        return productService.getAll();
    }

    /**
     * Request method to update a product by his ID
     * @param id Product ID
     * @param name Product Name
     * @param price Product Price
     * @param description Product Description
     * @return productDTO
     */
    @RequestMapping(method = RequestMethod.GET, path = "/product/update/{id}")
    public productDTO update(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("description") String description) {
        productDTO product = productService.get(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return product;
    }
}
