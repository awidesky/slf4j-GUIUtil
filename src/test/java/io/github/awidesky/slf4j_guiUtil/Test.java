package io.github.awidesky.slf4j_guiUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		Logger logger = LoggerFactory.getLogger(Test.class);
		logger.info("Logger type : %s", logger.getClass().getName());
		logger.info("Hello, World!");
		logger.info("Test exception message", new RuntimeException("Exception for test"));
		assertEquals(GUIUtilLoggerAdaptor.class, logger.getClass());
	}

}
