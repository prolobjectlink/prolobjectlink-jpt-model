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
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@Entity(name = "polygon")
@SqlResultSetMapping(name = "PolygonResults", entities = { @EntityResult(entityClass = Polygon.class, fields = {
		@FieldResult(name = "id", column = "Id"), @FieldResult(name = "segment0", column = "Segment0"),
		@FieldResult(name = "segment1", column = "Segment1"),
		@FieldResult(name = "segment2", column = "Segment2") }) }, columns = { @ColumnResult(name = "id") })
public class Polygon {

	@Id
	protected String id;
	protected Segment segment0;
	protected Segment segment1;
	protected Segment segment2;

	public Polygon() {
	}

	public Polygon(String id) {
		this.id = id;
	}

	public Polygon(Segment segment0, Segment segment1, Segment segment2) {
		this.segment0 = segment0;
		this.segment1 = segment1;
		this.segment2 = segment2;
	}

	public Polygon(String id, Segment segment0, Segment segment1, Segment segment2) {
		this.id = id;
		this.segment0 = segment0;
		this.segment1 = segment1;
		this.segment2 = segment2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Segment getSegment0() {
		return segment0;
	}

	public void setSegment0(Segment segment0) {
		this.segment0 = segment0;
	}

	public Segment getSegment1() {
		return segment1;
	}

	public void setSegment1(Segment segment1) {
		this.segment1 = segment1;
	}

	public Segment getSegment2() {
		return segment2;
	}

	public void setSegment2(Segment segment2) {
		this.segment2 = segment2;
	}

	@Override
	public String toString() {
		return "Polygon [id=" + id + ", segment0=" + segment0 + ", segment1=" + segment1 + ", segment2=" + segment2
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((segment0 == null) ? 0 : segment0.hashCode());
		result = prime * result + ((segment1 == null) ? 0 : segment1.hashCode());
		result = prime * result + ((segment2 == null) ? 0 : segment2.hashCode());
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
		Polygon other = (Polygon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (segment0 == null) {
			if (other.segment0 != null)
				return false;
		} else if (!segment0.equals(other.segment0))
			return false;
		if (segment1 == null) {
			if (other.segment1 != null)
				return false;
		} else if (!segment1.equals(other.segment1))
			return false;
		if (segment2 == null) {
			if (other.segment2 != null)
				return false;
		} else if (!segment2.equals(other.segment2))
			return false;
		return true;
	}

}
