package ${dto.packageName};

import com.lyd.common.persistence.Query;

/**
 * <#if desc??>${desc}</#if>的Query
 * @since : ${date}
 * @author : ${author}
 * @version : v0.0.1
 */
public class ${domainName}Query extends Query {

	/**
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

<#list columns as being>
	<#if being.comment??>
	/**
	 * ${being.comment}
	 */
	</#if>
	private ${being.jdbcType} ${being.propertyName};
	
</#list>
<#list columns as being>
	
	public ${being.jdbcType} ${being.getterName}(){
		return ${being.propertyName};
	}
	
	public void ${being.setterName}(${being.jdbcType} ${being.propertyName}){
		this.${being.propertyName} = ${being.propertyName};
	}
	
</#list>
	
}
