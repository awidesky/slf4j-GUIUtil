module io.github.awidesky.slf4j_guiUtil {
	exports io.github.awidesky.slf4j_guiUtil;
	
	requires awidesky.GUIUtil;
	requires org.slf4j;
	provides org.slf4j.spi.SLF4JServiceProvider with io.github.awidesky.slf4j_guiUtil.GUIUtilSLF4JServiceProvider;
	opens io.github.awidesky.slf4j_guiUtil to org.slf4j;
}