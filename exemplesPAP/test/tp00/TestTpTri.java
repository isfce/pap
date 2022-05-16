package tp00;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestTpTri {

	@Test
	void testTriInsertion() {
		int[] v0 = { 1 };
		TpTri.triInsertion(v0);
		assertArrayEquals(v0, v0);

		int[] v1 = { 8, 7, 4, 1, 9, 2 };
		int[] v1R = { 1, 2, 4, 7, 8, 9 };
		TpTri.triInsertion(v1);
		assertArrayEquals(v1R, v1);

		int[] v2 = { 9, 4, 1 };
		int[] v2R = { 1, 4, 9 };
		TpTri.triInsertion(v2);
		assertArrayEquals(v2R, v2);
	}

	@Test
	void testTriBullesV1() {
		int[] v0 = { 1 };
		TpTri.triBulles(v0);
		assertArrayEquals(v0, v0);

		int[] v1 = { 8, 7, 4, 1, 9, 2 };
		int[] v1R = { 1, 2, 4, 7, 8, 9 };
		TpTri.triBulles(v1);
		assertArrayEquals(v1R, v1);

		int[] v2 = { 9, 4, 1 };
		int[] v2R = { 1, 4, 9 };
		TpTri.triBulles(v2);
		assertArrayEquals(v2R, v2);
	}

	@Test
	void testTriBullesV2() {
		List<Integer> l0 = new ArrayList<>();
		l0.add(1);
		TpTri.triBullesV2(l0);
		assertEquals(List.of(1), l0);

		List<Integer> l1 = new ArrayList<>();
		l1.addAll(List.of(8, 7, 4, 1, 9, 2));
		List<Integer> l1T = List.of(1, 2, 4, 7, 8, 9);
		TpTri.triBullesV2(l1);
		assertEquals(l1T, l1);

		List<Integer> l2 = new ArrayList<>();
		l2.addAll(List.of(9, 4, 1));
		List<Integer> l2T = List.of(1, 4, 9);
		TpTri.triBullesV2(l2);
		assertEquals(l2T, l2);

		List<Integer> l3 = new ArrayList<>();
		TpTri.triBullesV2(l3);
		assertEquals(Collections.EMPTY_LIST, l3);
	}
	@Test
	void test_estTrie() {
		int[] v0 = {1};
		assertTrue(TpTri.estTrie(v0));
		int[] v0_1 = {};
		assertTrue(TpTri.estTrie(v0_1));
		int[] v1 = { 1, 2, 4, 7, 8, 9 };
		assertTrue(TpTri.estTrie(v1));
		int[] v2 = { 2, 1, 4, 7, 8, 9 };
		assertFalse(TpTri.estTrie(v2));
		int[] v3 = { 1, 1, 4, 7, 18, 9 };
		assertFalse(TpTri.estTrie(v3));
	}
	
}
