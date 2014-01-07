package com.cognifide.slice.cq.module;

/*
 * #%L
 * Slice - CQ Add-on
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 Cognifide Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.cognifide.slice.api.scope.ContextScoped;
import com.cognifide.slice.commons.provider.SliceResourceProvider;
import com.cognifide.slice.cq.mapper.processor.ImageFieldProcessor;
import com.cognifide.slice.mapper.MapperBuilder;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.cognifide.slice.mapper.api.Mapper;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;

/**
 * The module is responsible for finding all classes annotated by {@link SliceResource}. Found classes are
 * bound to their {@link SliceResourceProvider} providers
 * 
 */
public class CQMapperModule extends AbstractModule {

	@Inject
	private MapperBuilder mapperBuilder;
	
	@Override
	protected void configure() {
	}

	/**
	 * Builds and provides {@link Mapper}
	 * 
	 * @return
	 */
	@Provides
	@ContextScoped
	public Mapper getMapper() {
		return mapperBuilder.addDefaultSliceProcessors().addFieldProcessor(new ImageFieldProcessor()).build();
	}

}