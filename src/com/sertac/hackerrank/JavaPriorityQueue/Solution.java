package com.sertac.hackerrank.JavaPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */

class Priorities {

	public List<Student> getStudents(List<String> events) {
		List<Student> studentList = new ArrayList<Student>();

		Comparator<Student> comparator = Comparator.comparing(Student::getCgpa).reversed()
				.thenComparing(Student::getName).thenComparing(Student::getId);

		PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(comparator);
		int id = 0;

		for (String string : events) {
			String[] event = string.split(" ");
			if ("ENTER".equals(event[0])) {
				priorityQueue.add(new Student(id, event[1], Double.parseDouble(event[2]), Integer.parseInt(event[3])));
				id++;
			} else if ("SERVED".equals(event[0])) {
				priorityQueue.poll();
			}
		}

		while (priorityQueue.size() > 0) {
			studentList.add(priorityQueue.poll());
		}

		return studentList;
	}

}

class Student {
	private int id;
	private String name;
	private double cgpa;
	private int priority;

	public Student(int id, String name, double cgpa, int priority) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}