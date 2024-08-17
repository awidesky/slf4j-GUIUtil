package io.github.awidesky.slf4j_guiUtil;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import io.github.awidesky.guiUtil.SimpleLogger;

public class GUIUtilLoggerFactory implements ILoggerFactory {

	@Override
	public Logger getLogger(String name) {
		io.github.awidesky.guiUtil.Logger logger = new SimpleLogger(System.out);
		logger.setPrefix(" [" + name + "] ");
		return new GUIUtilLoggerAdaptor(logger);
	}
	
//	private static final Pattern ptn = Pattern.compile("^GUIUtil\\.([a-zA-Z]+)");
//
//	@Override
//	public Logger getLogger(String name) {
//		System.out.println();
//		//find logger subclass name
//		io.github.awidesky.guiUtil.Logger ret = null;
//		
//		Matcher m = ptn.matcher(name);
//		if(m.find()) {
//			String className = m.group(1);
//			try {
//				Class<?> c = Class.forName("io.github.awidesky.guiUtil." + className);
//				ret = (io.github.awidesky.guiUtil.Logger) c.getDeclaredConstructors()[0].newInstance((Object[])null);//TODO
//				ret.setPrefix(" [" + m.replaceAll("") + "] ");
//				return new GUIUtilLoggerAdaptor(ret);
//			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		ret = new ConsoleLogger();
//		ret.setPrefix(" [" + name + "] ");
//		
//		return new GUIUtilLoggerAdaptor(ret);
//	}

}
