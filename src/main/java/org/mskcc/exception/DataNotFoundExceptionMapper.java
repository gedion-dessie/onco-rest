package org.mskcc.exception;

import org.mskcc.domain.ErrorMessage;
import org.mskcc.misc.MessageReader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by gedionz on 4/14/17.
 */
@Provider
public class DataNotFoundExceptionMapper  implements ExceptionMapper<DataNotFoundException> {
	
	@Autowired
	private MessageReader messageReader;
	
	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, messageReader.getMessage("documentation.url"));
		return Response.status(Response.Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
