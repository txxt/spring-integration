/*
 * Copyright 2002-2016 the original author or authors.
 *
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
 */

package org.springframework.integration.file.filters;

import java.util.ArrayList;
import java.util.List;

/**
 * A convenience base class for any {@link FileListFilter} whose criteria can be
 * evaluated against each File in isolation. If the entire List of files is
 * required for evaluation, implement the FileListFilter interface directly.
 *
 * @author Mark Fisher
 * @author Iwein Fuld
 */
public abstract class AbstractFileListFilter<F> implements FileListFilter<F> {

	@Override
	public final List<F> filterFiles(F[] files) {
		List<F> accepted = new ArrayList<F>();
		if (files != null) {
			for (F file : files) {
				if (this.accept(file)) {
					accepted.add(file);
				}
			}
		}
		return accepted;
	}

	/**
	 * Subclasses must implement this method.
	 * @param file The file.
	 * @return true if the file passes the filter.
	 */
	protected abstract boolean accept(F file);

}