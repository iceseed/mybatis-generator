package ${packageName}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyd.common.persistence.Mapper;
import com.lyd.common.service.impl.BaseServiceImpl;
import ${packageName}.mapper.${domainName}Mapper;
import ${packageName}.domain.${domainName}Domain;
import ${packageName}.service.I${domainName}Service;

/**
 * <#if desc??>${desc}</#if>的业务实现类
 * @author : ${author}
 * @since : ${date}
 * @version : v0.0.1
 */
@Service("${annotationName}Service")
public class ${domainName}ServiceImpl extends BaseServiceImpl<${domainName}Domain> implements I${domainName}Service {
	
	@Resource(name = "${annotationName}Mapper")
	private ${domainName}Mapper ${annotationName}Mapper;
	
	@Override
	protected Mapper<${domainName}Domain> getMapper() {
		return ${annotationName}Mapper;
	}

}
