<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.mapper.${domainName}Mapper" >
  
    <!-- 公共查询语句 -->
	<sql id="selectSql">
		select 
		    <trim suffixOverrides="," >
		    <#list columns as being>
		    	a.`${being.name}` as '${being.propertyName}',
		    </#list>
		    </trim>
	   	from 
	    	`${tableName}` as a
	</sql>
  
</mapper>