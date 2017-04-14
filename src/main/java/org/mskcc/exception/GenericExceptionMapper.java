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
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	@Autowired
	private MessageReader messageReader;
	
	@Override
	public Response toResponse(Throwable throwable) {
		ErrorMessage errorMessage = new ErrorMessage(throwable.getMessage(), 500, messageReader.getMessage("documentation.url"));
		return Response
				.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}
}
