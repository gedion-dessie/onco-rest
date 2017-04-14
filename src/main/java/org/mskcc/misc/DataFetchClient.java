package org.mskcc.misc;

import org.mskcc.domain.Gene;
import org.mskcc.domain.OncoGene;
import org.mskcc.domain.OncoVariant;
import org.mskcc.domain.Variant;
import org.mskcc.exception.DataNotFoundException;
import org.mskcc.rest.service.GeneRestClientService;
import org.mskcc.rest.service.VariantRestClientService;
import org.mskcc.service.OncoGeneService;
import org.mskcc.service.OncoVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gedionz on 4/14/17.
 */
@Component
public class DataFetchClient {
	
	
	@Autowired
	private OncoGeneService oncoGeneService;
	
	@Autowired
	private OncoVariantService oncoVariantService;
	
	@Autowired
	private GeneRestClientService geneRestClientService;
	
	@Autowired
	private VariantRestClientService variantRestClientService;
	
	@Autowired
	private MessageReader messageReader;
	
	
	public DataFetchClient() {
		
	}
	
	public void loadGenes() {
		List<Gene> genes = geneRestClientService.getGenes(messageReader.getMessage("remoteApi.genes_url"));
		genes.forEach(gene -> {
			if(gene.isOncogene()) {
				OncoGene oncoGene = null;
				try {
					oncoGene = oncoGeneService.get(gene.getEntrezGeneId());
				} catch(DataNotFoundException exception) {
					//We can simply catch and ignore this exception at this line
					System.out.println(exception.getLocalizedMessage());
				}
				if(oncoGene == null) {
					oncoGene = geneConverter(gene);
					oncoGeneService.save(oncoGene);
				}
				loadVariantsOfGene(oncoGene);
			}
		});
	}
	
	private void loadVariantsOfGene(OncoGene oncoGene) {
		
		List<Variant> variants = variantRestClientService.getVariants(
				messageReader.getMessage(
						"remoteApi.variants_url",
						new Object[]{
								Long.toString(oncoGene.getEntrezGeneId())
						}
				)
		);
		variants.forEach(variant -> {
			OncoVariant oncoVariant = oncoVariantService.getByAlteration(variant.getAlteration());
			if(oncoVariant == null) {
				oncoVariant = variantConverter(variant);
				oncoVariant.setOncoGene(oncoGene);
				oncoVariantService.save(oncoVariant);
			}
		});
	}
	
	private OncoGene geneConverter(Gene gene) {
		OncoGene oncoGene = new OncoGene();
		oncoGene.setEntrezGeneId(gene.getEntrezGeneId());
		oncoGene.setHugoSymbol(gene.getHugoSymbol());
		oncoGene.getGeneAliases().addAll(gene.getGeneAliases());
		return oncoGene;
	}
	
	private OncoVariant variantConverter(Variant variant) {
		OncoVariant oncoVariant = new OncoVariant();
		oncoVariant.setAlteration(variant.getAlteration());
		oncoVariant.setConsequence(variant.getConsequence().getTerm());
		oncoVariant.setGenerallyTruncating(variant.getConsequence().isGenerallyTruncating());
		return oncoVariant;
	}
	
}
