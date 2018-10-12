package ${packageName}.mapper;

<#if extendsBase["mapper"]??>import ${extendsBase["mapper"]};</#if>
import ${packageName}.domain.${domainName}Domain;
<#if importClasses["mapper"]??>
   <#list importClasses["mapper"] as being>
import ${being};
   </#list>
</#if>

/**
 * <#if desc??>${desc}</#if>的mapper
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
public interface ${domainName}Mapper <#if extendsBase["mapper"]??>extends ${extendsBase["mapper"]?substring(extendsBase["mapper"]?last_index_of(".") +1)}<${domainName}Domain> </#if> {
	
	
}
