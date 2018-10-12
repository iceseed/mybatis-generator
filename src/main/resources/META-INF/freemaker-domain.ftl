package ${packageName}.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
<#if extendsBase["domain"]??>import ${extendsBase["domain"]};</#if>
<#if importClasses["domain"]??>
	<#list importClasses["domain"] as being>
import ${being};
	</#list>

</#if>

/**
 * <#if desc??>${desc}</#if>的domain
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */

@Data
@NoArgsConstructor
@Table(name = "${tableName}")
public class ${domainName}Domain <#if extendsBase["domain"]??>extends ${extendsBase["domain"]?substring(extendsBase["domain"]?last_index_of(".") +1)} </#if>implements Serializable {

	private static final long serialVersionUID = 1L;
	
<#list columns as being>
	<#if being.comment??>
	/*${being.comment}*/
	</#if>
	<#if primaryKey.columnName == being.name>
	@Id
	</#if>
	private ${being.jdbcType} ${being.propertyName};
	
</#list>

}
