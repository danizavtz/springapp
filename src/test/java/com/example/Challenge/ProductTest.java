package com.example.Challenge;

import com.example.Challenge.model.Category;
import com.example.Challenge.model.Product;
import com.example.Challenge.resources.ProductResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductResource.class)
public class ProductTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductResource productResource;

    @Test
    public void produtoPorCategoria() throws Exception {
        Category mockCategory = new Category();
        mockCategory.setNome("nomecategoria");
        Product mockProduct = new Product();
        mockProduct.setNome("teste1");
        mockProduct.setValor(12345);
        mockProduct.setCategoria(mockCategory);
        Mockito.when(productResource.listProductByCategory(1l)).thenReturn(Arrays.asList(mockProduct));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/product/listByCategory/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":null,\"nome\":\"teste1\",\"valor\":12345,\"category\":{\"id\":null,\"nome\":\"nomecategoria\"}}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }
}
