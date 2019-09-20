/*
 * #%L
 * prolobjectlink-jpt-model
 * %%
 * Copyright (C) 2019 Prolobjectlink Project
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the Prolobjectlink Project nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
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
