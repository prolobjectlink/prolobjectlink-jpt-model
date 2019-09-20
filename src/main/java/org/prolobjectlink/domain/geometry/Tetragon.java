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
package org.prolobjectlink.domain.geometry;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;

@Entity(name = "tetragon")
@SqlResultSetMapping(name = "TetragonResults", entities = { @EntityResult(entityClass = Tetragon.class, fields = {
		@FieldResult(name = "id", column = "Id"), @FieldResult(name = "segment0", column = "Segment0"),
		@FieldResult(name = "segment1", column = "Segment1"), @FieldResult(name = "segment2", column = "Segment2"),
		@FieldResult(name = "segment3", column = "Segment3") }) }, columns = { @ColumnResult(name = "id") })
public class Tetragon extends Polygon {

	private Segment segment3;

	public Tetragon() {
	}

	public Tetragon(String id, Segment segment0, Segment segment1, Segment segment2, Segment segment3) {
		super(id, segment0, segment1, segment2);
		this.segment3 = segment3;
	}

	public Segment getSegment3() {
		return segment3;
	}

	public void setSegment3(Segment segment3) {
		this.segment3 = segment3;
	}

	@Override
	public String toString() {
		return "Tetragon [id=" + id + ", segment0=" + segment0 + ", segment1=" + segment1 + ", segment2=" + segment2
				+ ", segment3=" + segment3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((segment3 == null) ? 0 : segment3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tetragon other = (Tetragon) obj;
		if (segment3 == null) {
			if (other.segment3 != null)
				return false;
		} else if (!segment3.equals(other.segment3))
			return false;
		return true;
	}

}
