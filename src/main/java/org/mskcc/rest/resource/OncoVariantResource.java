package org.mskcc.rest.resource;

import org.mskcc.domain.Link;
import org.mskcc.domain.OncoGene;
import org.mskcc.domain.OncoVariant;
import org.mskcc.domain.OncoVariantsResult;
import org.mskcc.service.OncoGeneService;
import org.mskcc.service.OncoVariantService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Produces({MediaType.APPLICATION_JSON})
public class OncoVariantResource {
	
	private OncoGeneService oncoGeneService;
	private OncoVariantService oncoVariantService;
	
	public OncoVariantResource(OncoGeneService oncoGeneService, OncoVariantService oncoVariantService) {
		this.oncoGeneService = oncoGeneService;
		this.oncoVariantService = oncoVariantService;
	}
	
	
	@GET
	public OncoVariantsResult getVariants(
			@PathParam("entrezGeneId") long entrezGeneId,
			@Context UriInfo uriInfo,
			@QueryParam("start") int start,
			@QueryParam("size") int size
	) {
		
		OncoGene oncoGene = oncoGeneService.get(entrezGeneId);
		List<OncoVariant> oncoVariants = null;
		if(start > 0 && size > 0) {
			oncoVariants = oncoVariantService.getVariantsPaginated(entrezGeneId, start, size);
		}else {
			oncoVariants = oncoVariantService.getVariants(entrezGeneId);
		}

		OncoVariantsResult oncoVariantsResult = new OncoVariantsResult();
		oncoVariantsResult.getOncoVariants().addAll(oncoVariants);
		
		String geneUrl = uriInfo.getBaseUriBuilder().path(OncoGeneResource.class).path(Long.toString(entrezGeneId)).build().toString();
		String variantsUrl = uriInfo.getBaseUriBuilder().path(geneUrl).build().toString();
		
		oncoVariantsResult.getLinks().add(new Link("self", variantsUrl));
		oncoVariantsResult.getLinks().add(new Link("gene", geneUrl));
		oncoGene.getLinks().add(new Link("self", geneUrl));
		oncoGene.getLinks().add(new Link("variants", variantsUrl));
		
		oncoVariantsResult.setOncoGene(oncoGene);
		
		return oncoVariantsResult;
	}
	
	
}
