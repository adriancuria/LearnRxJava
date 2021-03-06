package com.dbbyte.rxjava1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Launcher47 {

	// reduce()

	/*
	 * The reduce() operator is syntactically identical to scan(), but it only emits
	 * the final accumulation when the source calls onComplete(). Depending on which
	 * overload you use, it can yield Single or Maybe.
	 */

	public static void main(String[] args) {

		Observable.just(5, 3, 7, 10, 2, 14).reduce((total, next) -> total + next)
				.subscribe(s -> System.out.println("Received: " + s));

		/*
		 * Similar to scan(), there is a seed argument that you can provide that will
		 * serve as the initial value to accumulate on.
		 */

		Observable.just(5, 3, 7, 10, 2, 14).reduce("", (total, next) -> total + (total.equals("") ? "" : ",") + next)
				.subscribe(s -> System.out.println("Received: " + s));

		/*
		 * Your seed value should be immutable, such as an integer or string. Bad
		 * side-effects can happen if it is mutable, and you should use collect() (or
		 * seedWith()) for these cases, which we will cover in a moment. For instance,
		 * if you want to reduce T emissions into a collection, such as List<T>, use
		 * collect() instead of reduce(). Using reduce() will have an undesired
		 * side-effect of using the same list for each subscription, rather than
		 * creating a fresh, empty one each time.
		 */

	}

}
