/**
 * 
 */
package com.tour.sb.ms.domain;

/**
 * @author amit
 *
 * Enumeration of the region of California.
 */
public enum Region {

	Central_Coast("Central Coast"), Southern_California("Southern California"),
	Northern_California("Northern California"), Varies("Varies");

	private String label;

	private Region(String label) {
		this.label = label;
	}

	public static Region findByLabel(String byLAbel) {

		for (Region r : Region.values()) {
			if (r.label.equalsIgnoreCase(byLAbel)) {
				return r;
			}
		}

		return null;
	}
}
