package io.github.awidesky.slf4j_guiUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Logger logger = LoggerFactory.getLogger(Test.class);
		logger.info("Hello, World!");
		logger.info("Logger type : %s", logger.getClass().getName());
		logger.info("Inner Logger instance class : " + getLogger(logger));
		logger.info("Test exception message", new RuntimeException("Exception for test"));
		assertEquals(GUIUtilLoggerAdaptor.class, logger.getClass());
	}
	
	private String getLogger(org.slf4j.Logger logger) {
	    try {
	        final Field fields[] = logger.getClass().getDeclaredFields();
	        for (int i = 0; i < fields.length; i++) {
	            final String fieldName = fields[i].getName();
	            if (fieldName.equals("logger")) {
	                fields[i].setAccessible(true);
	                return fields[i].get(logger).getClass().getName();
	            }
	        }
	    } catch (final Exception e) {
	        logger.error(e.getMessage());
	    }
	    return null;
	}
}
