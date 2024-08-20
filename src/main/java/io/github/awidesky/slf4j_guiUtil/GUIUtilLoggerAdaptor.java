package io.github.awidesky.slf4j_guiUtil;

import org.slf4j.Marker;
import org.slf4j.event.Level;

import io.github.awidesky.guiUtil.StringLogger;

public class GUIUtilLoggerAdaptor extends org.slf4j.helpers.AbstractLogger {

	private static final long serialVersionUID = -1919571936539183582L;
	
	transient final io.github.awidesky.guiUtil.Logger logger;
	transient final StringLogger sl = new StringLogger();
	
	GUIUtilLoggerAdaptor(io.github.awidesky.guiUtil.Logger logger) {
        this.logger = logger;
        sl.setPrintLogLevel(false);
    }

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return isTraceEnabled();
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return isInfoEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarningEnabled();
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return isWarnEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return isErrorEnabled();
	}

	@Override
	protected String getFullyQualifiedCallerName() {
		return GUIUtilLoggerAdaptor.class.getName();
	}

	@Override
	protected void handleNormalizedLoggingCall(Level level, Marker marker, String messagePattern, Object[] arguments,
			Throwable throwable) {
		sl.info(messagePattern, arguments);
		if(throwable != null) sl.info(throwable);
		logger.logInLevel(toGUIUtilLevel(level), sl.getString().stripTrailing());
	}

	private io.github.awidesky.guiUtil.level.Level toGUIUtilLevel(Level level) {
		switch (level) {
		case ERROR:
			return io.github.awidesky.guiUtil.level.Level.ERROR;
		case WARN:
			return io.github.awidesky.guiUtil.level.Level.WARNING;
		case INFO:
			return io.github.awidesky.guiUtil.level.Level.INFO;
		case DEBUG:
			return io.github.awidesky.guiUtil.level.Level.DEBUG;
		case TRACE:
			return io.github.awidesky.guiUtil.level.Level.TRACE;
		}
		return io.github.awidesky.guiUtil.level.Level.FATAL;
	}


}
