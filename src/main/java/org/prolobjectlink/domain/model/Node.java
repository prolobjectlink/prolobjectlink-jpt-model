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

package org.prolobjectlink.domain.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Node {

	@Id
	Integer id;

	@Basic
	int changeCount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Node child1;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Node child2;

	public Node() {
	}

	public Node(int id) {
		this.id = Integer.valueOf(id);
	}

	public void setChild1(Node child1) {
		this.child1 = child1;
	}

	public Node getChild1() {
		return child1;
	}

	public void setChild2(Node child2) {
		this.child2 = child2;
	}

	public Node getChild2() {
		return child2;
	}

	public void load() {
		if (child1 != null) {
			child1.load();
		}
		if (child2 != null) {
			child2.load();
		}
	}

	public void update() {
		changeCount++;
		if (child1 != null) {
			child1.update();
		}
		if (child2 != null) {
			child2.update();
		}
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
