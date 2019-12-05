package com.revature.cactus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CactusTest {
	
	private static Cactus cactus;

	@Before
	public void setUp() throws Exception {
		List<Flower> startingFlowers = new ArrayList<>();
		startingFlowers.add(Flower.Hibiscus);
		cactus = new Cactus(100, 15, "Yellow", startingFlowers);
	}

	@Test
	public void testAddFlower() {
		cactus.addFlower(Flower.Sunflower);
		List<Flower> expected = new ArrayList<>();
		expected.add(Flower.Hibiscus);
		expected.add(Flower.Sunflower);
		assertEquals(expected, cactus.getFlowers());
	}

	@Test
	public void testRemoveFlower() {
		List<Flower> expected = new ArrayList<>();
		cactus.removeFlower(Flower.Hibiscus);
		assertEquals(expected, cactus.getFlowers());
	}

	@Test
	public void testGrowReturn() {
		assertEquals(new Double(101), new Double(cactus.grow(100)));
	}
	
	@Test
	public void testGrowHeight() {
		cactus.grow(100);
		assertEquals(new Double(101), new Double(cactus.getHeight()));
	}
	
	@Test
	public void testGrowWater() {
		cactus.grow(100);
		assertEquals(new Double(105), new Double(cactus.getWaterStored()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGrowException() {
		cactus.grow(-3.0);
	}

	@Test
	public void testBloom() {
		assertEquals(1, cactus.bloom());
	}

	@Test
	public void testSeeding() {
		List<Flower> childFlowers = new ArrayList<>();
		childFlowers.add(Flower.Hibiscus);
		Cactus expected = new Cactus(1, 0.15, cactus.getColor(), childFlowers);
		assertEquals(expected, cactus.seeding());
	}
}
