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

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public final class Randomizer {

	private Randomizer() {

	}

	static Random random = new Random();

	// Random Strings:

	public static String randomFirstName() {
		return randomString(2, 12);
	}

	public static String randomMiddleName() {
		return randomString(2, 12);
	}

	public static String randomLastName() {
		return randomString(6, 12);
	}

	public static String randomStreet() {
		return randomString(10, 20);
	}

	public static String randomCity() {
		return randomString(10, 20);
	}

	public static String randomState() {
		return randomString(2, 2);
	}

	public static String randomCountry() {
		return randomString(3, 15);
	}

	public static String randomZip() {
		return random.nextBoolean() ? randomNumString(5, 5) : randomNumString(9, 9);
	}

	public static String randomPhone() {
		return randomNumString(15, 15);
	}

	public static String randomEmail() {
		return randomString(3, 8) + "@" + randomString(3, 8) + "." + randomString(2, 3);
	}

	public static String randomString(int minLength, int maxLength) {
		return randomString(randomInt(minLength, maxLength), 'A', 'Z');
	}

	public static String randomNumString(int minLength, int maxLength) {
		return randomString(randomInt(minLength, maxLength), '0', '9');
	}

	static String randomString(int length, char from, char to) {
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = (char) randomInt(from, to);
		}
		return new String(chars);
	}

	// Random Dates:

	public static Date[] randomDates(int count) {
		Date[] dates = new Date[count];
		for (int i = 0; i < count; i++)
			dates[i] = randomDate();
		Arrays.sort(dates);
		return dates;
	}

	private static Date randomDate() {
		long time = (random.nextLong() & 0x1FFFFFFFFFFL) - 0xFFFFFFFFFFL;
		return new Date(time); // 1935 - 2004
	}

	// Random Numbers:

	public static int randomInt(int min, int max) {
		return max <= min ? min : (random.nextInt(max - min + 1) + min);
	}
}
