package com.example.Challenge;

import com.example.Challenge.model.Category;
import com.example.Challenge.resources.CategoryResource;
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
@WebMvcTest(value = CategoryResource.class)
public class CategoryTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryResource categoryResource;

    @Test
    public void listarCategorias() throws Exception {
        Category mockCategory = new Category();
        mockCategory.setNome("teste1");
        Mockito.when(categoryResource.listaCategorias()).thenReturn(Arrays.asList(mockCategory));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/category/listAll/").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":null,\"nome\":\"teste1\"}]";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
