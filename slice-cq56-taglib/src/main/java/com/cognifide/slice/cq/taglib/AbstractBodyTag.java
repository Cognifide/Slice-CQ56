package com.cognifide.slice.cq.taglib;

/*
 * #%L
 * Slice - CQ Taglib
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


import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements {@link Tag} interface and provides common base for other tags.
 * 
 * @author Albert Cenkier
 * @author Jan Kuźniak
 */
public abstract class AbstractBodyTag extends BodyTagSupport {
	private static final long serialVersionUID = 1L;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** if false, tag does not render */
	private boolean render = true;

	/**
	 * Returns current request.
	 * 
	 * @return current request
	 */
	protected SlingHttpServletRequest getRequest() {
		return (SlingHttpServletRequest) pageContext.getRequest();
	}

	/**
	 * Returns current JSP writer.
	 * 
	 * @return current JSP writer
	 */
	protected JspWriter getJspWriter() {
		return pageContext.getOut();
	}

	/** @return the render */
	public boolean isRender() {
		return render;
	}

	/** @param render the render to set */
	public void setRender(boolean render) {
		this.render = render;
	}
}
