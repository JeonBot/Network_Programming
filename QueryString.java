// 2016_10_20
// 3-2
// Assignment 3(Chapter 7, 8)
// Professor Jung
// This program is ... search for hongik in google.
// with DMoz.

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
	public class QueryString {
		private StringBuilder query = new StringBuilder();
		public QueryString() {}
		public synchronized void add(String name, String value) {
			query.append('?');
			encode(name, value);
		}
		private synchronized void encode(String name, String value) {
			try {
				query.append(URLEncoder.encode(name, "UTF-8"));
				query.append('=');
				query.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException ex) {
				throw new RuntimeException("Broken VM does not support UTF-8");
			}
		}
		public synchronized String getQuery() {
			return query.toString();
		}
		@Override
		public String toString() {
			return getQuery();
		}
}