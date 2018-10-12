package ${dto.packageName};

import tk.mybatis.mapper.entity.Example;
import ${packageName}.domain.${domainName}Domain;
<#if extendsBase["dto"]??>import ${extendsBase["dto"]};</#if>
<#if importClasses["dto"]??>
	<#list importClasses["dto"] as being>
import ${being};
	</#list>
</#if>


/**
 * <#if desc??>${desc}</#if>的Query
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
public class ${domainName}Query <#if extendsBase["dto"]??>extends ${extendsBase["dto"]?substring(extendsBase["dto"]?last_index_of(".") +1)} </#if>{
	
	@Override
	public QueryCriteria toCriteria() {
		QueryCriteria queryCriteria = new QueryCriteria(${domainName}Domain.class);
		Example.Criteria criteria = queryCriteria.createCriteria();
		
		//todo 写查询逻辑
		
		return queryCriteria;
	}

}
