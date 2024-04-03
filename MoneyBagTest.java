package fr.emse.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyBagTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @BeforeEach
    public void setUp() {
        f12CHF= new Money(12, "CHF");
        f14CHF= new Money(14, "CHF");
        f7USD= new Money( 7, "USD");
        f21USD= new Money(21, "USD");
        fMB1= new MoneyBag(f12CHF, f7USD);
        fMB2= new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertTrue(!fMB1.equals(f12CHF));
        assertTrue(!f12CHF.equals(fMB1));
        assertTrue(!fMB1.equals(fMB2));
    }
    @Test
    public void testMixedSimpleAdd() {
    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
    Money bag[] = { f12CHF, f7USD };
    MoneyBag expected = new MoneyBag(bag);
    assertEquals(expected, f12CHF.add(f7USD));
    }
    @Test
    public void testBagSimpleAdd() {
        // Créer un MoneyBag contenant f12CHF et f7USD
    	Money bag[] = { f12CHF, f7USD ,f14CHF};
        // Ajouter un simple Money (f14CHF) à ce MoneyBag
        MoneyBag expected = new MoneyBag(bag);
        // Résultat attendu : MoneyBag contenant f12CHF, f7USD et f14CHF
        assertEquals(expected, fMB1.add(f14CHF));
    }

    @Test
    public void testSimpleBagAdd() {
    	Money bag[] = {f12CHF,f7USD, new Money(10,"EUR")};
		MoneyBag expected = new MoneyBag(bag);
		assertTrue(expected.equals(new Money(10,"EUR").add(fMB1)));
    }

    @Test
    public void testBagBagAdd() {
    	Money bag[] = {f12CHF,f7USD, f14CHF, f21USD};
		MoneyBag expected = new MoneyBag(bag);
		assertEquals(expected,fMB1.add(fMB2));
    }
    @Test
	public void testSimplifyMoneyBag() {
		
		MoneyBag moneyBag = new MoneyBag(new Money(12, "CHF"));
		IMoney result = moneyBag.add(new Money(-12, "CHF"));
		assertTrue(result instanceof Money);
		assertEquals(new Money(0, "CHF"), result);  
	}
}


