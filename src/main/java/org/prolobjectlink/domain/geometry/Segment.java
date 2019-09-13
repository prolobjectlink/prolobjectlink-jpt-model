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
package org.prolobjectlink.domain.geometry;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@Entity(name = "segment")
@SqlResultSetMapping(name = "SegmentResults", entities = { @EntityResult(entityClass = Segment.class, fields = {
		@FieldResult(name = "ids", column = "Ids"), @FieldResult(name = "point0", column = "Point0"),
		@FieldResult(name = "point1", column = "Point1") }) }, columns = { @ColumnResult(name = "ids") })
public class Segment {

	@Id
	private String ids;
	private Point point0;
	private Point point1;

	public Segment() {
	}

	public Segment(String ids) {
		this(ids, null, null);
	}

	public Segment(Point point0, Point point1) {
		this(null, point0, point1);
	}

	public Segment(String ids, Point point0, Point point1) {
		this.ids = ids;
		this.point0 = point0;
		this.point1 = point1;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Point getPoint0() {
		return point0;
	}

	public void setPoint0(Point point0) {
		this.point0 = point0;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	@Override
	public String toString() {
		return "Segment [ids=" + ids + ", point0=" + point0 + ", point1=" + point1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ids == null) ? 0 : ids.hashCode());
		result = prime * result + ((point0 == null) ? 0 : point0.hashCode());
		result = prime * result + ((point1 == null) ? 0 : point1.hashCode());
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
		Segment other = (Segment) obj;
		if (ids == null) {
			if (other.ids != null)
				return false;
		} else if (!ids.equals(other.ids)) {
			return false;
		}
		if (point0 == null) {
			if (other.point0 != null)
				return false;
		} else if (!point0.equals(other.point0)) {
			return false;
		}
		if (point1 == null) {
			if (other.point1 != null)
				return false;
		} else if (!point1.equals(other.point1)) {
			return false;
		}
		return true;
	}

}
