package ${packageName}.service;

<#if extendsBase["service"]??>import ${extendsBase["service"]};</#if>
import ${packageName}.domain.${domainName}Domain;
<#if importClasses["service"]??>
   <#list importClasses["service"] as being>
import ${being};
   </#list>

</#if>

/**
 * <#if desc??>${desc}</#if>的业务层接口
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
public interface I${domainName}Service <#if extendsBase["service"]??>extends ${extendsBase["service"]?substring(extendsBase["service"]?last_index_of(".") +1)}<${domainName}Domain> </#if>{

}
