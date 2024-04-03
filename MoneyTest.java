package fr.emse.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class MoneyTest {
	private Money m12CHF;
	private Money m14CHF;
	
	@Test
	public void testSimpleAdd() {
		
		Money expected = new Money(26, "CHF");
		Money result = (Money) m12CHF.add(m14CHF); // exécution de la méthode testée
		assertTrue(expected.equals(result)); // comparaison
	}

	@Test
	public void testEquals() {
		
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	@Before
	public void setUp() {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14,"CHF");
		
	}
}
