package hhm.neha.model;

import java.util.List;

public class Batch_timelineModel {
	public int next;
	public String time;
	public int total;
	public List<Batch_timeline_pointsModel> points;

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Batch_timeline_pointsModel> getPoints() {
		return points;
	}

	public void setPoints(List<Batch_timeline_pointsModel> points) {
		this.points = points;
	}
}
