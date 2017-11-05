
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import com.google.common.collect.Iterables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.iwcn.master.entities.Product;
import com.iwcn.master.repositories.ProductRepository;
import com.iwcn.master.services.ProductDataBase;


@RunWith(SpringRunner.class)
public class ProductDBTesting {

	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductDataBase productDB;
	
	@Before
	public void Init() {
		productDB=new ProductDataBase();
		MockitoAnnotations.initMocks(this);
	}
	
	public void TestSingleProduct(Product testProduct)
	{
		when(productRepository.findOne(anyLong())).then(answer ->{return testProduct;});
		//Pruebo los productos usando sus Gets, para que la prueba sea del Servicio, no de Product
		Assert.assertEquals("wrong Name", testProduct.getName(),productDB.GetProduct(1).getName());
		Assert.assertEquals("wrong Price", testProduct.getPrice(),productDB.GetProduct(1).getPrice(),0.01);
		Assert.assertEquals("wrong Description", testProduct.getDescription(),productDB.GetProduct(1).getDescription());
		Assert.assertEquals("wrong Size", testProduct.getSize(),productDB.GetProduct(1).getSize());
		Assert.assertEquals("wrong Origin", testProduct.getOrigin(),productDB.GetProduct(1).getOrigin());
		Assert.assertEquals("wrong Year in Lot", testProduct.getYearLot(),productDB.GetProduct(1).getYearLot());
		Assert.assertEquals("wrong Month in Lot", testProduct.getMonthLot(),productDB.GetProduct(1).getMonthLot());
		Assert.assertEquals("worng Day in Lot", testProduct.getDayLot(),productDB.GetProduct(1).getDayLot());
		Assert.assertEquals("wrong Lot writing", testProduct.writeLot(),productDB.GetProduct(1).writeLot());
		Assert.assertEquals("wrong Id reading", testProduct.getId(),productDB.GetProduct(1).getId());
	}
	
	@Test
	public void TestGetSingleProduct() {
		Product testProduct = new Product("Ordenador", 123, "Bonito", "Med", "USA",	2017, 11, 5);
		TestSingleProduct(testProduct);
	}
	
	@Test
	public void TestGetAllProducts() {
		Product testProduct = new Product("Ordenador", 123, "Bonito", "Med", "USA",	2017, 11, 5);
		Product testProduct2 = new Product("Peine", 11, "Azul", "Peq", "Francia",	2016, 6, 21);
		List<Product> testProducts = new ArrayList<>();
		when(productRepository.findAll()).then(answer -> {return testProducts;});
		testProducts.add(testProduct);
		testProducts.add(testProduct2);
		//Paso las pruebas de cada producto, para comprobar que sigue funcionando para todos los elementos de la lista
		this.TestSingleProduct(testProduct);
		this.TestSingleProduct(testProduct2);
		//Compruebo tamaño de la lista:
		Assert.assertEquals("wrong list size", 2,Iterables.size(this.productDB.GetAll()));
		//Compruebo que cada producto pase el testing individual:
		StreamSupport.stream(this.productDB.GetAll().spliterator(), false).forEach(streamProduct ->{
			this.TestSingleProduct(streamProduct);
		});
	}
	
}
