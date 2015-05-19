package named;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

public class nameding extends ImprovedNamingStrategy {

	@Override
	public String classToTableName(String className) {
		System.out.println(className+"public String classToTableName(String className) ");
		String s= StringHelper.unqualify(className).toUpperCase();
		return s;
	}

	@Override
	public String columnName(String columnName) {
		System.out.println(columnName+"public String columnName(String columnName)");
		return super.columnName(columnName);
	}

	@Override
	public String propertyToColumnName(String propertyName) {
		System.out.println(propertyName+"	public String propertyToColumnName(String propertyName) ");
		return  StringHelper.unqualify(propertyName).toUpperCase()+"s";
	}

	@Override
	public String tableName(String tableName) {
		System.out.println(tableName+"public String tableName(String tableName)");
		return super.tableName(tableName);
	}

}
