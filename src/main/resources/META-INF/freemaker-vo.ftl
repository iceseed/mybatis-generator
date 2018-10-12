package ${vo.packageName};

<#if extendsBase["vo"]??>import ${extendsBase["vo"]};</#if>
<#if importClasses["vo"]??>
	<#list importClasses["vo"] as being>
import ${being};
	</#list>

</#if>


/**
 * <#if desc??>${desc}</#if>的Vo
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
public class ${domainName}VO <#if extendsBase["vo"]??>extends ${extendsBase["vo"]?substring(extendsBase["vo"]?last_index_of(".") +1)} </#if>{

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
