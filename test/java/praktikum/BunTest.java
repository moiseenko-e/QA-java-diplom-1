package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Random;


@RunWith(Parameterized.class)
public class BunTest {
    private  final String name;
    private  final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}: {1}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.025f},
                {"Краторная булка N-200i", 1255},
                {"Тестовая1", new Random().nextFloat()},
                {"", new Random().nextFloat()},
                {" ", new Random().nextFloat()},
                {null, new Random().nextFloat()},
                {"!№;%:?(]*", new Random().nextFloat()},
                {RandomStringUtils.randomAlphanumeric(1000), new Random().nextFloat()},
                {"Тестовая2", 0},
                {"Тестовая3", -1.0f},
                {"Тестовая4", 2/3},
        };
    }
    @Test
    public void checkName(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name,bun.getName());
    }
    @Test
    public void checkPrice(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price,bun.getPrice(),0);
    }
}
