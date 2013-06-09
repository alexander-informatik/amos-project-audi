package de.osramos.ss13.proj1.form;

import de.osramos.ss13.proj1.model.Taskdb;

public class TaskCompletionPasswordForm {

	public long taskid;
	public String completionPassword;

	public String getCompletionPassword() {
		return completionPassword;
	}

	public void setCompletionPassword(String completionPassword) {
		this.completionPassword = completionPassword;
	}

	public long getTaskid() {
		return taskid;
	}

	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}
	

}
