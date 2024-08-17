package io.github.awidesky.slf4j_guiUtil;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class GUIUtilSLF4JServiceProvider implements SLF4JServiceProvider {

	private final static ILoggerFactory loggerFactory = new GUIUtilLoggerFactory();

	@Override
	public ILoggerFactory getLoggerFactory() {
		return loggerFactory ;
	}

	/**
	 * @return {@code null} because not implemented yet
	 */
	@Override
	public IMarkerFactory getMarkerFactory() {
		// not implemented yet
		return null;
	}

	
	/**
	 * @return {@code null} because not implemented yet
	 */
	@Override
	public MDCAdapter getMDCAdapter() {
		// not implemented yet
		return null;
	}

	@Override
	public String getRequestedApiVersion() {
		return "2.0.0";
	}

	@Override
	public void initialize() {}

}
