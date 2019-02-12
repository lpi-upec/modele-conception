package fr.esipe.mch.composite;

import fr.esipe.mch.dmonlinemarketplace.services.IproductService;
import org.junit.Test;

public class MockerTest {

    @Test
    public void testCreateMock(){
        IproductService productService = Mocker.createMock(IproductService.class);

        productService.getAll();
    }
}
