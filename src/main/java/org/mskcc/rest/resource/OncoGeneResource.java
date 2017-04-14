package org.mskcc.rest.resource;

import org.mskcc.domain.Link;
import org.mskcc.domain.OncoGene;
import org.mskcc.service.OncoGeneService;
import org.mskcc.service.OncoVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Component
@Path("/oncogenes")
@Produces({MediaType.APPLICATION_JSON})
public class OncoGeneResource {
	
	@Autowired
	private OncoGeneService oncoGeneService;
	
	@Autowired
	private OncoVariantService oncoVariantService;
	
	@GET
	public List<OncoGene> getOncoGenes(
			@Context UriInfo uriInfo,
			@QueryParam("start") int start,
			@QueryParam("size") int size
	) {
		
		List<OncoGene> oncoGenes = null;
		if(start > 0 && size > 0) {
			oncoGenes = oncoGeneService.getAllPaginated(start, size);
		}else {
			oncoGenes = oncoGeneService.getAll();
		}
		oncoGenes.forEach(oncoGene -> {
			addLinks(oncoGene.getEntrezGeneId(), uriInfo, oncoGene);
		});
		return oncoGenes;
	}
	
	@GET
	@Path("/{entrezGeneId}")
	public OncoGene getOncoGene(@PathParam("entrezGeneId") long entrezGeneId, @Context UriInfo uriInfo) {
		OncoGene oncoGene = oncoGeneService.get(entrezGeneId);
		addLinks(entrezGeneId, uriInfo, oncoGene);
		return oncoGene;
	}

	
	@Path("/{entrezGeneId}/variants")
	public OncoVariantResource getVariants() {
		return new OncoVariantResource(oncoGeneService, oncoVariantService);
	}
	
	private void addLinks(long entrezGeneId, UriInfo uriInfo, OncoGene oncoGene) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(this.getClass()).path(Long.toString(entrezGeneId)).build().toString();
		oncoGene.getLinks().add(new Link("self", uri));
		oncoGene.getLinks().add(new Link("variants", uri + "/variants"));
	}
	
}
