package com.maroon.fridge;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maroon.fridge.dto.ErrorResponse;
import com.maroon.fridge.exception.NestedException;

/**
 * Global Exception handler
 * 
 * Returns Error response to client.
 * 
 * @author Nishanth Dharmaraju
 *
 */

@Provider
public class FridgeControllerAdvice implements ExceptionMapper<Exception> {

	private static final Logger log = LoggerFactory.getLogger(FridgeControllerAdvice.class);

	@Override
	public Response toResponse(Exception exception) {

		return buildResponse(exception);
	}

	/**
	 * Returns response object with corresponding error code and description
	 * 
	 * @param exception
	 * @return
	 */
	private Response buildResponse(Exception exception) {

		ErrorResponse error = new ErrorResponse("serverError", "Internal Server Error");

		if (exception instanceof NestedException) {
			error = new ErrorResponse(((NestedException) exception).getErrorCode(),
					((NestedException) exception).getMessage());
		}
		log.info(exception.getMessage());

		return Response.serverError().entity(error).build();
	}

}
