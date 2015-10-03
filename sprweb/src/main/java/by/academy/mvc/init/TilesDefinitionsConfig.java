//package by.academy.mvc.init;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.tiles.Attribute;
//import org.apache.tiles.Definition;
//import org.apache.tiles.context.TilesRequestContext;
//import org.apache.tiles.definition.Definitions;
//import org.apache.tiles.definition.DefinitionsFactory;
//
//
//public final class TilesDefinitionsConfig implements DefinitionsFactory {
//
//	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
//	private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/pages/layout/defaultLayout.jsp");
//	
//	@Override
//	public Definition getDefinition(String name, TilesRequestContext tilesContext) {
//		return tilesDefinitions.get(name);
//	}
//
//	
////	@Override
////	public Definition getDefinition(String name, Request tilesContext) {
////		return tilesDefinitions.get(name);
////	}
//
//
//	private static void addDefaultLayoutDef(String name, String title, String body) {
//		Map<String, Attribute> attributes = new HashMap<String, Attribute>();
//
//		attributes.put("title", new Attribute(title));
//		attributes.put("header", new Attribute("/WEB-INF/pages/layout/header.jsp"));
//		attributes.put("body", new Attribute(body));
//		attributes.put("footer", new Attribute("/WEB-INF/pages/layout/footer.jsp"));
//
//		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
//	}
//
//	public static void addDefinitions() {
//		addDefaultLayoutDef("home", "Home", "/WEB-INF/pages/home.jsp");
//	}
//
//
//	
//
//	@Override
//	public void init(Map<String, String> arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public Definitions readDefinitions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public void addSource(Object arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//}
