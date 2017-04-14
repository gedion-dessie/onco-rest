package org.mskcc.rest.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mskcc.domain.OncoGene;
import org.mskcc.service.OncoGeneService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.mockito.BDDMockito.given;

/**
 * Created by gedionz on 4/14/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OncoGeneResourceIntegrationTest {
	

	
	@MockBean
	private OncoGeneService oncoGeneService;
	
	@Before
	public void setup() {
		OncoGene oncoGene = new OncoGene();
		oncoGene.setEntrezGeneId(90);
		oncoGene.setHugoSymbol("ACVR1");
		given(this.oncoGeneService.get(90)).willReturn(oncoGene);
	}
	
	@Test
	public void getOncoGenes() throws Exception {
		Assert.notNull(oncoGeneService.getAll(), "This should never be null!");
	}
	
	@Test
	public void getOncoGene() throws Exception {

	}
	
	@Test
	public void getVariants() throws Exception {
		
	}
	
}