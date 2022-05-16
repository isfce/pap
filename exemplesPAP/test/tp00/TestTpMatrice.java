package tp00;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTpMatrice {

	@Test
	void testInitMat1() {
		int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] m2 = new int[2][3];
		TpMatrice.initMat1(m2);
		assertArrayEquals(m1, m2);
	}

	@Test
	void testEstSymetrique() {
		int[][] m0 = { { 1 } };
		assertTrue(TpMatrice.estSymetrique(m0));
		int[][] m1 = { { 1, 2 }, { 2, 1 } };
		assertTrue(TpMatrice.estSymetrique(m1));
		int[][] m2 = { { 1, 2, 3 }, { 2, 1, 4 }, { 3, 4, 1 } };
		assertTrue(TpMatrice.estSymetrique(m2));
		int[][] m3 = { { 1, 8 }, { 2, 1 } };
		assertFalse(TpMatrice.estSymetrique(m3));
		int[][] m4 = { { 1, 2, 3 }, { 2, 1, 4 }, { 3, 6, 1 } };
		assertFalse(TpMatrice.estSymetrique(m4));

	}

}
