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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@TableGenerator(name = "colSeq", allocationSize = 1000)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "colSeq")
	private Integer id;

	private String firstName;
	private String middleName;
	private String lastName;

	@Embedded
	private Address address;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> phones;
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<String> emails;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> nickNames;

	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	@Basic
	private int loginCount;

	// Constructors:

	public Person() {
		firstName = Randomizer.randomFirstName();
		middleName = Randomizer.randomMiddleName();
		lastName = Randomizer.randomLastName();

		phones = new ArrayList<String>(4);
		for (int i = Randomizer.randomInt(1, 3); i-- > 0;) {
			phones.add(Randomizer.randomPhone());
		}
		emails = new ArrayList<String>(4);
		for (int i = Randomizer.randomInt(1, 3); i-- > 0;) {
			emails.add(Randomizer.randomEmail());
		}
		nickNames = new HashSet<String>(4);
		for (int i = Randomizer.randomInt(1, 3); i-- > 0;) {
			nickNames.add(Randomizer.randomFirstName());
		}
		Date[] dates = Randomizer.randomDates(3);
		birthDate = dates[0];
		joinDate = dates[1];
		lastLoginDate = dates[2];
		loginCount = Randomizer.randomInt(1, 100);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(64);
		sb.append(firstName);
		if (middleName != null) {
			sb.append(' ').append(middleName);
		}
		sb.append(' ').append(lastName);
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Collection<String> getEmails() {
		return emails;
	}

	public void setEmails(Collection<String> emails) {
		this.emails = emails;
	}

	public Set<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Set<String> nickNames) {
		this.nickNames = nickNames;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

}
