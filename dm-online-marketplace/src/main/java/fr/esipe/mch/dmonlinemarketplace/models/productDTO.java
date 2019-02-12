package fr.esipe.mch.dmonlinemarketplace.models;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

/**
 * @author Daiiguren
 */
@Builder
@AllArgsConstructor
public class productDTO {
    private String id;
    private String name;
    private Integer price;
    private String description;
    private List<String> componentDescription;
    private String urlImage;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(List<String> componentDescription) {
        this.componentDescription = componentDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
