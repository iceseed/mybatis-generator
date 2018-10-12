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
  
  	<!--根据主键查询-->
  	<select id="getByPrimaryKey" parameterType="java.lang.${primaryKey.jdbcType}" resultType="${packageName}.domain.${domainName}Domain" >
		<include refid="selectSql" />
	    where 
			a.`${primaryKey.columnName}` = ${r'#'}{${primaryKey.propertyName}}	    		
  	</select>
  
  	<!--根据主键删除-->
  	<delete id="deleteByPrimaryKey" parameterType="java.lang.${primaryKey.jdbcType}" >
    	delete from 
    		`${tableName}` 
    	where 
    		`${primaryKey.columnName}` = ${r'#'}{${primaryKey.propertyName}}
  	</delete>
  
  	<!--新增-->
  	<insert id="insert" parameterType="${packageName}.domain.${domainName}Domain" >
    <#if primaryKey.identity>
    	<selectKey resultType="java.lang.${primaryKey.jdbcType}" keyProperty="${primaryKey.propertyName}" order="AFTER" >
      		SELECT LAST_INSERT_ID()
    	</selectKey>
    </#if>
    insert into `${tableName}` 
    <trim prefix="(" suffix=")" suffixOverrides="," >
      	<#list columns as being>
      	<if test="${being.propertyName} != null" >
	      `${being.name}`,
	  	</if>
	  	</#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
    	<#list columns as being>
    	<if test="${being.propertyName} != null" >
        	${r'#'}{${being.propertyName}},
      	</if>
    	</#list>
    </trim>
  	</insert>
  
    <!-- 批量新增 -->
	<insert id="insertBatch" parameterType="java.util.List">
		<#if primaryKey.identity>
		<selectKey resultType="java.lang.${primaryKey.jdbcType}" keyProperty="${primaryKey.propertyName}"
			order="AFTER">
			SELECT LAST_INSERT_ID()
		</selectKey>
		</#if>
		insert into `${tableName}`
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<#list columns as being>
				<#if primaryKey.identity>
					<#if primaryKey.propertyName != being.propertyName>
						`${being.name}`,
					</#if>
				<#else>
					`${being.name}`,
				</#if>
    		</#list>
		</trim>
		values 
		<foreach collection="list" item="item" index="index"
			separator=",">
			<trim prefix="(" suffix=")" suffixOverrides=",">
				<#list columns as being>
					<#if primaryKey.identity>
						<#if primaryKey.propertyName != being.propertyName>
							${r'#'}{item.${being.propertyName}},
						</#if>
					<#else>
						${r'#'}{item.${being.propertyName}},
					</#if>
    			</#list>
			</trim>
		</foreach>
	</insert>
  
  	<!--更新-->
  	<update id="updateByPrimaryKey" parameterType="${packageName}.domain.${domainName}Domain" >
    	update `${tableName}`
   	<set >
    <#list columns as being>
		<if test="${being.propertyName} != null" >
		    `${being.name}` = ${r'#'}{${being.propertyName}},
		</if>
	</#list>
    </set>
    	where `${primaryKey.columnName}` = ${r'#'}{${primaryKey.propertyName}}
  	</update>
  
  	<!--通用查询条件-->
  	<sql id="selectWhereSql" >
    	<trim prefix="where" prefixOverrides="and |or" >
    		<#list columns as being>
	   		<if test="${being.propertyName} != null" >
				and a.`${being.name}` = ${r'#'}{${being.propertyName}}
	   		</if>
			</#list>
	
			<#if primaryKey??>
	   		<if test="idList != null" >
				and a.`${primaryKey.columnName}` in
				<foreach item="item" index="index" collection="idList"
	      			open="(" separator="," close=")">
	        		${r'#'}{item}
	   			</foreach>
	   		</if>
			</#if>
    	</trim>
  	</sql>
  	
  	
  	<!--查询单个对象-->
  	<select id="getOne" resultType="${packageName}.domain.${domainName}Domain" parameterType="${dto.packageName}.${domainName}Query" >
    	<include refid="selectSql" />
    	<include refid="selectWhereSql" />
  	</select>
  
  	<!--查询列表-->
 	<select id="getList" resultType="${packageName}.domain.${domainName}Domain" parameterType="${dto.packageName}.${domainName}Query" >
  		<!-- 分页开始 -->
		<include refid="global.pageStart" />
		<!-- 查询语句 -->
    	<include refid="selectSql" />
   		<!-- 查询条件 -->
    	<include refid="selectWhereSql" />
    	<!-- 分页排序语句 -->
		<include refid="global.globalSortsql" />
		<!-- 分页结束 -->
		<include refid="global.pageEnd" />
  	</select>
  
  	<!--查询总数-->
  	<select id="getListCount" resultType="java.lang.Integer" parameterType="${dto.packageName}.${domainName}Query" >
    	select count(1) from `${tableName}` as a
    	<include refid="selectWhereSql" />
  	</select>
  
</mapper>