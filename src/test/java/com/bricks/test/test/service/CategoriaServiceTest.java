package com.bricks.test.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bricks.test.test.client.ICategoriaCliente;
import com.bricks.test.test.service.impl.CategoriaServiceImpl;

import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest

public class CategoriaServiceTest {

    @Mock
    private ICategoriaCliente categoriaClienteMock;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    private AtomicInteger solicitudesDiarias;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        solicitudesDiarias = new AtomicInteger(0);

        categoriaService = new CategoriaServiceImpl();

     
        Field categoriaClienteField = CategoriaServiceImpl.class.getDeclaredField("categoriaCliente");
        categoriaClienteField.setAccessible(true);
        categoriaClienteField.set(categoriaService, categoriaClienteMock);


        Field solicitudesDiariasField = CategoriaServiceImpl.class.getDeclaredField("solicitudesDiarias");
        solicitudesDiariasField.setAccessible(true);
        solicitudesDiariasField.set(categoriaService, solicitudesDiarias);
    }



    @Test
    public void testGetCategorias_LimiteDiarioSuperado() {
      
        solicitudesDiarias.set(11);

        assertThrows(RuntimeException.class, () -> {
            categoriaService.getCategorias();
        });

        verifyNoInteractions(categoriaClienteMock);
    }
}
