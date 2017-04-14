package org.mskcc.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mskcc.domain.OncoGene;
import org.mskcc.service.OncoGeneService;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * Created by gedionz on 4/13/17.
 */
public class OncoGeneServiceImplTest {
	
	private OncoGeneService oncoGeneService;
	
	@Before
	public void setUp() throws Exception {
		oncoGeneService = Mockito.mock(OncoGeneService.class);
	}
	
	@Test
	public void getAll() throws Exception {
		Mockito.when(oncoGeneService.getAll()).thenReturn(new ArrayList<>());
		Assert.notNull(oncoGeneService.getAll(), "This shouldn't be null");
	}
	
	@Test
	public void get() throws Exception {
		Mockito.when(oncoGeneService.get(123)).thenReturn(new OncoGene());
		Assert.isInstanceOf(OncoGene.class, oncoGeneService.get(123));
		Assert.notNull(oncoGeneService.get(123), "Should be equal");
		
	}
	
	@Test
	public void save() throws Exception {
		
	}
	
	@Test
	public void remove() throws Exception {
		
	}
	
	
	@Test
	public void update() throws Exception {
		
	}
	
}