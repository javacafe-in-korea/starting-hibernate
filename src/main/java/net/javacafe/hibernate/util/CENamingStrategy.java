package net.javacafe.hibernate.util;

import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class CENamingStrategy extends ImprovedNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String classToTableName(String className) {
		return StringHelper.unqualify(className);
	}
	
	public String propertyToColumnName(String propertyName) {
		return propertyName;
	}
	
	public String tableName(String tableName) {
		return "CE_"+tableName;
	}
	
	public String propertyToTable(String className, String propertyName) {
		return "CE_" + classToTableName(className) + '_' + propertyToColumnName(propertyName);
	}
}
