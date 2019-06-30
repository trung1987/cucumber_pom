package interfaces;

public class PageDetailInterface {
	public static String DataUserId = "//td[contains(text(),'ID')]/./following-sibling::td";
	public static String DataPass = "//td[contains(text(),'Password')]/./following-sibling::td";
	public static String DetailText= "//h2[contains(text(),'Access details to demo site.')]";
	
	public static String XpathDynamic_DetailPage= "//td[contains(text(),'%s')]/./following-sibling::td";
}
