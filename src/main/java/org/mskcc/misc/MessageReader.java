package org.mskcc.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by gedionz on 4/14/17.
 */
@Component
public class MessageReader {
	
	@Autowired
	private MessageSource messageSource;
	
	private MessageSourceAccessor messageSourceAccessor;
	
	@PostConstruct
	private void init() {
		messageSourceAccessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
	}
	
	public String getMessage(String code) {
		return messageSourceAccessor.getMessage(code);
	}
	
	public String getMessage(String code, Object[] args) {
		return messageSourceAccessor.getMessage(code, args);
	}
}
