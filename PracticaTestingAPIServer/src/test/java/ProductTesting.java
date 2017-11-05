import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.iwcn.master.entities.Product;

@RunWith(SpringRunner.class)
public class ProductTesting {

	@Test
	public void TestProductConstructor() {
		//Compruebo el constructor
		Product testProduct = new Product("Ordenador", 123, "Bonito", "Med", "USA",	2017, 11, 5);
		Assert.assertEquals("wrong Name", testProduct.getName(),"Ordenador");
		Assert.assertEquals("wrong Price", testProduct.getPrice(),123,0.01);
		Assert.assertEquals("wrong Description", testProduct.getDescription(),"Bonito");
		Assert.assertEquals("wrong Size", testProduct.getSize(),"Med");
		Assert.assertEquals("wrong Origin", testProduct.getOrigin(),"USA");
		Assert.assertEquals("wrong Year in Lot", testProduct.getYearLot(),2017);
		Assert.assertEquals("wrong Month in Lot", testProduct.getMonthLot(),11);
		Assert.assertEquals("worng Day in Lot", testProduct.getDayLot(),5);
		Assert.assertEquals("wrong Lot writing", testProduct.writeLot(),"5-11-2017");
	}
}
