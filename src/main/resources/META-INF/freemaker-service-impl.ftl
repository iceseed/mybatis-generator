package ${packageName}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<#if extendsBase["serviceImpl"]??>import ${extendsBase["serviceImpl"]};</#if>
import ${packageName}.mapper.${domainName}Mapper;
import ${packageName}.domain.${domainName}Domain;
import ${packageName}.service.I${domainName}Service;
<#if importClasses["serviceImpl"]??>
    <#list importClasses["serviceImpl"] as being>
import ${being};
    </#list>
</#if>

/**
 * <#if desc??>${desc}</#if>的业务实现类
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("${annotationName}Service")
public class ${domainName}ServiceImpl <#if extendsBase["serviceImpl"]??>extends ${extendsBase["serviceImpl"]?substring(extendsBase["serviceImpl"]?last_index_of(".") +1)}<${domainName}Domain></#if> implements I${domainName}Service {
	
	@Autowired
	private ${domainName}Mapper ${annotationName}Mapper;
	  
}
