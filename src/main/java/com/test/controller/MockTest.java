package com.test.controller;

import com.test.model.Product;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {
    @MockBean
    private ProductService productService = null;

    @Test
    public void testGetProduct() {
        // 构建虚拟对象
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setProductName("ProductName" + 1);
        mockProduct.setNote("Note" + 1);
        // 指定MockBean方法、参数
        BDDMockito.given(this.productService.getProduct(1L))
                // 指定返回的虚拟对象
                 .willReturn(mockProduct);
        // Mock测试
        Product product = productService.getProduct(1L);
        Assert.assertEquals(product.getId, 1L);
    }
}
