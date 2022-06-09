package tp00;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestMyMath {
	@Test
	void testFactorielle() {
		assertEquals(120, MyMath.factorielle(5));
		assertEquals(1, MyMath.factorielle(0));
		assertEquals(1, MyMath.factorielle(1));
		assertEquals(2, MyMath.factorielle(2));
		assertThrows(AssertionError.class, () -> MyMath.factorielle(-1));
		assertThrows(AssertionError.class, () -> MyMath.factorielle(21));
	}
	
	@Test
	void testFiboR() {
		assertEquals(5, MyMath.fibo(5));
		assertEquals(8, MyMath.fibo(6));
		assertEquals(1, MyMath.fibo(1));
		assertEquals(0, MyMath.fibo(0));
		assertThrows(AssertionError.class, () -> MyMath.fibo(-1));
	}
@Test
	void testFactorielleR() {
		assertEquals(120, MyMath.factorielleR(5));
		assertEquals(1, MyMath.factorielleR(0));
		assertEquals(1, MyMath.factorielleR(1));
		assertEquals(2, MyMath.factorielleR(2));
		assertThrows(AssertionError.class, () -> MyMath.factorielleR(-1));
		assertThrows(AssertionError.class, () -> MyMath.factorielleR(21));
	}
	@Test
	void testPower1() {
		assertEquals(1.0, MyMath.power(0.0, 0));
		assertEquals(1, MyMath.power(-1, 0));
		assertEquals(0, MyMath.power(0.0, 4));
		assertEquals(4, MyMath.power(4.0, 1));
		assertEquals(-8.0, MyMath.power(-2.0, 3));
		assertEquals(4.0, MyMath.power(-2.0, 2));
		assertEquals(125, MyMath.power(5.0, 3));
		assertEquals(2.5961484292674138E33, MyMath.power(2, 111));
		assertThrows(AssertionError.class, () -> MyMath.power(0, -1));
	}

	@Test
	void testPgcd() {
		assertEquals(3, MyMath.pgcd(15, 9));
		assertEquals(3, MyMath.pgcd(9, 15));
		assertEquals(10, MyMath.pgcd(10, 10));
		assertEquals(1, MyMath.pgcd(17, 31));
		assertThrows(AssertionError.class, () -> MyMath.pgcd(0, -1));
		assertThrows(AssertionError.class, () -> MyMath.pgcd(-4, 0));
	}

	@Test
	void testNbUn() {
		assertEquals(0, MyMath.nbUn(0));
		assertEquals(1, MyMath.nbUn(1));
		assertEquals(1, MyMath.nbUn(8));
		assertEquals(8, MyMath.nbUn(255));
		assertEquals(64, MyMath.nbUn(-1));
	}

	@Test
	void testPower2() {
		assertEquals(1.0, MyMath.power2(0.0, 0));
		assertEquals(1, MyMath.power2(-1, 0));
		assertEquals(0, MyMath.power2(0.0, 4));
		assertEquals(4, MyMath.power2(4.0, 1));
		assertEquals(-8.0, MyMath.power2(-2.0, 3));
		assertEquals(4.0, MyMath.power2(-2.0, 2));
		assertEquals(125, MyMath.power2(5.0, 3));
		assertEquals(2.5961484292674138E33, MyMath.power2(2, 111));
		assertThrows(AssertionError.class, () -> MyMath.power2(0, -1));
	}

	@Test
	void testPower3() {
		assertEquals(1.0, MyMath.power3(0.0, 0));
		assertEquals(1, MyMath.power3(-1, 0));
		assertEquals(0, MyMath.power3(0.0, 4));
		assertEquals(4, MyMath.power3(4.0, 1));
		assertEquals(-8.0, MyMath.power3(-2.0, 3));
		assertEquals(4.0, MyMath.power3(-2.0, 2));
		assertEquals(125, MyMath.power3(5.0, 3));
		assertEquals(2.5961484292674138E33, MyMath.power3(2, 111));
		assertThrows(AssertionError.class, () -> MyMath.power3(0, -1));
	}

	@Test
	void testUtf8() {
		assertEquals(1, MyMath.nbBytesUtf8('A'));
		assertEquals(2, MyMath.nbBytesUtf8('é'));
		assertEquals(3, MyMath.nbBytesUtf8('€'));
	}

	@Test
	void testPremier() {
		assertEquals(true, MyMath.estPremier(2));
		assertEquals(true, MyMath.estPremier(3));
		assertEquals(true, MyMath.estPremier(5));
		assertEquals(true, MyMath.estPremier(7));
		assertEquals(true, MyMath.estPremier(11));
		assertEquals(true, MyMath.estPremier(131));
		assertEquals(false, MyMath.estPremier(4));
		assertEquals(false, MyMath.estPremier(9));
		assertEquals(false, MyMath.estPremier(25));
		assertThrows(AssertionError.class, () -> MyMath.estPremier(1));
	}

}
