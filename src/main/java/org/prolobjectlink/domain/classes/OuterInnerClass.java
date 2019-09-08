/*
 * #%L
 * prolobjectlink-jpt-model
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Common Development and Distrubtion License as
 * published by the Sun Microsystems, either version 1.0 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the Common Development and Distrubtion
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-1.0.html>.
 * #L%
 */
package org.prolobjectlink.domain.classes;

public class OuterInnerClass {

	private int outer;

	public OuterInnerClass() {
	}

	public OuterInnerClass(int outer) {
		this.outer = outer;
	}

	@Override
	public String toString() {
		return "OuterClass [outer=" + outer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + outer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OuterInnerClass other = (OuterInnerClass) obj;
		if (outer != other.outer)
			return false;
		return true;
	}

	public Object newPrivateInnerClass() {
		return new PrivateInnerClass();
	}

	public Object newPrivateInnerClass(int inner) {
		return new PrivateInnerClass(inner);
	}

	public final class PublicInnerClass {

		private int inner;

		public PublicInnerClass() {
		}

		public PublicInnerClass(int inner) {
			this.inner = inner;
		}

		@Override
		public String toString() {
			return "InnerClass [inner=" + inner + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + inner;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof PublicInnerClass) {
				PublicInnerClass innerObj = (PublicInnerClass) obj;
				return inner == innerObj.inner;
			}
			return false;
		}

		private OuterInnerClass getOuterType() {
			return OuterInnerClass.this;
		}

	}

	private final class PrivateInnerClass {

		private int inner;

		private PrivateInnerClass() {
		}

		private PrivateInnerClass(int inner) {
			this.inner = inner;
		}

		@Override
		public String toString() {
			return "PrivateInnerClass [inner=" + inner + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + inner;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof PrivateInnerClass) {
				PrivateInnerClass innerObj = (PrivateInnerClass) obj;
				return inner == innerObj.inner;
			}
			return false;
		}

		private OuterInnerClass getOuterType() {
			return OuterInnerClass.this;
		}

	}

}
