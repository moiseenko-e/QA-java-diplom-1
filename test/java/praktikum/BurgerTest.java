package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Burger burger = new Burger();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient,ingredient1,ingredient2;

    @Test
    public void checkSetBunAddTest(){
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("bun");
        assertEquals("bun",burger.bun.getName());
    }

    @Test
    public void checkSetIngredientAddTest(){
        burger.addIngredient(ingredient);
        when(ingredient.getName()).thenReturn("ingredient");
        assertEquals("ingredient",burger.ingredients.get(burger.ingredients.size() - 1).getName());
    }

    @Test
    public void checkRemoveIngredientsTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(1);

        assertEquals(2,burger.ingredients.size());
        assertEquals(ingredient2,burger.ingredients.get(1));
    }

    @Test
    public void checkMoveIngredientsTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        burger.moveIngredient(0,1);

        assertEquals(ingredient,burger.ingredients.get(1));
        assertEquals(ingredient1,burger.ingredients.get(0));
    }

    @Test
    public void checkGetPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        when(bun.getPrice()).thenReturn(10F);
        when(ingredient.getPrice()).thenReturn(1.5F);
        when(ingredient1.getPrice()).thenReturn(0F);

        assertEquals(21.5F,burger.getPrice(),0);
    }

    @Test
    public void checkGetReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        when(bun.getName()).thenReturn("bun");
        when(ingredient.getName()).thenReturn("ingredient");
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient1.getType()).thenReturn(FILLING);
        when(burger.getPrice()).thenReturn(21.50F);

        assertEquals(
                "(==== bun ====)\r\n" +
                        "= sauce ingredient =\r\n" +
                        "= filling ingredient1 =\r\n" +
                        "(==== bun ====)\r\n" +
                        "\r\nPrice: 21,500000\r\n",
                burger.getReceipt()
        );
    }
}
